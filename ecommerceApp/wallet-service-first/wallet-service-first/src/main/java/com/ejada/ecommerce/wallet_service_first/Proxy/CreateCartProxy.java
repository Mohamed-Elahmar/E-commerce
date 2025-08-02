package com.ejada.ecommerce.wallet_service_first.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(name="shop-service", url="localhost:8100")
@FeignClient(name="shop-service")
public interface CreateCartProxy {

    @PostMapping("/shop-service/make/cart/userId/{UserId}")
    public boolean makeCart(@PathVariable Long UserId);

}
