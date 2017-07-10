package com.antivirus.controller;

import com.antivirus.entity.DeliveryType;
import com.antivirus.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by User on 5/28/2017.
 */
@Controller
public class DeliveryController {

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @GetMapping("/delivery")
    public String delivery(Model model){

        model.addAttribute("deliveries", deliveryTypeService.findAll());
        model.addAttribute("delivery", new DeliveryType());
        return "views-user-delivery";
    }

    @PostMapping("/delivery")
    public String region(@ModelAttribute("delivery") DeliveryType deliveryType){
        deliveryTypeService.save(deliveryType);
        return "redirect:/delivery";
    }
}
