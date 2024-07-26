package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateProductRequest;

public interface IProductService {
    void add(CreateProductRequest createProductRequest);
}
