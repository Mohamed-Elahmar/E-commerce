package com.ejada.ecommerce.wallet_service_second.controllers;


import com.ejada.ecommerce.wallet_service_second.Proxy.CreateCartProxy;
import com.ejada.ecommerce.wallet_service_second.data.Order;
import com.ejada.ecommerce.wallet_service_second.data.User;
import com.ejada.ecommerce.wallet_service_second.data.Wallet;
import com.ejada.ecommerce.wallet_service_second.repos.OrderRepository;
import com.ejada.ecommerce.wallet_service_second.repos.UserRepository;
import com.ejada.ecommerce.wallet_service_second.repos.WalletRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class WalletController {
    @Autowired
    private CreateCartProxy myCreateCartProxy;

    @Autowired
    private UserRepository myUserRepository;

    @Autowired
    private WalletRepository myWalletRepository;

    @Autowired
    private OrderRepository myOrderRepository;


    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }

    @GetMapping("/wallet-service/Login/userName/{userName}/password/{password}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    boolean login(@PathVariable("userName") String userName, @PathVariable("password") String password) {

        User myUser = myUserRepository.findByName(userName);
        if (myUser == null) {throw new IllegalArgumentException() ; }
        else return Objects.equals(myUser.getPassword(), password);
    }

    @PostMapping("/wallet-service/Register")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public void registerNewUser(@RequestBody User user) {
        myUserRepository.save(user);
        myCreateCartProxy.makeCart(user.getId());
    }

    @PostMapping("/wallet-service/CreateWallet/User/{UserId}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public void CreateWallet( @PathVariable("UserId") Long id , @RequestBody Wallet wallet) {
        wallet.setWalletUser( myUserRepository.getReferenceById(id) );
        myWalletRepository.save(wallet);
    }

    @PutMapping("/wallet-service/Deposit/Walletid/{id}/quantity/{quantity}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean depositWallet(@PathVariable("id") Long id , @PathVariable("quantity") float quantity) {
        if(!(myWalletRepository.findById(id) == null)) {
            Optional<Wallet> wallet = myWalletRepository.findById(id);
            wallet.get().setWalletBalance(wallet.get().getWalletBalance() + quantity);
            myWalletRepository.save(wallet.get());
            return true;
        }
         return false;
    }

    @PutMapping("/wallet-service/withdraw/WalletId/{id}/quantity/{quantity}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public boolean withDrawWallet(@PathVariable("id") Long id, @PathVariable("quantity") float quantity ){
        if(!(myWalletRepository.findById(id) == null)) {
            Optional<Wallet> wallet = myWalletRepository.findById(id);
            wallet.get().setWalletBalance(wallet.get().getWalletBalance() - quantity);
            myWalletRepository.save(wallet.get());
            return true;
        }
        return false;
    }
//float price
    @PostMapping("/wallet-service/Transaction/UserId/{UserId}/orderPrice/{orderPrice}")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

    public void makeTransaction( @PathVariable("UserId") Long userId, @PathVariable float orderPrice) {
        Optional<User> orderUser = myUserRepository.findById(userId);
//        order.setUser(orderUser.get());
//        order.setPrice(orderPrice);
        Order newOrder = new Order(orderPrice);
        User oUser = myUserRepository.findById(userId).get();
        newOrder.setUser(oUser);
        myOrderRepository.save(newOrder);

    }

}
