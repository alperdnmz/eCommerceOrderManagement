package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateCustomerRequest;

public interface ICustomerService {
    void add(CreateCustomerRequest createCustomerRequest);
}
