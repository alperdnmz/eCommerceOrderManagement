package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateCustomerRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetByIdCustomerResponse;

public interface ICustomerService {
    void add(CreateCustomerRequest createCustomerRequest);
    GetByIdCustomerResponse getById(int id);
}
