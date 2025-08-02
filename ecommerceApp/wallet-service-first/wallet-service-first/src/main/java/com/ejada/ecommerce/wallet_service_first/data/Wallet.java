package com.ejada.ecommerce.wallet_service_first.data;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @SequenceGenerator(
            name = "wallet_seq",
            sequenceName = "wallet_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_seq"
    )
    private Long id;

    private String visaNumber;
    private float walletBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User walletUser;

    public void setUser(User walletUser) {
        this.walletUser = walletUser;
    }

    public Wallet() {}
//    public Wallet(  String visaNumber, float walletBalance) {}

    public Wallet(String visaNumber, float walletBalance) {
        this.visaNumber = visaNumber;
        this.walletBalance = walletBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(float walletBalance) {
        this.walletBalance = walletBalance;
    }

    public User getWalletUser() {
        return walletUser;
    }

    public void setWalletUser(User walletUser) {
        this.walletUser = walletUser;
    }
}
