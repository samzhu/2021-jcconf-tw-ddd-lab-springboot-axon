package com.example.demo.cart.application.internal.queryservices;


import com.example.demo.cart.domain.projecttions.CartEntity;
import com.example.demo.cart.domain.queries.FindCartQuery;
import com.example.demo.cart.infrastructure.repositories.CartEntityRepository;
import com.example.demo.cart.infrastructure.repositories.CartProductEntityRepository;
import com.example.demo.cart.interfaces.rest.dto.CartInfoDTO;
import com.example.demo.cart.interfaces.rest.dto.ProductInfoDTO;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CartQueryService {

  private final QueryGateway queryGateway;
  private final EventStore eventStore;
  private final CartEntityRepository cartEntityRepository;
  private final CartProductEntityRepository cartProductEntityRepository;

  // 從 EventStore 重現聚合
  public CompletableFuture<CartInfoDTO> findEventStoreById(String cartNumber) {
    log.debug("findById {}", cartNumber);
    return this.queryGateway.query(
        new FindCartQuery(cartNumber), ResponseTypes.instanceOf(CartInfoDTO.class));
  }

  // 提供相關 Event
  public List<Object> listEvents(String cartNumber) {
    return this.eventStore.readEvents(cartNumber).asStream().collect(Collectors.toList());
  }

  public CartInfoDTO findRepositoryById(String cartNumber) {
    log.debug("findRepositoryById cartNumber={}", cartNumber);
    CartInfoDTO cartInfoDTO = new CartInfoDTO();
    CartEntity cartEntity = this.cartEntityRepository.findById(cartNumber).orElse(null);
    if (null != cartEntity) {
      cartInfoDTO.setCartNumber(cartEntity.getCartNumber());
      cartInfoDTO.setCustomerName(cartEntity.getCustomerName());
      cartInfoDTO.setPrice(cartEntity.getPrice());
      cartInfoDTO.setProducts(
          cartProductEntityRepository.findByCartNumber(cartNumber).stream()
              .map(
                  cartProduct -> {
                    ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                    productInfoDTO.setProductId(cartProduct.getProductId());
                    productInfoDTO.setTittle(cartProduct.getProductTittle());
                    productInfoDTO.setPrice(cartProduct.getPrice());
                    return productInfoDTO;
                  })
              .collect(Collectors.toList()));
    }
    return cartInfoDTO;
  }
}
