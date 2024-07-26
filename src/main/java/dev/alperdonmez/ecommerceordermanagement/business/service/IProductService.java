package dev.alperdonmez.ecommerceordermanagement.business.service;

import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.delete.DeleteProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.update.UpdateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.getall.GetAllProductsResponse;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.getbyid.GetByIdProductResponse;

import java.util.List;

public interface IProductService {
    void add(CreateProductRequest createProductRequest);
    GetByIdProductResponse getById(int id);
    List<GetAllProductsResponse> getAll();
    void update(UpdateProductRequest updateProductRequest);
    void delete(int id);
}
