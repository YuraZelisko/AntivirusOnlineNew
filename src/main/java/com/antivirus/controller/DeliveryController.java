package com.antivirus.controller;

import com.antivirus.Editor.RegionEditor;
import com.antivirus.dto.DtoUtilMapper;
import com.antivirus.entity.DeliveryType;
import com.antivirus.entity.Region;
import com.antivirus.service.DeliveryTypeService;
import com.antivirus.service.RegionService;
import com.antivirus.validator.DeliveryValidator.DeliveryValidationMessages;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DeliveryController {

    @Autowired
    private DeliveryTypeService deliveryTypeService;
    @Autowired
    private RegionService regionService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(Region.class, new RegionEditor());
    }


    @GetMapping("/delivery")
    public String delivery(Model model){

        model.addAttribute("deliveries", deliveryTypeService.findAll());
        model.addAttribute("regions", DtoUtilMapper.regionsToRegionsDTO(regionService.findAll()));
        model.addAttribute("delivery", new DeliveryType());
        return "views-admin-delivery";
    }

    @PostMapping("/delivery")
    public String region(@ModelAttribute("delivery") DeliveryType deliveryType, Model model){
        try {
            deliveryTypeService.save(deliveryType);
        } catch (Exception e) {
            if (e.getMessage().equals(DeliveryValidationMessages.DELIVERY_NAME_EMPTY)||
                    e.getMessage().equals(DeliveryValidationMessages.DELIVERY_NAME_EXIST)){
                model.addAttribute("deliveryNameException", e.getMessage());
            } else if (e.getMessage().equals(DeliveryValidationMessages.DELIVERY_COST_EMPTY)||
                    e.getMessage().equals(DeliveryValidationMessages.DELIVERY_COST_EXCEPTION)){
                model.addAttribute("deliveryCostException", e.getMessage());
            } else if (e.getMessage().equals(DeliveryValidationMessages.DELIVERY_DAYS_EMPTY)||
                    e.getMessage().equals(DeliveryValidationMessages.DELIVERY_DAYS_EXCEPTION)) {
                model.addAttribute("deliveryDaysException", e.getMessage());
            }
            model.addAttribute("deliveries", deliveryTypeService.findAll());
            model.addAttribute("regions", DtoUtilMapper.regionsToRegionsDTO(regionService.findAll()));
            return "views-admin-delivery";
        }
        return "redirect:/delivery";
    }

    @GetMapping("/deleteDelivery/{id}")
    public String delete (@PathVariable int id){
        deliveryTypeService.delete(id);
        return "redirect:/delivery";
    }

    @GetMapping("/updateDelivery/{id}")
    public String getDelivery(@PathVariable int id, Model model) {
        model.addAttribute("delivery", deliveryTypeService.findOne(id));
        model.addAttribute("regions", regionService.findAll());
        return "views-admin-updateDelivery";
    }

    @PostMapping("/updateDelivery/{id}")
    public String updateDelivery(@ModelAttribute("delivery")
                               DeliveryType deliveryType,@RequestParam int regionId,
                               @PathVariable int id, Model model) {
        deliveryType.setId(id);
        deliveryType.setRegion(regionService.findOne(regionId));
        try {
            deliveryTypeService.update(deliveryType);
        } catch (Exception e) {
            if (e.getMessage().equals(DeliveryValidationMessages.DELIVERY_NAME_EMPTY)||
                    e.getMessage().equals(DeliveryValidationMessages.DELIVERY_NAME_EXIST)){
                model.addAttribute("deliveryNameException", e.getMessage());
            } else if (e.getMessage().equals(DeliveryValidationMessages.DELIVERY_COST_EXCEPTION)){
                model.addAttribute("deliveryCostException", e.getMessage());
            } else if (e.getMessage().equals(DeliveryValidationMessages.DELIVERY_DAYS_EXCEPTION)) {
                model.addAttribute("deliveryDaysException", e.getMessage());
            }
            model.addAttribute("regions", DtoUtilMapper.regionsToRegionsDTO(regionService.findAll()));
            return "views-admin-updateDelivery";
        }
        model.addAttribute("delivery", deliveryTypeService.findAll());
        return "redirect:/delivery";
    }
}
