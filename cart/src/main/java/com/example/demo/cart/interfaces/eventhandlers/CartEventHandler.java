package com.example.demo.cart.interfaces.eventhandlers;


import com.example.demo.cart.domain.events.CartCreatedEvent;
import com.example.demo.cart.domain.events.CartProductAddedEvent;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartEventHandler {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @EventHandler
  @Transactional(rollbackOn = Exception.class)
  public void on(CartCreatedEvent event) {
    log.debug("receive CartCreatedEvent event={}", event);
    String sql =
        "INSERT INTO cart (cart_number, customer_name, price) "
            + " VALUES (:cartNumber, :customerName, :price)";
    MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
    sqlParameterSource.addValue("cartNumber", event.getCartNumber());
    sqlParameterSource.addValue("customerName", event.getCustomerName());
    sqlParameterSource.addValue("price", event.getPrice());
    namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    log.debug("save projecttion success, cartNumber={}", event.getCartNumber());
  }

  @EventHandler
  @Transactional(rollbackOn = Exception.class)
  public void on(CartProductAddedEvent event) {
    log.debug("receive CartProductAddedEvent event={}", event);
    String sqlAddProduct =
        "INSERT INTO cart_product (cart_number, product_id, product_tittle, price) "
            + " VALUES (:cartNumber, :productId, :productTittle, :price)";
    String sqlUpdateCart = "UPDATE cart SET price=:price WHERE cart_number=:cartNumber";

    MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
    sqlParameterSource.addValue("cartNumber", event.getCartNumber());
    sqlParameterSource.addValue("productId", event.getAddCartProduct().getProductId());
    sqlParameterSource.addValue("productTittle", event.getAddCartProduct().getTittle());
    sqlParameterSource.addValue("price", event.getAddCartProduct().getPrice());
    namedParameterJdbcTemplate.update(sqlAddProduct, sqlParameterSource);
    log.debug(
        "save cart_product projecttion success, cartNumber={}, productId={}, productTittle={}",
        event.getCartNumber(),
        event.getAddCartProduct().getProductId(),
        event.getAddCartProduct().getTittle());

    sqlParameterSource = new MapSqlParameterSource();
    sqlParameterSource.addValue("cartNumber", event.getCartNumber());
    sqlParameterSource.addValue("price", event.getPrice());
    namedParameterJdbcTemplate.update(sqlUpdateCart, sqlParameterSource);
    log.debug(
        "update cart projecttion success, cartNumber={}, price={}",
        event.getCartNumber(),
        event.getPrice());
  }
}
