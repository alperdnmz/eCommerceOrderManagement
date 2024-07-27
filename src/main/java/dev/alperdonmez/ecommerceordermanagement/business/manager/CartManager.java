package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICartService;
import dev.alperdonmez.ecommerceordermanagement.business.service.ICustomerService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetByIdProductResponse;
import dev.alperdonmez.ecommerceordermanagement.model.Cart;
import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import dev.alperdonmez.ecommerceordermanagement.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartManager implements ICartService {

    private final CustomerManager customerManager;
    private ICustomerService customerService;
    private ICartRepository cartRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public CartManager(ICartRepository cartRepository, IModelMapperService modelMapperService, CustomerManager customerManager) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
        this.customerManager = customerManager;
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        Cart cart = cartRepository.getById(id);
        if(cart == null){
            return null;
        }
    }
}
