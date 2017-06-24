package com.antivirus.dao;

import com.antivirus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 5/25/2017.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
}
