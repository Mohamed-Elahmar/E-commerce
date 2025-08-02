package com.ejada.ecommerce.wallet_service_first.data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )
    private Long id;
    private String name;
    private String password;
//    private float walletBalance;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "walletUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wallet> wallets = new ArrayList<>();

    public User() {}

    public User(  String name, String password, float walletBalance) {
        //this.id = id;
        this.name = name;
        this.password = password;
//        this.walletBalance = walletBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public float getWalletBalance() {
//        return walletBalance;
//    }

//    public void setWalletBalance(float walletBalance) {
//        this.walletBalance = walletBalance;
//    }

//    haaaaam
    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
        wallet.setUser(this);
    }


}



//    @OneToMany(mappedBy = "customer")  // "customer" refers to the field in Order
//    private List<Order> orders = new ArrayList<>();  // Initialize to avoid NPE

    // Helper method to maintain consistency


    // ... getters/setters
