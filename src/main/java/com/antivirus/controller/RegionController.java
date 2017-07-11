package com.antivirus.controller;

import com.antivirus.entity.Region;
import com.antivirus.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by User on 5/28/2017.
 */
@Controller
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/region")
    public String region(Model model) {
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("region", new Region());
        return "views-admin-region";
    }

    @PostMapping("/region")
    public String region(@ModelAttribute("region") Region region,
                         @RequestParam("image") MultipartFile image) {
        regionService.save(region, image);
        return "redirect:/region";
    }

    @GetMapping("/deleteRegion/{id}")
    public String delete(@PathVariable int id) {
        regionService.delete(id);
        return "redirect:/region";
    }

    @GetMapping("/updateRegion/{id}")
    public String getAuthor(@PathVariable int id, Model model) {
        model.addAttribute("region", regionService.findOne(id));
        return "views-admin-updateRegion";
    }

    @PostMapping("/updateRegion/{id}")
    public String updateProduct(@ModelAttribute ("region") Region region,
                                @RequestAttribute("image") MultipartFile image,
                                @PathVariable int id,
                                Model model) {
        region.setId(id);

        if (image.isEmpty()) {
            regionService.update(region);
        } else {
            regionService.save(region, image);
            model.addAttribute("region", regionService.findOne(id));
        }
        return "redirect:/region";
    }
}

