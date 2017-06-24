package com.antivirus.serviceImpl;

import com.antivirus.dao.ProductDao;
import com.antivirus.entity.Product;
import com.antivirus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findOne(int id) {
        return productDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }
}
