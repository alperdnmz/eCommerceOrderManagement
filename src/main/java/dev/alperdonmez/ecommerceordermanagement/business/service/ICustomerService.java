package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.CreateCustomerRequest;

public interface ICustomerService {
    void add(CreateCustomerRequest createCustomerRequest);
}
