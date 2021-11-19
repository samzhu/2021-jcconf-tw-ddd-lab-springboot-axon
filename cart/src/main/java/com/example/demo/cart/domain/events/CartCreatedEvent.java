package com.example.demo.cart.domain.events;


import com.example.demo.cart.domain.model.entites.CartProduct;
import java.util.Map;
import lombok.Value;

/** 購物車已建立事件 */
@Value
public class CartCreatedEvent {
  private String cartNumber;
  private String customerName;
  private Integer price;
  private Map<String, CartProduct> cartProducts;
}
