package dev.alperdonmez.ecommerceordermanagement.business.manager;

import dev.alperdonmez.ecommerceordermanagement.business.service.ICartService;
import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.create.CreateAddProductToCart;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.delete.DeleteProductFromCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.requests.update.UpdateCartRequest;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.CartItemResponse;
import dev.alperdonmez.ecommerceordermanagement.dto.responses.read.GetCartResponse;
import dev.alperdonmez.ecommerceordermanagement.model.Cart;
import dev.alperdonmez.ecommerceordermanagement.model.CartItem;
import dev.alperdonmez.ecommerceordermanagement.model.Customer;
import dev.alperdonmez.ecommerceordermanagement.model.Product;
import dev.alperdonmez.ecommerceordermanagement.repository.ICartItemRepository;
import dev.alperdonmez.ecommerceordermanagement.repository.ICartRepository;
import dev.alperdonmez.ecommerceordermanagement.repository.IProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartManager implements ICartService {

    private ICartRepository cartRepository;
    private IModelMapperService modelMapperService;
    private IProductRepository productRepository;
    private ICartItemRepository cartItemRepository;

    @Autowired
    public CartManager(ICartRepository cartRepository, IModelMapperService modelMapperService, IProductRepository productRepository, ICartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public GetCartResponse getCartByCustomerId(int customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Customer customer = cart.getCustomer();

        List<CartItemResponse> items = cart.getCartItems().stream()
                .map(cartItem -> { CartItemResponse cartItemsResponse = new CartItemResponse();
                    cartItemsResponse.setProductId(cartItem.getProduct().getId());
                    cartItemsResponse.setProductName(cartItem.getProduct().getName());
                    cartItemsResponse.setQuantity(cartItem.getQuantity());
                    cartItemsResponse.setPurchasePrice(cartItem.getPurchasePrice());
                    return cartItemsResponse;
                }).collect(Collectors.toList());


        GetCartResponse cartResponse = new GetCartResponse();
        cartResponse.setId(cart.getId());
        cartResponse.setCustomerId(customer.getId());
        cartResponse.setCustomerFirstName(customer.getFirstName());
        cartResponse.setCustomerLastName(customer.getLastName());
        cartResponse.setCartItemsResponseList(items);
        cartResponse.setTotalPrice(cart.getTotalPrice());

        return cartResponse;
    }

    @Override
    public void addProductToCart(CreateAddProductToCart createAddProductToCart) {
        Cart cart = cartRepository.findByCustomerId(createAddProductToCart.getCustomerId()).orElseThrow(() -> new RuntimeException("Cart Not Found!"));
        /*GetCartResponse productResponse = this.modelMapperService.forResponse().map(cart, GetCartResponse.class);
        Product product = modelMapperService.forRequest().map(productResponse, Product.class);*/
        Product product = productRepository.findById(createAddProductToCart.getProductId()).orElseThrow(() -> new RuntimeException("Product Not Found!"));

        if((product.getQuantity() == 0) || (product.getQuantity() < createAddProductToCart.getQuantity())) {
            throw new RuntimeException("Product Quantity Exceeded!");
        }

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

        product.setQuantity(product.getQuantity() - createAddProductToCart.getQuantity());
        productRepository.save(product);

        double totalPrice = cart.getCartItems().stream()
                .mapToDouble(item -> item.getPurchasePrice() * item.getQuantity()).sum();
        cart.setTotalPrice(totalPrice);

        cartRepository.save(cart);
    }

    @Override
    public void deleteProductFromCart(DeleteProductFromCartRequest deleteProductFromCartRequest) {
        Cart cart = cartRepository.findByCustomerId(deleteProductFromCartRequest.getCustomerId()).orElseThrow(() -> new RuntimeException("Cart Not Found!"));

        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId() == deleteProductFromCartRequest.getProductId()).findFirst();

        if(existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            int quantity = cartItem.getQuantity();
            cart.getCartItems().remove(cartItem);

            Product product = cartItem.getProduct();
            product.setQuantity(product.getQuantity() + cartItem.getQuantity());
            productRepository.save(product);

            double totalPrice = cart.getCartItems().stream()
                    .mapToDouble(item -> item.getPurchasePrice() * item.getQuantity()).sum();
            cart.setTotalPrice(totalPrice);

            cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart Not Found!");
        }
    }

    @Override
    public void updateCart(UpdateCartRequest updateCartRequest) {
        CartItem cartItem = cartItemRepository.findByProductIdAndCartId(
                updateCartRequest.getCartId(), updateCartRequest.getProductId()
        ).orElseThrow(() -> new RuntimeException("CartItem Not Found For The Customer!"));

        /*Optional<CartItem> optionalCartItem = cartItemRepository.findCartItemByCartId(
                updateCartRequest.getCartItemId(), updateCartRequest.getCartId());

        CartItem cartItem = optionalCartItem.orElseThrow(() -> new RuntimeException("CartItem Not Found For The Customer!"));
*/
        //QUANTITY GUNCELLE
        if(updateCartRequest.getQuantity() != 0) {
            cartItem.setQuantity(updateCartRequest.getQuantity());
        }

        cartItemRepository.save(cartItem);
    }

    @Transactional
    public void deleteByCartId(int cartId) {
        cartItemRepository.deleteByCartId(cartId);
    }
}
