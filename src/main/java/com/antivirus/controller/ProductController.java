package com.antivirus.controller;

import com.antivirus.entity.ModulesIncluded;
import com.antivirus.entity.Product;
import com.antivirus.service.ModulesIncludedService;
import com.antivirus.service.ProductService;
import com.antivirus.service.RegionService;
import com.antivirus.service.SystemRequirementService;
import jdk.internal.cmm.SystemResourcePressureImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by User on 5/31/2017.
 */
@Controller
public class ProductController {


    @Autowired
    private ProductService productService;
    @Autowired
    private ModulesIncludedService modulesIncludedService;

    @Autowired
    SystemRequirementService systemRequirementService;

    @Autowired
    private RegionService regionService;


    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("product", new Product());
        model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
        model.addAttribute("systemRequirements", systemRequirementService.findAll());
        model.addAttribute("regions", regionService.findAll());
        return "views-user-product";
    }

    @PostMapping("/product")
    public String saveProduct(@ModelAttribute ("product") Product product,
                              @RequestParam("image")MultipartFile image){
        productService.save(product, image);
        return "redirect:/product";
    }

//    @PostMapping("/product")
//    public String product(@ModelAttribute ("product") Product product){
//        productService.save(product);
//        return "redirect:/product";
//    }

    @GetMapping("/deleteProduct/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/product";
    }


    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@ModelAttribute Product product,
                             @RequestAttribute("image") MultipartFile image,
                             @PathVariable int id, Model model) {
        product.setId(id);

        if (image.isEmpty()) {
            productService.update(product);
        } else {
            productService.save(product, image);
            model.addAttribute("product", productService.findOne(id));
        }
        return "redirect:/product";
    }

}
