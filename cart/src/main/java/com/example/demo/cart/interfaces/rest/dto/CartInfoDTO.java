package com.example.demo.cart.interfaces.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/** CartInfoDTO */
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:59:38.273042+08:00[Asia/Taipei]")
public class CartInfoDTO extends RepresentationModel<CartInfoDTO> {
  @JsonProperty("cartNumber")
  private String cartNumber;

  @JsonProperty("customerName")
  private String customerName;

  @JsonProperty("price")
  private Integer price;

  @JsonProperty("products")
  @Valid
  private List<ProductInfoDTO> products = new ArrayList<>();

  public CartInfoDTO cartNumber(String cartNumber) {
    this.cartNumber = cartNumber;
    return this;
  }

  /**
   * Get cartNumber
   *
   * @return cartNumber
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Size(min = 1)
  public String getCartNumber() {
    return cartNumber;
  }

  public void setCartNumber(String cartNumber) {
    this.cartNumber = cartNumber;
  }

  public CartInfoDTO customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * Get customerName
   *
   * @return customerName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Size(min = 1)
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public CartInfoDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   *
   * @return price
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public CartInfoDTO products(List<ProductInfoDTO> products) {
    this.products = products;
    return this;
  }

  public CartInfoDTO addProductsItem(ProductInfoDTO productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   *
   * @return products
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public List<ProductInfoDTO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductInfoDTO> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartInfoDTO cartInfoDTO = (CartInfoDTO) o;
    return Objects.equals(this.cartNumber, cartInfoDTO.cartNumber)
        && Objects.equals(this.customerName, cartInfoDTO.customerName)
        && Objects.equals(this.price, cartInfoDTO.price)
        && Objects.equals(this.products, cartInfoDTO.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cartNumber, customerName, price, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartInfoDTO {\n");

    sb.append("    cartNumber: ").append(toIndentedString(cartNumber)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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
