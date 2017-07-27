package com.antivirus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SystemRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String OSname;
    private String bitSystem;
    private int spaceAmount;
    private String OSlanguage;
    private int RAM;

    @OneToMany (mappedBy = "systemRequirements")
    private List<Product> products;

    public SystemRequirements() {
    }

    public SystemRequirements(String OSname, String bitSystem, int spaceAmount, String OSlanguage, int RAM) {
        this.OSname = OSname;
        this.bitSystem = bitSystem;
        this.spaceAmount = spaceAmount;
        this.OSlanguage = OSlanguage;
        this.RAM = RAM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOSname() {
        return OSname;
    }

    public void setOSname(String OSname) {
        this.OSname = OSname;
    }

    public String getBitSystem() {
        return bitSystem;
    }

    public void setBitSystem(String bitSystem) {
        this.bitSystem = bitSystem;
    }

    public int getSpaceAmount() {
        return spaceAmount;
    }

    public void setSpaceAmount(int spaceAmount) {
        this.spaceAmount = spaceAmount;
    }

    public String getOSlanguage() {
        return OSlanguage;
    }

    public void setOSlanguage(String OSlanguage) {
        this.OSlanguage = OSlanguage;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SystemRequirements{" +
                "id=" + id +
                ", OSname='" + OSname + '\'' +
                ", bitSystem=" + bitSystem +
                ", spaceAmount=" + spaceAmount +
                ", OSlanguage='" + OSlanguage + '\'' +
                ", RAM=" + RAM +
                ", product=" + products +
                '}';
    }
}
