package com.example.demo.cart.infrastructure.repositories;


import com.example.demo.cart.domain.projecttions.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CartEntityRepository extends JpaRepository<CartEntity, String> {

  @Override
  @RestResource(exported = false)
  CartEntity save(CartEntity s);

  @Override
  @RestResource(exported = false)
  void delete(CartEntity t);
}
