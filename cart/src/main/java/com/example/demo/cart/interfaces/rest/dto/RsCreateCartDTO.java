package com.example.demo.cart.interfaces.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/** 建立購物車回傳物件 */
@ApiModel(description = "建立購物車回傳物件")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:59:38.273042+08:00[Asia/Taipei]")
public class RsCreateCartDTO extends RepresentationModel<RsCreateCartDTO> {
  @JsonProperty("cartNumber")
  private String cartNumber;

  public RsCreateCartDTO cartNumber(String cartNumber) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RsCreateCartDTO rsCreateCartDTO = (RsCreateCartDTO) o;
    return Objects.equals(this.cartNumber, rsCreateCartDTO.cartNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cartNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RsCreateCartDTO {\n");

    sb.append("    cartNumber: ").append(toIndentedString(cartNumber)).append("\n");
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
