package com.antivirus.controller;

import com.antivirus.entity.DeliveryType;
import com.antivirus.entity.Region;
import com.antivirus.service.DeliveryTypeService;
import com.antivirus.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by User on 5/28/2017.
 */
@Controller
public class DeliveryController {

    @Autowired
    private DeliveryTypeService deliveryTypeService;
    @Autowired
    private RegionService regionService;


    @GetMapping("/delivery")
    public String delivery(Model model){

        model.addAttribute("deliveries", deliveryTypeService.findAll());
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("delivery", new DeliveryType());
        return "views-admin-delivery";
    }

    @PostMapping("/delivery")
    public String region(@ModelAttribute("delivery") DeliveryType deliveryType){
        deliveryTypeService.save(deliveryType);
        return "redirect:/delivery";
    }

    @GetMapping("/deleteDelivery/{id}")
    public String delete (@PathVariable int id){
        deliveryTypeService.delete(id);
        return "redirect:/delivery";
    }

    @GetMapping("/updateDelivery/{id}")
    public String getAuthor(@PathVariable int id, Model model) {
        model.addAttribute("delivery", deliveryTypeService.findOne(id));
        return "views-admin-updateDelivery";
    }

    @PostMapping("/updateDelivery/{id}")
    public String updateAuthor(@ModelAttribute("delivery")
                               DeliveryType deliveryType,
                               @PathVariable int id, Model model) {
        deliveryType.setId(id);
        deliveryTypeService.update(deliveryType);
        model.addAttribute("delivery", deliveryTypeService.findAll());
        return "redirect:/delivery";
    }
}
