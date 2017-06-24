package com.antivirus.entity;

import javax.persistence.*;

@Entity
public class SystemRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String OSname;
    private boolean bitSystem;
    private int spaceAmount;
    private String OSlanguage;
    private int RAM;

    @ManyToOne
    private Product product;

    public SystemRequirements() {
    }

    public SystemRequirements(String OSname, boolean bitSystem, int spaceAmount, String OSlanguage, int RAM, Product product) {
        this.OSname = OSname;
        this.bitSystem = bitSystem;
        this.spaceAmount = spaceAmount;
        this.OSlanguage = OSlanguage;
        this.RAM = RAM;
        this.product = product;
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

    public boolean isBitSystem() {
        return bitSystem;
    }

    public void setBitSystem(boolean bitSystem) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
                ", product=" + product +
                '}';
    }
}
