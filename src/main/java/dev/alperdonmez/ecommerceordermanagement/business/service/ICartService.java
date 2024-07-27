package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetByIdProductResponse;

public interface ICartService {
    GetByIdProductResponse getById(int id);
}
