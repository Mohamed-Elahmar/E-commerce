package com.ejada.ecommerce.shop_service_first.Services;

import com.ejada.ecommerce.shop_service_first.data.Cart;
import com.ejada.ecommerce.shop_service_first.data.Product;
import com.ejada.ecommerce.shop_service_first.Repository.CartRepository;
import com.ejada.ecommerce.shop_service_first.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServices{

    @Autowired
    private  CartRepository myCartRepository;
    @Autowired
    private  ProductRepository myProductRepository;

    public CartServices(CartRepository cartRepository, ProductRepository productRepository) {
        this.myCartRepository = cartRepository;
        this.myProductRepository = productRepository;
    }

    @Transactional
    public void addProductToCart(Long cartId, Long productId, double quantity) {
        Cart cart = myCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = myProductRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.addProduct(product ,quantity);
        // No need to explicitly save - changes are tracked by JPA
    }

    @Transactional
    public void removeProductFromCart(Long cartId, Long productId, Double quantity) {
        Cart cart = myCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = myProductRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.removeProduct(product, quantity);
    }

    @Transactional
    public Cart createCartForUser(Long userId) {
        Cart cart = new Cart(userId,0);
        return myCartRepository.save(cart);
    }
}
