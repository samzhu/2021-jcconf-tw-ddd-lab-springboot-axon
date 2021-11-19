package com.example.demo.cart.interfaces.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/** 新增商品回傳物件 */
@ApiModel(description = "新增商品回傳物件")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:41:33.022292+08:00[Asia/Taipei]")
public class RsAddProductDTO extends RepresentationModel<RsAddProductDTO> {
  @JsonProperty("cartNumber")
  private String cartNumber;

  @JsonProperty("customerName")
  private String customerName;

  @JsonProperty("price")
  private Integer price;

  public RsAddProductDTO cartNumber(String cartNumber) {
    this.cartNumber = cartNumber;
    return this;
  }

  /**
   * 購物車編號
   *
   * @return cartNumber
   */
  @ApiModelProperty(required = true, value = "購物車編號")
  @NotNull
  @Size(min = 1)
  public String getCartNumber() {
    return cartNumber;
  }

  public void setCartNumber(String cartNumber) {
    this.cartNumber = cartNumber;
  }

  public RsAddProductDTO customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * 消費者名稱
   *
   * @return customerName
   */
  @ApiModelProperty(required = true, value = "消費者名稱")
  @NotNull
  @Size(min = 1)
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public RsAddProductDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * 購物車價錢
   *
   * @return price
   */
  @ApiModelProperty(required = true, value = "購物車價錢")
  @NotNull
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RsAddProductDTO rsAddProductDTO = (RsAddProductDTO) o;
    return Objects.equals(this.cartNumber, rsAddProductDTO.cartNumber)
        && Objects.equals(this.customerName, rsAddProductDTO.customerName)
        && Objects.equals(this.price, rsAddProductDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cartNumber, customerName, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RsAddProductDTO {\n");

    sb.append("    cartNumber: ").append(toIndentedString(cartNumber)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
