package com.example.demo.cart.infrastructure.repositories;


import com.example.demo.cart.domain.projecttions.CartProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CartProductEntityRepository extends JpaRepository<CartProductEntity, Integer> {

  List<CartProductEntity> findByCartNumber(String cartNumber);

  @Override
  @RestResource(exported = false)
  CartProductEntity save(CartProductEntity s);

  @Override
  @RestResource(exported = false)
  void delete(CartProductEntity t);
}
