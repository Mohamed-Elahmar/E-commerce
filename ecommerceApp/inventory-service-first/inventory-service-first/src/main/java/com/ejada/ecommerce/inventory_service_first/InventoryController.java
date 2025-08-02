package com.ejada.ecommerce.inventory_service_first;

import com.ejada.ecommerce.inventory_service_first.data.ProductResponce;
import com.ejada.ecommerce.inventory_service_first.proxy.ShopProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    ShopProxy myShopProxy;

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }

    @GetMapping("/inventory-service/all/products")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    List<ProductResponce> getAllProducts() {
        return myShopProxy.getAllProducts();
    }

    @DeleteMapping("/inventory-service/delete/product/productName/{productName}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean deleteProduct(@PathVariable("productName") String productName) {
        myShopProxy.deleteProdust( productName) ;
        return true;
    }

    @PostMapping("/inventory-service/make/product")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean makeProdust(@RequestBody ProductResponce newProductResponce){
        myShopProxy.makeProdust(newProductResponce);
        return true;
    }


}
