package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.IProductService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.update.UpdateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetAllProductsResponse;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetByIdProductResponse;
import dev.alperdonmez.ecommerceordermanagement.model.Product;
import dev.alperdonmez.ecommerceordermanagement.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements IProductService {

    private IProductRepository productRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public ProductManager(IProductRepository productRepository, IModelMapperService modelMapperService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        Product product = this.productRepository.findById(id).orElseThrow();
        GetByIdProductResponse response = this.modelMapperService.forResponse().map(product, GetByIdProductResponse.class);
        return response;
    }

    @Override
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = this.productRepository.findAll();
        List<GetAllProductsResponse> responses = products.stream().map(product -> this.modelMapperService.forResponse().map(product, GetAllProductsResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public void update(@RequestBody() UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        this.productRepository.deleteById(id);
    }
}
