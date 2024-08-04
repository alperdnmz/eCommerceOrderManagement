package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICartService;
import dev.alperdonmez.ecommerceordermanagement.business.service.ICustomerService;
import dev.alperdonmez.ecommerceordermanagement.business.service.IProductService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateAddProductToCart;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;
import dev.alperdonmez.ecommerceordermanagement.model.Cart;
import dev.alperdonmez.ecommerceordermanagement.model.CartItem;
import dev.alperdonmez.ecommerceordermanagement.model.Product;
import dev.alperdonmez.ecommerceordermanagement.repository.ICartRepository;
import dev.alperdonmez.ecommerceordermanagement.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartManager implements ICartService {

    //private final CustomerManager customerManager;
    private ICustomerService customerService;
    private ICartRepository cartRepository;
    private ICustomerRepository customerRepository;
    private IModelMapperService modelMapperService;
    private IProductService productService;

    @Autowired
    public CartManager(ICartRepository cartRepository, IModelMapperService modelMapperService, IProductService productService) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
        this.productService = productService;
    }

    @Override
    public GetCartResponse getCartByCustomerId(int customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));
        GetCartResponse response = this.modelMapperService.forResponse().map(cart, GetCartResponse.class);
        return response;

    }

    @Override
    public void addProductToCart(CreateAddProductToCart createAddProductToCart) {
        Cart cart = cartRepository.findByCustomerId(createAddProductToCart.getCustomerId()).orElseThrow(() -> new RuntimeException("Cart Not Found!"));
        GetCartResponse productResponse = this.modelMapperService.forResponse().map(cart, GetCartResponse.class);
        Product product = modelMapperService.forRequest().map(productResponse, Product.class);

        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId() == createAddProductToCart.getProductId()).findFirst();

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + createAddProductToCart.getQuantity());
            cartItem.setPurchasePrice(product.getPrice());
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(createAddProductToCart.getQuantity());
            cartItem.setPurchasePrice(product.getPrice());
            cart.getCartItems().add(cartItem);
        }

        double totalPrice = cart.getCartItems().stream()
                .mapToDouble(item -> item.getPurchasePrice() * item.getQuantity()).sum();
        cart.setTotalPrice(totalPrice);

        cartRepository.save(cart);
    }


}
