package com.ejada.ecommerce.inventory_service_first.data;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class ProductResponce {



    private Long id;
    private String name;
    private double price;
    private double quantity = 0;
    private double soldQuantity = 0;
    private String category;

    


    public double getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(double soldQuantity) {
        this.soldQuantity = soldQuantity;
    }



    public ProductResponce() {
    }

    public ProductResponce(Long id, String category, double soldQuantity, double quantity, double price, String name) {
        this.id = id;
        this.category = category;
        this.soldQuantity = soldQuantity;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
