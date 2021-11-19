package com.example.demo.cart.interfaces.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/** 新增商品請求物件 */
@ApiModel(description = "新增商品請求物件")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:59:38.273042+08:00[Asia/Taipei]")
public class RqAddProductDTO extends RepresentationModel<RqAddProductDTO> {
  @JsonProperty("productId")
  private String productId;

  @JsonProperty("tittle")
  private String tittle;

  @JsonProperty("price")
  private Integer price;

  public RqAddProductDTO productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * 商品 ID
   *
   * @return productId
   */
  @ApiModelProperty(required = true, value = "商品 ID")
  @NotNull
  @Size(min = 1)
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public RqAddProductDTO tittle(String tittle) {
    this.tittle = tittle;
    return this;
  }

  /**
   * 商品名稱
   *
   * @return tittle
   */
  @ApiModelProperty(required = true, value = "商品名稱")
  @NotNull
  @Size(min = 1)
  public String getTittle() {
    return tittle;
  }

  public void setTittle(String tittle) {
    this.tittle = tittle;
  }

  public RqAddProductDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * 商品金額
   *
   * @return price
   */
  @ApiModelProperty(required = true, value = "商品金額")
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
    RqAddProductDTO rqAddProductDTO = (RqAddProductDTO) o;
    return Objects.equals(this.productId, rqAddProductDTO.productId)
        && Objects.equals(this.tittle, rqAddProductDTO.tittle)
        && Objects.equals(this.price, rqAddProductDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, tittle, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RqAddProductDTO {\n");

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
