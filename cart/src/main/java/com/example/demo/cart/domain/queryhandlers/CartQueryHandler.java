package com.example.demo.cart.domain.queryhandlers;


import com.example.demo.cart.domain.model.aggregates.CartAggregate;
import com.example.demo.cart.domain.queries.FindCartQuery;
import com.example.demo.cart.interfaces.rest.dto.CartInfoDTO;
import com.example.demo.cart.interfaces.rest.dto.ProductInfoDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.Aggregate;
import org.axonframework.modelling.command.Repository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartQueryHandler {

  private final Repository<CartAggregate> eventRepository;

  @QueryHandler
  public CartInfoDTO handle(FindCartQuery query) {
    log.debug("Handling FindCartQuery query: {}", query);
    CartInfoDTO cartInfoDto = new CartInfoDTO();
    Aggregate<CartAggregate> cartAggregate = eventRepository.load(query.getCartNumber());
    cartAggregate.execute(
        aggregate -> {
          cartInfoDto.setCartNumber(aggregate.getCartNumber());
          cartInfoDto.setCustomerName(aggregate.getCustomerName());
          cartInfoDto.setPrice(aggregate.getPrice());
          List<ProductInfoDTO> products =
              aggregate.getCartProducts().values().stream()
                  .map(
                      cartProduct -> {
                        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                        productInfoDTO.setProductId(cartProduct.getProductId());
                        productInfoDTO.tittle(cartProduct.getTittle());
                        productInfoDTO.setPrice(cartProduct.getPrice());
                        return productInfoDTO;
                      })
                  .collect(Collectors.toList());
          cartInfoDto.setProducts(products);
        });
    return cartInfoDto;
  }
}
