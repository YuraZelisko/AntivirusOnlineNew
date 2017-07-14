package com.antivirus.serviceImpl;

import com.antivirus.dao.ModulesIncludedDao;
import com.antivirus.dao.ProductDao;
import com.antivirus.dao.SystemRequirementsDao;
import com.antivirus.entity.ModulesIncluded;
import com.antivirus.entity.Product;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ModulesIncludedDao modulesIncludedDao;
    @Autowired
    private SystemRequirementsDao systemRequirementsDao;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    public void save(Product product, ArrayList<Integer> ids, MultipartFile image) {

        productDao.saveAndFlush(product);

        String path = System.getProperty("catalina.home") + "/resources/"
                + product.getName() + "/" + image.getOriginalFilename();

        product.setPathImage("resources/" + product.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        for (Integer id : ids) {
            ModulesIncluded modulesIncluded = modulesIncludedDao.modulesIncludedWithProducts(id);
            modulesIncluded.getProducts().add(product);
            modulesIncludedDao.save(modulesIncluded);
        }

//        sr = systemRequirementsDao.systemRequirementsWithProducts();
//        SystemRequirements systemRequirements = systemRequirementsDao.systemRequirementsWithProducts(index);
//        systemRequirements.getProducts().add(product);
//        systemRequirementsDao.save(systemRequirements);


        productDao.save(product);
    }

//    public void save(Product product, ArrayList<Integer> ids, SystemRequirements sr, MultipartFile image) {
//        System.out.println("ПОМИЛКА"+sr.getOSname());
//        productDao.saveAndFlush(product);
//        String path = System.getProperty("catalina.home") + "/resources/"
//                + product.getName() + "/" + image.getOriginalFilename();
//
//        product.setPathImage("resources/" + product.getName() + "/" + image.getOriginalFilename());
//
//            System.out.println("продукт"+product.getId());
//
//        File filePath = new File(path);
//
//        try {
//            filePath.mkdirs();
//            image.transferTo(filePath);
//        } catch (IOException e) {
//            System.out.println("error with file");
//        }
//
//
//        for (Integer d : ids) {
//            ModulesIncluded modulesIncluded = modulesIncludedDao.modulesIncludedWithProducts(d);
//            product.getModulesIncludeds().add(modulesIncluded);
//            modulesIncluded.getProducts().add(product);
//            modulesIncludedDao.save(modulesIncluded);
//        }
//
//        sr.getProducts().add(product);
//        systemRequirementsDao.save(sr);
//
//        productDao.save(product);
//
//    }

    @Override
    public List<Product> productIncludedWithModules() {
        return productDao.productIncludedWithModules();
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



//    @Override
//    public void save(Product product,  MultipartFile image) {
//        productDao.saveAndFlush(product);
//        String path = System.getProperty("catalina.home") + "/resources/"
//                + product.getName() + "/" + image.getOriginalFilename();
//        product.setPathImage("resources/" + product.getName() + "/" + image.getOriginalFilename());
//        File filePath = new File(path);
//
//        try {
//            filePath.mkdirs();
//            image.transferTo(filePath);
//        } catch (IOException e) {
//            System.out.println("error with file");
//        }
//
//        productDao.save(product);
//    }
}

