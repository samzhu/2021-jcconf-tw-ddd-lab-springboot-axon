package com.example.demo.cart.domain.model.entites;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartProduct {
  private String productId;
  private String tittle;
  private Integer price;
}
