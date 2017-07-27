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
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by User on 5/31/2017.
 */
@Controller
@Transactional
public class OrdersController {


    private final OrdersService ordersService;

    private final ProductService productService;
    private final DeliveryTypeService deliveryTypeService;
    private final UserService userService;

    @Autowired
    public OrdersController(OrdersService ordersService, ProductService productService, DeliveryTypeService deliveryTypeService, UserService userService) {
        this.ordersService = ordersService;
        this.productService = productService;
        this.deliveryTypeService = deliveryTypeService;
        this.userService = userService;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(Product.class, new ProductEditor());
    }

    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("ordersAll", ordersService.ordersWithProducts());
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
    public String deleteFromBasket(@PathVariable int userId, @PathVariable int productId) {
        ordersService.deleteFromBasket(userId, productId);
        return "redirect:/basket";
    }

    @PostMapping("/buy")
    public String buy(Principal principal, @ModelAttribute("productQuantity") Integer productQuantity)
    {
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        Hibernate.initialize(user.getProducts());
        for (Product product: user.getProducts())
        {
            product.setProductQuantity(productQuantity);
            productService.update(product);
        }
        ordersService.buy(Integer.parseInt(principal.getName()));
        return "redirect:/profile";
    }

    @GetMapping("/orderDetails/{id}")
    public String billableDetails(@PathVariable int id, Model model) {
        Orders orders = ordersService.findOne(id);
        ordersService.getTotalPrice(id);
        model.addAttribute("orders", orders);
        Hibernate.initialize(orders.getProducts());
        return "views-user-orderDetails";
    }

}
