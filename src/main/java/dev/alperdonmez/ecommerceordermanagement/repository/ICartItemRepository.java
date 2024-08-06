package dev.alperdonmez.ecommerceordermanagement.repository;

import dev.alperdonmez.ecommerceordermanagement.model.CartItem;
import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem> findByProductIdAndCartId(int cartId, int productId);
    void deleteByCartId(int cartId);
}
