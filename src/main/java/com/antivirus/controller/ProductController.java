package com.antivirus.controller;

import com.antivirus.Editor.ModulesEditor;
import com.antivirus.Editor.SystemRequirementsEditor;
import com.antivirus.entity.ModulesIncluded;
import com.antivirus.entity.Product;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.ModulesIncludedService;
import com.antivirus.service.ProductService;
import com.antivirus.service.SystemRequirementService;
//import jdk.internal.cmm.SystemResourcePressureImpl;
import com.antivirus.validator.ProductValidator.ProductValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

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
    private SystemRequirementService systemRequirementService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(ModulesIncluded.class, new ModulesEditor());
    }
    @InitBinder
    public void init2(WebDataBinder binder){
        binder.registerCustomEditor(SystemRequirements.class, new SystemRequirementsEditor());
    }



    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("products", productService.productIncludedWithModules());
        model.addAttribute("product", new Product());
        model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
        model.addAttribute("systemRequirements", systemRequirementService.findAll());
        return "views-admin-product";
    }

    @PostMapping("/product")
    public String saveProduct(@ModelAttribute ("product") Product product,
                              @RequestParam ArrayList<Integer> modulesIncludeds,
                              @RequestParam("image")MultipartFile image, Model model) {
        try {
            productService.save(product, modulesIncludeds, image);
        } catch (Exception e) {
            if (e.getMessage().equals(ProductValidationMessages.NAME_IS_EMPTY) ||
                    e.getMessage().equals(ProductValidationMessages.NAME_ALREADY_EXIST)) {
                model.addAttribute("productNameException", e.getMessage());
            } else if (e.getMessage().equals(ProductValidationMessages.DESCRIPTION_IS_EMPTY)) {
                model.addAttribute("productDescriptionException", e.getMessage());
            } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_PRICE)) {
                model.addAttribute("productPriceException", e.getMessage());
            } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_QUANTITY)) {
                model.addAttribute("productQuantityException", e.getMessage());
            } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_LICENCE)) {
                model.addAttribute("productLicenceException", e.getMessage());
            }
                model.addAttribute("products", productService.productIncludedWithModules());
                model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
                model.addAttribute("systemRequirements", systemRequirementService.findAll());
                return "views-admin-product";
        }
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable int id, Model model){
        model.addAttribute("products", productService.productIncludedWithModules());
        model.addAttribute("product", productService.findOne(id));
        model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
        model.addAttribute("systemRequirements", systemRequirementService.findAll());

        return "views-admin-updateProduct";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@ModelAttribute ("product") Product product,
                                @RequestAttribute("image") MultipartFile image,
                                @PathVariable int id,
//                             @RequestParam ArrayList<Integer> modulesIncludeds,
                                Model model) {


        product.setId(id);

        if (image==null) {
            try {
                productService.update(product);
            } catch (Exception e) {
                if (e.getMessage().equals(ProductValidationMessages.NAME_IS_EMPTY)) {
                    model.addAttribute("productNameException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.DESCRIPTION_IS_EMPTY)) {
                    model.addAttribute("productDescriptionException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_PRICE)) {
                    model.addAttribute("productPriceException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_QUANTITY)) {
                    model.addAttribute("productQuantityException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_LICENCE)) {
                    model.addAttribute("productLicenceException", e.getMessage());
                }
                model.addAttribute("products", productService.productIncludedWithModules());
                model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
                model.addAttribute("systemRequirements", systemRequirementService.findAll());
                return "views-admin-product";
            }
        } else {
            try {
                productService.update(product,
    //                    modulesIncludeds,
                        image);
            } catch (Exception e) {
                if (e.getMessage().equals(ProductValidationMessages.NAME_IS_EMPTY)) {
                    model.addAttribute("productNameException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.DESCRIPTION_IS_EMPTY)) {
                    model.addAttribute("productDescriptionException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_PRICE)) {
                    model.addAttribute("productPriceException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_QUANTITY)) {
                    model.addAttribute("productQuantityException", e.getMessage());
                } else if (e.getMessage().equals(ProductValidationMessages.INCORRECT_LICENCE)) {
                    model.addAttribute("productLicenceException", e.getMessage());
                }
                model.addAttribute("products", productService.productIncludedWithModules());
                model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
                model.addAttribute("systemRequirements", systemRequirementService.findAll());
                return "views-admin-product";
            }
            model.addAttribute("product", productService.findOne(id));
        }
        return "redirect:/product";
    }

}