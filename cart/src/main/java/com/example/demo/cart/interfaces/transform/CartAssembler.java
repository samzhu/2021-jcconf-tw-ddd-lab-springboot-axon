package com.example.demo.cart.interfaces.transform;


import com.example.demo.cart.domain.commands.AddCartProductCommand;
import com.example.demo.cart.domain.commands.CreateCartCommand;
import com.example.demo.cart.domain.model.entites.CartProduct;
import com.example.demo.cart.interfaces.rest.dto.RqAddProductDTO;
import com.example.demo.cart.interfaces.rest.dto.RqCreateCartDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class CartAssembler {

  public CreateCartCommand toCreateCartCommand(RqCreateCartDTO rqCreateCartDTO) {
    return new CreateCartCommand(
        RandomStringUtils.randomNumeric(6), rqCreateCartDTO.getCustomerName());
  }

  public AddCartProductCommand toAddCProductCommand(
      String cartNumber, RqAddProductDTO rqAddProductDTO) {
    return new AddCartProductCommand(
        cartNumber,
        CartProduct.builder()
            .productId(rqAddProductDTO.getProductId())
            .tittle(rqAddProductDTO.getTittle())
            .price(rqAddProductDTO.getPrice())
            .build());
  }
}
