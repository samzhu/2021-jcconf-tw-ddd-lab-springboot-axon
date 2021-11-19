package com.example.demo.cart.interfaces.rest.impl;


import com.example.demo.cart.application.internal.commandservices.CartCommandService;
import com.example.demo.cart.application.internal.queryservices.CartQueryService;
import com.example.demo.cart.domain.commands.AddCartProductCommand;
import com.example.demo.cart.domain.commands.CreateCartCommand;
import com.example.demo.cart.interfaces.rest.CartApi;
import com.example.demo.cart.interfaces.rest.dto.CartInfoDTO;
import com.example.demo.cart.interfaces.rest.dto.RqAddProductDTO;
import com.example.demo.cart.interfaces.rest.dto.RqCreateCartDTO;
import com.example.demo.cart.interfaces.rest.dto.RsCreateCartDTO;
import com.example.demo.cart.interfaces.transform.CartAssembler;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@Api(tags = {"Cart"})
@RequiredArgsConstructor
public class CartController implements CartApi {

  private final CartAssembler cartAssembler;
  private final CartCommandService cartCommandService;
  private final CartQueryService cartQueryService;

  @Override
  public CompletableFuture<ResponseEntity<CartInfoDTO>> addCartProductV1(
      String cartNumber, @Valid RqAddProductDTO rqAddProductDTO) {
    AddCartProductCommand addCartProductCommand =
        cartAssembler.toAddCProductCommand(cartNumber, rqAddProductDTO);
    cartCommandService.addCartProduct(addCartProductCommand);

    CompletableFuture<CartInfoDTO> cartInfoFuture = cartQueryService.findEventStoreById(cartNumber);
    return cartInfoFuture.thenApply(
        result -> new ResponseEntity<CartInfoDTO>(result, HttpStatus.OK));
  }

  @Override
  public CompletableFuture<ResponseEntity<RsCreateCartDTO>> createCartV1(
      @Valid RqCreateCartDTO rqCreateCartDTO) {
    CreateCartCommand createCartCommand = cartAssembler.toCreateCartCommand(rqCreateCartDTO);
    CompletableFuture<String> cartNumberFuture = cartCommandService.createCart(createCartCommand);
    return cartNumberFuture.thenApply(
        cartNumber -> {
          RsCreateCartDTO rsCreateCartDTO = new RsCreateCartDTO();
          rsCreateCartDTO.setCartNumber(cartNumber);
          return new ResponseEntity<RsCreateCartDTO>(rsCreateCartDTO, HttpStatus.CREATED);
        });
  }

  @Override
  public CompletableFuture<ResponseEntity<List<Object>>> getCartHistory(String cartNumber) {
    return CompletableFuture.supplyAsync(
        () -> {
          return new ResponseEntity<List<Object>>(
              cartQueryService.listEvents(cartNumber), HttpStatus.OK);
        });
  }
}
