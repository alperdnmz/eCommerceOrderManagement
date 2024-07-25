package dev.alperdonmez.ecommerceordermanagement.repository;

import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);
}
