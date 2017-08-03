package com.antivirus.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private int price;
    private int quantityPC;
    private int licenceDurationYears;
    private int productQuantity;

    @ManyToMany
    @JoinTable(name = "orders_product", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Orders> orders= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "delivery_product", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "delivery_id"))
    private List<DeliveryType> deliveryTypes= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "modules_product", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "modules_id"))

    private List<ModulesIncluded> modulesIncludeds= new ArrayList<>();


    @ManyToOne
    private SystemRequirements systemRequirements;

    private String pathImage;

    public Product() {
    }

    public Product(String name, String description, int price, int quantityPC,
                   int licenceDurationYears) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productQuantity=1;
        this.quantityPC = quantityPC;
        this.licenceDurationYears= licenceDurationYears;
        }

    public Product(String name, String description, int price,int quantityPC,
                   int licenceDurationYears, List<ModulesIncluded> modulesIncludeds,
                   SystemRequirements systemRequirements, String pathImage) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityPC = quantityPC;
        this.productQuantity=1;
        this.licenceDurationYears = licenceDurationYears;
        this.modulesIncludeds = modulesIncludeds;
        this.systemRequirements = systemRequirements;
        this.pathImage = pathImage;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityPC() {
        return quantityPC;
    }

    public void setQuantityPC(int quantityPC) {
        this.quantityPC = quantityPC;
    }

    public int getLicenceDurationYears() {
        return licenceDurationYears;
    }

    public void setLicenceDurationYears(int licenceDurationYears) {
        this.licenceDurationYears = licenceDurationYears;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public SystemRequirements getSystemRequirements() {
        return systemRequirements;
    }

    public void setSystemRequirements(SystemRequirements systemRequirements) {
        this.systemRequirements = systemRequirements;
    }
    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityPC=" + quantityPC +
                ", licenceDurationYears=" + licenceDurationYears +
                ", productQuantity=" + productQuantity +
                ", orders=" + orders +
                ", deliveryTypes=" + deliveryTypes +
                ", users=" + users +
                ", modulesIncludeds=" + modulesIncludeds +
                ", systemRequirements=" + systemRequirements +
                ", pathImage='" + pathImage + '\'' +
                '}';
    }



}

