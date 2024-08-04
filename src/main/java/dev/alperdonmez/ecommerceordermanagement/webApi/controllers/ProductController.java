package dev.alperdonmez.ecommerceordermanagement.webApi.controllers;

import dev.alperdonmez.ecommerceordermanagement.business.service.IProductService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.update.UpdateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetAllProductsResponse;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetByIdProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private IProductService productService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateProductRequest createProductRequest) {
        this.productService.add(createProductRequest);
    }

    @GetMapping("{id}")
    public GetByIdProductResponse getById(@PathVariable int id) {
        return productService.GetByIdProduct(id);
    }

    @GetMapping
    public List<GetAllProductsResponse> getAll() {
        return productService.getAll();
    }

    @PutMapping
    public void update(@RequestBody UpdateProductRequest updateProductRequest) {
        this.productService.update(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.productService.delete(id);
    }
}
