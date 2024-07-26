package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.IProductService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateProductRequest;
import dev.alperdonmez.ecommerceordermanagement.model.Product;
import dev.alperdonmez.ecommerceordermanagement.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
