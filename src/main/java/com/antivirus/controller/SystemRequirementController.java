package com.antivirus.controller;

import com.antivirus.entity.ModulesIncluded;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.SystemRequirementService;
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
 * Created by User on 5/31/2017.
 */
@Controller
public class SystemRequirementController {

    @Autowired
    private SystemRequirementService systemRequirementService;

    @GetMapping("/systemRequirement")
    public String modules(Model model){
        model.addAttribute("systemRequirements", systemRequirementService.findAll());
        model.addAttribute("systemRequirement", new SystemRequirements());
        return "views-admin-systemRequirement";
    }

    @PostMapping("/systemRequirement")
    public String modules(@ModelAttribute("systemRequirement") SystemRequirements systemRequirement){
        systemRequirementService.save(systemRequirement);
        return "redirect:/systemRequirement";
    }
//    @GetMapping("/deleteSystemRequirement/{id}")
//    public String delete (@PathVariable int id){
//        systemRequirementService.delete(id);
//        return "redirect:/systemRequirement";
//    }

}
