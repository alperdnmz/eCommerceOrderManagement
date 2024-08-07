package dev.alperdonmez.ecommerceordermanagement.repository;

import dev.alperdonmez.ecommerceordermanagement.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<CustomerOrder, Integer> {
    List<CustomerOrder> findByCustomerId(int customerId);
}
