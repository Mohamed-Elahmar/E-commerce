package com.ejada.ecommerce.inventory_service_first.proxy;

import com.ejada.ecommerce.inventory_service_first.data.ProductResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name="shop-service", url="localhost:8100")
@FeignClient(name="shop-service")

public interface ShopProxy {

    @GetMapping("/shop-service/all/products")
    public List<ProductResponce> getAllProducts();


    @DeleteMapping("/shop-service/delete/product/productName/{productName}")
    public boolean deleteProdust(@PathVariable String Name) ;

    @PostMapping("/shop-service/make/produst")
    public boolean makeProdust(@RequestBody ProductResponce newProductResponce) ;

}
