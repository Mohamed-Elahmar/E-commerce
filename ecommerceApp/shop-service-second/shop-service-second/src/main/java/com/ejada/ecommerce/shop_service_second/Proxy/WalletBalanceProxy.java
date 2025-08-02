package com.ejada.ecommerce.shop_service_second.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

//@FeignClient(name = "wallet-service", url="localhost:8000")
@FeignClient(name = "wallet-service")

public interface WalletBalanceProxy {

    @PutMapping("/wallet-service/withdraw/WalletId/{id}/quantity/{quantity}")
    public boolean withDrawWallet(@PathVariable("id") Long id, @PathVariable("quantity") float quantity );


    @PutMapping("/wallet-service/Deposit/Walletid/{id}/quantity/{quantity}")
    public boolean depositWallet(@PathVariable("id") Long id , @PathVariable("quantity") float quantity);


    @PostMapping("/wallet-service/Transaction/UserId/{UserId}/orderPrice/{orderPrice}")
    public void makeTransaction( @PathVariable("UserId") Long userId, @PathVariable float orderPrice);



}
