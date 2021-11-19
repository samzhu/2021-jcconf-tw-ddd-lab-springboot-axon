package com.example.demo.cart.interfaces.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/** 建立購物車請求物件 */
@ApiModel(description = "建立購物車請求物件")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T20:59:38.273042+08:00[Asia/Taipei]")
public class RqCreateCartDTO extends RepresentationModel<RqCreateCartDTO> {
  @JsonProperty("customerName")
  private String customerName;

  public RqCreateCartDTO customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * 消費者姓名
   *
   * @return customerName
   */
  @ApiModelProperty(required = true, value = "消費者姓名")
  @NotNull
  @Size(min = 1)
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RqCreateCartDTO rqCreateCartDTO = (RqCreateCartDTO) o;
    return Objects.equals(this.customerName, rqCreateCartDTO.customerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RqCreateCartDTO {\n");

    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
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
