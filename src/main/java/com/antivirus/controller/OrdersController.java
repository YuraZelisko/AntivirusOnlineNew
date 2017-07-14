package com.antivirus.controller;

import com.antivirus.Editor.ProductEditor;
import com.antivirus.entity.Orders;
import com.antivirus.entity.Product;
import com.antivirus.service.OrdersService;
import com.antivirus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 5/31/2017.
 */
@Controller
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(Product.class, new ProductEditor());
    }

    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("orders", ordersService.findAll());
        model.addAttribute("ord", new Orders());
        model.addAttribute("products", productService.findAll());

        return "views-user-orders";
    }

    @PostMapping ("/orders")
    public String orders(@ModelAttribute Orders ord){
        ordersService.save(ord);
        return "redirect:/orders";
    }
    @GetMapping("/deleteOrder/{id}")
    public String delete (@PathVariable int id){
        ordersService.delete(id);
        return "redirect:/orders";
    }


}
