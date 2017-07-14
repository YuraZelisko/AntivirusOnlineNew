package com.antivirus.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DeliveryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int daysToArrive;
    private double cost;
    private String deliveryServiceName;

    @ManyToOne
    private  Region region;

    @ManyToMany
    @JoinTable(name = "delivery_orders", joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Orders> orders= new ArrayList<>();

    public DeliveryType() {
    }

    public DeliveryType(int daysToArrive, double cost, String deliveryServiceName, Region region) {
        this.daysToArrive = daysToArrive;
        this.cost = cost;
        this.deliveryServiceName = deliveryServiceName;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDaysToArrive() {
        return daysToArrive;
    }

    public void setDaysToArrive(int daysToArrive) {
        this.daysToArrive = daysToArrive;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", daysToArrive=" + daysToArrive +
                ", cost=" + cost +
                ", deliveryServiceName='" + deliveryServiceName + '\'' +
                ", region=" + region +
                ", orders=" + orders +
                '}';
    }
}
