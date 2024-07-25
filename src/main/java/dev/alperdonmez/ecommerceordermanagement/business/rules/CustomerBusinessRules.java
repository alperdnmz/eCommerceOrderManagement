package dev.alperdonmez.ecommerceordermanagement.business.rules;

import dev.alperdonmez.ecommerceordermanagement.core.exceptions.BusinessException;
import dev.alperdonmez.ecommerceordermanagement.repository.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {
    private ICustomerRepository customerRepository;

    public void checkIfCustomerEmailExists(String email) {
        if(this.customerRepository.existsByEmail(email)){
            throw new BusinessException("e-mail" + "("  + email + ")" + "already exists");
        }
    }
}
