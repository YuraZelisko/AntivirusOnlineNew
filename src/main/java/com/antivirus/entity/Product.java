package com.antivirus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private double price;
    private int quantityPC;
    private boolean typeOfLinsence;
    private int linseceDurationYears;

    @ManyToMany
    @JoinTable(name = "orders_product", joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Orders> orders;

    @ManyToMany
    @JoinTable(name = "delivery_product", joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<DeliveryType> deliveryTypes;

    @ManyToMany
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<User> users;

    @OneToMany (mappedBy = "product")
    private List<ModulesIncluded> modulesIncludeds;

    @OneToMany (mappedBy = "product")
    private List<SystemRequirements> systemRequirements;

    public Product() {
    }

    public Product(String name, String description, double price,
                   int quantityPC, boolean typeOfLinsence, int linseceDurationYears) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityPC = quantityPC;
        this.typeOfLinsence = typeOfLinsence;
        this.linseceDurationYears = linseceDurationYears;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityPC() {
        return quantityPC;
    }

    public void setQuantityPC(int quantityPC) {
        this.quantityPC = quantityPC;
    }

    public boolean isTypeOfLinsence() {
        return typeOfLinsence;
    }

    public void setTypeOfLinsence(boolean typeOfLinsence) {
        this.typeOfLinsence = typeOfLinsence;
    }

    public int getLinseceDurationYears() {
        return linseceDurationYears;
    }

    public void setLinseceDurationYears(int linseceDurationYears) {
        this.linseceDurationYears = linseceDurationYears;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    public List<ModulesIncluded> getModulesIncludeds() {
        return modulesIncludeds;
    }

    public void setModulesIncludeds(List<ModulesIncluded> modulesIncludeds) {
        this.modulesIncludeds = modulesIncludeds;
    }

    public List<SystemRequirements> getSystemRequirements() {
        return systemRequirements;
    }

    public void setSystemRequirements(List<SystemRequirements> systemRequirements) {
        this.systemRequirements = systemRequirements;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityPC=" + quantityPC +
                ", typeOfLinsence=" + typeOfLinsence +
                ", linseceDurationYears=" + linseceDurationYears +
                ", orders=" + orders +
                ", deliveryTypes=" + deliveryTypes +
                ", modulesIncludeds=" + modulesIncludeds +
                ", systemRequirements=" + systemRequirements +
                '}';
    }
}

