package com.example.demo.cart.domain.events;


import com.example.demo.cart.domain.model.entites.CartProduct;
import lombok.Value;

/** 購物車商品已新增事件 */
@Value
public class CartProductAddedEvent {
  private String cartNumber;
  private Integer price;
  // 新增的商品
  private CartProduct addCartProduct;
}
