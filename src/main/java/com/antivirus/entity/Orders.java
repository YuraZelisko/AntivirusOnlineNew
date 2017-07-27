package com.antivirus.entity;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateTime;
    private int quantity;
    private int totalPrice;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "orders_product", joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products= new ArrayList<>();

    @ManyToOne
    private  Region region;

    @ManyToMany
    @JoinTable(name = "delivery_orders", joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "delivery_id"))
    private List<DeliveryType> deliveryTypes= new ArrayList<>();


    public Orders() {
    }

    public Orders(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Orders(LocalDateTime dateTime, int quantity, int totalPrice, User user) {
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.user = user;

    }

    public int getId() {
        return id;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", products=" + products +
                '}';
    }

}
