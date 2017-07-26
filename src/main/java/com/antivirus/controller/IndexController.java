package com.antivirus.controller;

import com.antivirus.entity.Product;
import com.antivirus.service.ModulesIncludedService;
import com.antivirus.service.ProductService;
import com.antivirus.service.SystemRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ModulesIncludedService modulesIncludedService;

    @Autowired
    private SystemRequirementService systemRequirementService;
    @GetMapping("/")
    public  String index(Model model){

            model.addAttribute("products", productService.productIncludedWithModules());
            model.addAttribute("product", new Product());
            model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
            model.addAttribute("systemRequirements", systemRequirementService.findAll());

        return "views-base-index";
    }
    @PostMapping("/")
    public  String indexAfetrLogin(){

        return "views-base-index";
    }

    @GetMapping("/opencity")
    public String city(){
        return "views-admin-city";
    }

}
