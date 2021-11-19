package com.example.demo.cart.domain.queries;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCartQuery {
  private String cartNumber;
}
