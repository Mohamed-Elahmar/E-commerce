package com.ejada.ecommerce.shop_service_second;

import com.ejada.ecommerce.shop_service_second.Proxy.WalletBalanceProxy;
import com.ejada.ecommerce.shop_service_second.Repository.CartRepository;
import com.ejada.ecommerce.shop_service_second.Repository.ProductRepository;
import com.ejada.ecommerce.shop_service_second.Services.CartServices;
import com.ejada.ecommerce.shop_service_second.data.Cart;
import com.ejada.ecommerce.shop_service_second.data.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private WalletBalanceProxy myWalletBalanceProxy;

    @Autowired
    private ProductRepository myProductRepository;
    @Autowired
    private CartRepository myCartRepository;

    @Autowired
    private CartServices myCartServices = new CartServices(myCartRepository, myProductRepository);

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }

    @PostMapping("/shop-service/make/produst")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean makeProdust(@RequestBody Product newProduct) {
        myProductRepository.save(newProduct);
    return true;
    }

    @DeleteMapping("/shop-service/delete/product/productName/{productName}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    private boolean deleteProdust(@PathVariable String Name) {
        Product delProduct = myProductRepository.findByName(Name);
        myProductRepository.delete(delProduct);
        return true;
    }

    @PostMapping("/shop-service/make/cart/userId/{UserId}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean makeCart(@PathVariable Long UserId) {

        myCartServices.createCartForUser(UserId);
//        Cart myCart = new Cart( UserId , 0);
        return true;
    }

    @PutMapping("/shop-service/Cart/Add/CartId/{CartId}/productId/{productId}/quantity/{quantity}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean addToCart(@PathVariable Long CartId, @PathVariable Long productId, @PathVariable Double quantity) {

//        Product product = myProductRepository.findById(productId).get();
//
//        Optional<Cart> myCart = myCartRepository.findById(CartId);
//        myCart.get().setTotalPrice((product.getPrice())*quantity);
        myCartServices.addProductToCart(CartId, productId , quantity);
        return true;
    }

    @PutMapping("/shop-service/Cart/Remove/CartId/{CartId}/productId/{productId}/quantity/{quantity}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean removeFromCart(@PathVariable Long CartId, @PathVariable Long productId, @PathVariable Double quantity) {

//        Product product = myProductRepository.findById(productId).get();
//        Optional<Cart> myCart = myCartRepository.findById(CartId);
//        myCart.get().setTotalPrice((product.getPrice())*quantity);
        myCartServices.removeProductFromCart(CartId, productId , quantity);
        return true;
    }

    //product
    @PutMapping("/shop-service/buy/product/{productId}/wallet/{walletId}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean buyProduct(@PathVariable Long productId, @PathVariable Long walletId) {
        Product p = myProductRepository.findById(productId).get();
        p.setSoldQuantity(p.getSoldQuantity()+1);
        p.setQuantity(p.getQuantity()-1);
        myProductRepository.save(p);
        myWalletBalanceProxy.withDrawWallet(walletId, (float) p.getPrice());
        return true;
    }

    //cart
    @PutMapping("/shop-service/buy/cartId/{cartId}/walletId/{walletId}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean buyCart (@PathVariable  Long cartId, @PathVariable Long walletId){
        Cart c = myCartRepository.findById(cartId).get();
        float tp = (float) c.getTotalPrice();
        myWalletBalanceProxy.withDrawWallet(walletId, tp );
        c.setTotalPrice(0);
        myWalletBalanceProxy.makeTransaction( cartId, tp);
        myCartRepository.save(c);

        return true;
    }

    /////////////////////////////////////////////////////////
    @GetMapping("/shop-service/all/products")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public List<Product> getAllProducts() {
        List<Product> products = myProductRepository.findAll();
        return products;
    }



}
