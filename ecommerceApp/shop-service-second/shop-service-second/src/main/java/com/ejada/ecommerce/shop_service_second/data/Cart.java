package com.ejada.ecommerce.shop_service_second.data;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_seq",
            sequenceName = "cart_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_seq"
    )

    private Long id;
    private Long userId;
    private double totalPrice = 0;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    //*****************************************
    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }

    // Helper methods to manage the relationship
    public void addProduct(Product product , double quantity) {
        this.products.add(product);
        product.getCarts().add(this);
        double newQuantity = product.getQuantity()-quantity;
        product.setQuantity(newQuantity);
        this.totalPrice += (product.getPrice()*quantity);
    }

    public void removeProduct(Product product, double quantity) {
        this.products.remove(product);
        product.getCarts().remove(this);
        double newQuantity = product.getQuantity()+quantity;
        product.setQuantity(newQuantity);
        this.totalPrice -= (product.getPrice()*quantity);
    }
    //*****************************************


    public Cart() {}

    public Cart( Long userId, int totalPrice) {
        this.userId = userId;
        //this.id = id;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
