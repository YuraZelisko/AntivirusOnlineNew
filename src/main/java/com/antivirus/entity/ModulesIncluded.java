package com.antivirus.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModulesIncluded {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "modules_product", joinColumns = @JoinColumn(name = "modules_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))

    private List<Product> products= new ArrayList<>();

    public ModulesIncluded() {
    }

    public ModulesIncluded(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ModulesIncluded{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }
}
