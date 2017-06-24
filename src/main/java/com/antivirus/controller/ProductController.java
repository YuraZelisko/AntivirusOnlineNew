package com.antivirus.controller;

import com.antivirus.entity.Product;
import com.antivirus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by User on 5/31/2017.
 */
@Controller
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String orders(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("product", new Product());
        return "views-user-product";
    }
//
//    @PostMapping("/product")
//    public String orders(@ModelAttribute Product product){
//        productService.save(product);
//        return "redirect:/product";
//    }

//    @GetMapping("/deleteProduct/{id}")
//    public String delete (@PathVariable int id){
//        productService.delete(id);
//        return "redirect:/product";
//    }

}
