package com.antivirus.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DeliveryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime localDateTime;
    private double cost;
    private String deliveryServiceName;

    @ManyToOne
    private  Region region;

    @ManyToMany
    @JoinTable(name = "delivery_product", joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public DeliveryType() {
    }

    public DeliveryType(LocalDateTime localDateTime, double cost, String deliveryServiceName) {
        this.localDateTime = localDateTime;
        this.cost = cost;
        this.deliveryServiceName = deliveryServiceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDeliveryServiceName() {
        return deliveryServiceName;
    }

    public void setDeliveryServiceName(String deliveryServiceName) {
        this.deliveryServiceName = deliveryServiceName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", cost=" + cost +
                ", deliveryServiceName='" + deliveryServiceName + '\'' +
                ", region=" + region +
                ", products=" + products +
                '}';
    }
}
