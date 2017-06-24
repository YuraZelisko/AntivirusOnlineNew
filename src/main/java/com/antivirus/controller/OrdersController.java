package com.antivirus.controller;

import com.antivirus.entity.Orders;
import com.antivirus.service.OrdersService;
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
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("orderss", ordersService.findAll());
        model.addAttribute("ord", new Orders());

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
