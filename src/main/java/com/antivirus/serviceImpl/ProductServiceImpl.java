package com.antivirus.serviceImpl;

import com.antivirus.dao.ModulesIncludedDao;
import com.antivirus.dao.ProductDao;
import com.antivirus.dao.SystemRequirementsDao;
import com.antivirus.entity.ModulesIncluded;
import com.antivirus.entity.Product;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.ProductService;
import com.antivirus.validator.Validator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    @Qualifier("productValidator")
    private Validator validator;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    public void save(Product product, ArrayList<Integer> ids, MultipartFile image) throws Exception {
        validator.validate(product);
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
        productDao.save(product);
    }

    public void update(Product product,  MultipartFile image) throws Exception{
//        productDao.saveAndFlush(product);
            validator.validateUpd(product);
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

//        ArrayList<Integer> ids,
//        for (Integer id : ids) {
//            ModulesIncluded modulesIncluded = modulesIncludedDao.modulesIncludedWithProducts(id);
//            modulesIncluded.getProducts().add(product);
//            modulesIncludedDao.save(modulesIncluded);
//        }
        productDao.save(product);
    }

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
    public void update(Product product) throws Exception {
        validator.validateUpd(product);
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

