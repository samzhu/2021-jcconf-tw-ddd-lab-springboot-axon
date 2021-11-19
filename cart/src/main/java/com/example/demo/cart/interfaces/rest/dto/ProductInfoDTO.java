package com.example.demo.cart.interfaces.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/** ProductInfoDTO */
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:59:38.273042+08:00[Asia/Taipei]")
public class ProductInfoDTO extends RepresentationModel<ProductInfoDTO> {
  @JsonProperty("productId")
  private String productId;

  @JsonProperty("tittle")
  private String tittle;

  @JsonProperty("price")
  private Integer price;

  public ProductInfoDTO productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   *
   * @return productId
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Size(min = 1)
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public ProductInfoDTO tittle(String tittle) {
    this.tittle = tittle;
    return this;
  }

  /**
   * Get tittle
   *
   * @return tittle
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Size(min = 1)
  public String getTittle() {
    return tittle;
  }

  public void setTittle(String tittle) {
    this.tittle = tittle;
  }

  public ProductInfoDTO price(Integer price) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInfoDTO productInfoDTO = (ProductInfoDTO) o;
    return Objects.equals(this.productId, productInfoDTO.productId)
        && Objects.equals(this.tittle, productInfoDTO.tittle)
        && Objects.equals(this.price, productInfoDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, tittle, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInfoDTO {\n");

    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    tittle: ").append(toIndentedString(tittle)).append("\n");
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
