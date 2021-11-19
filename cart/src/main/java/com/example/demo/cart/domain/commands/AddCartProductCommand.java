package com.example.demo.cart.domain.commands;


import com.example.demo.cart.domain.model.entites.CartProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class AddCartProductCommand {
  @TargetAggregateIdentifier private String cartNumber;
  private CartProduct addCartProduct;
}
