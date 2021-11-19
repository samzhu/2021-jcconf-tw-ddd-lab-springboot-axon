package com.example.demo.cart.domain.model.aggregates;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.example.demo.cart.domain.commands.AddCartProductCommand;
import com.example.demo.cart.domain.commands.CreateCartCommand;
import com.example.demo.cart.domain.events.CartCreatedEvent;
import com.example.demo.cart.domain.events.CartProductAddedEvent;
import com.example.demo.cart.domain.model.entites.CartProduct;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Getter
@Slf4j
// Axon provided annotation for marking Cart as an Aggregate
@Aggregate(snapshotTriggerDefinition = "snapshotTrigger")
public class CartAggregate {
  // Axon provided annotation for marking the cartNumber as the Aggregate Identifier
  @AggregateIdentifier private String cartNumber;
  private String customerName;
  private Integer price;
  private Map<String, CartProduct> cartProducts;
  // 註解該 Aggregate 的 Command 處理方法，可以是建構子也可以是普通方法，傳入可以處理的 Command 類別
  @CommandHandler
  public CartAggregate(CreateCartCommand command) {
    log.debug("Aggregate CreateCartCommand aggregate={}, command={}", this, command);
    apply(
        new CartCreatedEvent(
            command.getCartNumber(),
            command.getCustomerName(),
            0,
            new HashMap<String, CartProduct>()));
  }
  // 更改聚合實例狀態的事件處理方法應使用 EventSourcingHandler
  @EventSourcingHandler
  public void on(CartCreatedEvent event) {
    log.debug("Aggregate CartCreatedEvent aggregate={}, event={}", this, event);
    this.cartNumber = event.getCartNumber();
    this.customerName = event.getCustomerName();
    this.price = event.getPrice();
    this.cartProducts = event.getCartProducts();
  }

  @CommandHandler
  public void on(AddCartProductCommand command) {
    log.debug("Aggregate AddCartProductCommand aggregate={}, command={}", this, command);
    // 在 CommandHandler 處理需要的商業邏輯 ex: 已加過的商品無法再加入
    if (this.cartProducts.get(command.getAddCartProduct().getProductId()) != null) {
      throw new RuntimeException(
          String.format("無法加入 已存在之商品 id=%s", command.getAddCartProduct().getProductId()));
    } else {
      Integer newPrice = this.price + command.getAddCartProduct().getPrice();
      apply(
          new CartProductAddedEvent(
              command.getCartNumber(), newPrice, command.getAddCartProduct()));
    }
  }

  @EventSourcingHandler
  public void on(CartProductAddedEvent event) {
    log.debug("Aggregate CartProductAddedEvent aggregate={}, event={}", this, event);
    this.price = event.getPrice();
    CartProduct addCartProduct = event.getAddCartProduct();
    this.cartProducts.put(addCartProduct.getProductId(), addCartProduct);
  }
}
