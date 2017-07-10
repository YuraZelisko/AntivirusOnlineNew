package com.antivirus.serviceImpl;

import com.antivirus.dao.ProductDao;
import com.antivirus.entity.Product;
import com.antivirus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @Override
    public void save(Product product, MultipartFile image) {
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

        productDao.save(product);


    }



//    public void save(Region region, MultipartFile image){
//
//        regionDao.saveAndFlush(region);
//
//        String path = System.getProperty("catalina.home") + "/resources/"
//                + region.getName() + "/" + image.getOriginalFilename();
//
//        region.setPathImage("resources/" + region.getName() + "/" + image.getOriginalFilename());
//

//    }
}

