package dev.alperdonmez.ecommerceordermanagement.webApi.controllers;

import dev.alperdonmez.ecommerceordermanagement.business.service.IProductService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
