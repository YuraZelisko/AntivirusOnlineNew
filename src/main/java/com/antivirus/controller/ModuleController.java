package com.antivirus.controller;

import com.antivirus.entity.ModulesIncluded;
import com.antivirus.service.ModulesIncludedService;
import com.antivirus.validator.ModulesValidator.ModuleValidationMessages;
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
//        model.addAttribute("modulesIncludeds", modulesIncludedService.findAll());
        model.addAttribute("module", new ModulesIncluded());
        return "views-admin-modules";
    }

    @PostMapping("/modules")
    public String saveModules(@ModelAttribute ("module") ModulesIncluded modulesIncluded, Model model,
                              @PageableDefault Pageable pageble){
        try {
            modulesIncludedService.save(modulesIncluded);
        } catch (Exception e) {
            if (e.getMessage().equals(ModuleValidationMessages.NAME_FIELD_IS_EMPTY)) {
                model.addAttribute("moduleNameException", e.getMessage());
            } else if (e.getMessage().equals(ModuleValidationMessages.NAME_ALREADY_EXIST)) {
                model.addAttribute("moduleNameException", e.getMessage());
            } else if (e.getMessage().equals(ModuleValidationMessages.DESCRIPTION_FIELD_IS_EMPTY)){
                model.addAttribute("moduleDescException", e.getMessage());
            } else if (e.getMessage().equals(ModuleValidationMessages.DESCRIPTION_ALREADY_EXIST))
                model.addAttribute("moduleDescException", e.getMessage());
             model.addAttribute("modules", modulesIncludedService.findAllPages(pageble));
            return "views-admin-modules";
        }
        return "redirect:/modules";
    }
    @GetMapping("/deleteModule/{id}")
    public String delete (@PathVariable int id){
       modulesIncludedService.delete(id);
        return "redirect:/modules";
    }

    @GetMapping("/updateModule/{id}")
    public String getAuthor(@PathVariable int id, Model model) {
        model.addAttribute("module", modulesIncludedService.findOne(id));
        return "views-admin-updateModule";
    }

    @PostMapping("/updateModule/{id}")
    public String updateAuthor(@ModelAttribute("module") ModulesIncluded modulesIncluded, @PathVariable int id, Model model) {
        modulesIncluded.setId(id);
        modulesIncludedService.update(modulesIncluded);
        model.addAttribute("module", modulesIncludedService.findAll());
        return "redirect:/modules";
    }
}
