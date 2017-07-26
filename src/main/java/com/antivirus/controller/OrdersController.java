package com.antivirus.controller;

import com.antivirus.Editor.ProductEditor;
import com.antivirus.entity.DeliveryType;
import com.antivirus.entity.Orders;
import com.antivirus.entity.Product;
import com.antivirus.entity.User;
import com.antivirus.service.DeliveryTypeService;
import com.antivirus.service.OrdersService;
import com.antivirus.service.ProductService;
import com.antivirus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by User on 5/31/2017.
 */
@Controller
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;
    @Autowired
    private DeliveryTypeService deliveryTypeService;
    @Autowired
    private UserService userService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(Product.class, new ProductEditor());
    }

    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("orderss", ordersService.ordersWithProducts());
        model.addAttribute("orders", new Orders());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("deliveryTypes", deliveryTypeService.findAll());
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

    @GetMapping("/basket")
    public String basket(Principal principal, Model model){
        model.addAttribute("userBasket", userService.findUserWithProducts(Integer.parseInt(principal.getName())));
        model.addAttribute("deliveryTypes", deliveryTypeService.findAll());
        return "views-user-basket";
    }

    @GetMapping("/addToBasket/{id}")
    public String addToCart(Principal principal, @PathVariable int id) {
        ordersService.addToBasket(principal, id);
        return "redirect:/";
    }

    @GetMapping("/deleteFromBasket/{userId}/{productId}")
    public String deleteFromCart(@PathVariable int userId, @PathVariable int productId) {
        ordersService.deleteFromBasket(userId, productId);
        return "redirect:/basket";
    }

    @PostMapping("/buy")
    public String buy(Principal principal, @ModelAttribute("quantityPC") Integer productQuantity)
    {
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        for (Product product: user.getProducts())
        {
            product.setQuantityPC(productQuantity);
            productService.update(product);
        }
        ordersService.buy(Integer.parseInt(principal.getName()));
        return "redirect:/profile";
    }


}
