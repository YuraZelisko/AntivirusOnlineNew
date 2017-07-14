package com.antivirus.dao;

import com.antivirus.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by User on 5/25/2017.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("select distinct p from Product p left join fetch p.modulesIncludeds")
    List<Product> productIncludedWithModules();
}
