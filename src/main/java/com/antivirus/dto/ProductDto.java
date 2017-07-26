package com.antivirus.dto;

/**
 * Created by User on 7/26/2017.
 */
public class ProductDto {

    private int id;
    private String name;
    private String description;
    private double price;
    private int quantityPC;
    private int licenceDurationYears;
    private int productQuantity;
    private String pathImage;

    public ProductDto(){}

    public ProductDto(int id, String name, String description, double price, int quantityPC,
                      int licenceDurationYears, int productQuantity, String pathImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityPC = quantityPC;
        this.licenceDurationYears = licenceDurationYears;
        this.productQuantity = productQuantity;
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

    public int getLicenceDurationYears() {
        return licenceDurationYears;
    }

    public void setLicenceDurationYears(int licenceDurationYears) {
        this.licenceDurationYears = licenceDurationYears;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityPC=" + quantityPC +
                ", licenceDurationYears=" + licenceDurationYears +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
