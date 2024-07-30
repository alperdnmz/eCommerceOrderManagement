package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICartService;
import dev.alperdonmez.ecommerceordermanagement.business.service.ICustomerService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;
import dev.alperdonmez.ecommerceordermanagement.model.Cart;
import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import dev.alperdonmez.ecommerceordermanagement.repository.ICartRepository;
import dev.alperdonmez.ecommerceordermanagement.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartManager implements ICartService {

    private final CustomerManager customerManager;
    private ICustomerService customerService;
    private ICartRepository cartRepository;
    private ICustomerRepository customerRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public CartManager(ICartRepository cartRepository, IModelMapperService modelMapperService, CustomerManager customerManager) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
        this.customerManager = customerManager;
    }

    @Override
    public GetCartResponse getCartByCustomerId(int customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));
        GetCartResponse response = this.modelMapperService.forResponse().map(cart, GetCartResponse.class);
        return response;

    }

    @Override
    public void add(CreateCartRequest createCartRequest) {
        Cart cart =this.modelMapperService.forRequest().map(createCartRequest, Cart.class);
        this.cartRepository.save(cart);
    }
}
