package dev.alperdonmez.ecommerceordermanagement.repository;

import dev.alperdonmez.ecommerceordermanagement.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
}