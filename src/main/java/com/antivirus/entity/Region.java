package com.antivirus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(mappedBy = "region")
    private List<DeliveryType> deliveryTypes;

    private String pathImage;



    public Region() {
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Region(String name) {
        this.name = name;
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

    public List<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliveryTypes=" + deliveryTypes +
                '}';
    }
}
