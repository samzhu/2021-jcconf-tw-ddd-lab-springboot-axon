/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech Do not edit the class manually.
 */
package com.example.demo.cart.interfaces.rest;


import com.example.demo.cart.interfaces.rest.dto.CartInfoDTO;
import com.example.demo.cart.interfaces.rest.dto.RqAddProductDTO;
import com.example.demo.cart.interfaces.rest.dto.RqCreateCartDTO;
import com.example.demo.cart.interfaces.rest.dto.RsCreateCartDTO;
import io.swagger.annotations.*;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:59:38.273042+08:00[Asia/Taipei]")
@Validated
@Api(value = "Cart", description = "the Cart API")
public interface CartApi {

  /**
   * POST /cart/{cartNumber}/product : Add Cart Product 新增商品
   *
   * @param cartNumber 購物車編號 (required)
   * @param rqAddProductDTO (optional)
   * @return OK (status code 200)
   */
  @ApiOperation(
      value = "Add Cart Product",
      nickname = "addCartProductV1",
      notes = "新增商品",
      response = CartInfoDTO.class,
      tags = {
        "Cart",
      })
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CartInfoDTO.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/cart/{cartNumber}/product",
      produces = "application/json",
      consumes = "application/json")
  java.util.concurrent.CompletableFuture<ResponseEntity<CartInfoDTO>> addCartProductV1(
      @ApiParam(value = "購物車編號", required = true) @PathVariable("cartNumber") String cartNumber,
      @ApiParam(value = "") @Valid @RequestBody(required = false) RqAddProductDTO rqAddProductDTO);

  /**
   * POST /cart : Create Cart 建立購物車
   *
   * @param rqCreateCartDTO (optional)
   * @return Created (status code 201)
   */
  @ApiOperation(
      value = "Create Cart",
      nickname = "createCartV1",
      notes = "建立購物車",
      response = RsCreateCartDTO.class,
      tags = {
        "Cart",
      })
  @ApiResponses(
      value = {@ApiResponse(code = 201, message = "Created", response = RsCreateCartDTO.class)})
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/cart",
      produces = "application/json",
      consumes = "application/json")
  java.util.concurrent.CompletableFuture<ResponseEntity<RsCreateCartDTO>> createCartV1(
      @ApiParam(value = "") @Valid @RequestBody(required = false) RqCreateCartDTO rqCreateCartDTO);

  /**
   * GET /cart/{cartNumber}/history : Your GET endpoint 取得購物車歷史紀錄
   *
   * @param cartNumber 購物車編號 (required)
   * @return OK (status code 200)
   */
  @ApiOperation(
      value = "Your GET endpoint",
      nickname = "getCartHistory",
      notes = "取得購物車歷史紀錄",
      response = Object.class,
      responseContainer = "List",
      tags = {
        "Cart",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "OK",
            response = Object.class,
            responseContainer = "List")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/cart/{cartNumber}/history",
      produces = "application/json")
  java.util.concurrent.CompletableFuture<ResponseEntity<List<Object>>> getCartHistory(
      @ApiParam(value = "購物車編號", required = true) @PathVariable("cartNumber") String cartNumber);
}
