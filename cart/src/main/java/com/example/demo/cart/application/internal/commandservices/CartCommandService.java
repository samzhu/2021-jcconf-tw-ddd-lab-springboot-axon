package com.example.demo.cart.application.internal.commandservices;


import com.example.demo.cart.domain.commands.AddCartProductCommand;
import com.example.demo.cart.domain.commands.CreateCartCommand;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartCommandService {
  private final CommandGateway commandGateway;

  public CompletableFuture<String> createCart(CreateCartCommand createCartCommand) {
    log.debug("createCartCommand command={}", createCartCommand);
    // 回覆一個 CompletableFuture，不用等待 command 的執行，立刻返回。結果通過 future 取得。
    return commandGateway.send(createCartCommand);
  }

  public void addCartProduct(AddCartProductCommand addCartProductCommand) {
    log.debug("addCartProductCommand command={}", addCartProductCommand);
    // 直到 Command 執行完成返回結果，或者超時
    commandGateway.sendAndWait(addCartProductCommand);
  }
}
