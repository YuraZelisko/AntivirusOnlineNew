package com.antivirus.controller;

import com.antivirus.dto.DtoUtilMapper;
import com.antivirus.dto.ProductDto;
import com.antivirus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by User on 7/26/2017.
 */
@RestController
public class RestProductController {
    private  final ProductService productService;

    @Autowired
    public RestProductController (ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/productSearch")
    public List<ProductDto> loadProducts(){
        return DtoUtilMapper.productsToProductsDto(productService.findAll());
    }
}
