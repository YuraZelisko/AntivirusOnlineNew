package com.antivirus.service;

import com.antivirus.entity.Product;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface ProductService {

    void save(Product product
    );
    List<Product> findAll();
    Product findOne(int id);
    void delete(int id);
    void update(Product product);
}
