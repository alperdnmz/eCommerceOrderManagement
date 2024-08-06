package dev.alperdonmez.ecommerceordermanagement.repository;

import dev.alperdonmez.ecommerceordermanagement.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
