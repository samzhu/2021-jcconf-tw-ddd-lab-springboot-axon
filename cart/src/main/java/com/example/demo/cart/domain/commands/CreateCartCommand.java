package com.example.demo.cart.domain.commands;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class CreateCartCommand {
  // Identifier to indicate on which Aggregate does the Command needs to be processed on
  @TargetAggregateIdentifier private String cartNumber;
  private String customerName;
}
