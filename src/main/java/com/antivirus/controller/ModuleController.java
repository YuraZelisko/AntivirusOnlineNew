package com.antivirus.controller;

import com.antivirus.entity.ModulesIncluded;
import com.antivirus.service.ModulesIncludedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 * Created by User on 5/30/2017.
 */
@Controller
public class ModuleController {

    @Autowired
    private ModulesIncludedService modulesIncludedService;

    @GetMapping("/modules")
    public String modules(Model model, @PageableDefault Pageable pageble){
        model.addAttribute("modules", modulesIncludedService.findAllPages(pageble));
        model.addAttribute("module", new ModulesIncluded());
        return "views-admin-modules";
    }

    @PostMapping("/modules")
    public String modules(@ModelAttribute ("module") ModulesIncluded modulesIncluded){
        modulesIncludedService.save(modulesIncluded);
        return "redirect:/modules";
    }
    @GetMapping("/deleteModule/{id}")
    public String delete (@PathVariable int id){
       modulesIncludedService.delete(id);
        return "redirect:/modules";
    }
    @GetMapping("/updateIngredient/{id}")
    public String updateIngredient(@PathVariable int id, Model model){

        ModulesIncluded modulesIncluded =
                modulesIncludedService.findOne(id);

        model.addAttribute("ingredient", modulesIncluded);

        return "updateIngredient";

    }
}
