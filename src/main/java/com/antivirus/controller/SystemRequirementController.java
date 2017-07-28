package com.antivirus.controller;

import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.SystemRequirementService;
import com.antivirus.validator.SystemReqirementsValidator.SystemRequirementsValidationMessages;
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
    public String modules(@ModelAttribute("systemRequirement") SystemRequirements systemRequirement, Model model)  {
        try {
            systemRequirementService.save(systemRequirement);
        }
        catch (Exception e) {
            System.out.println("ываываавыпавпвапвапвапвапЭ");
           if (e.getMessage().equals(SystemRequirementsValidationMessages.EMPTY_OSNAME_FIELD) ||
                   e.getMessage().equals(SystemRequirementsValidationMessages.OSNAME_ALREADY_EXIST)){
               model.addAttribute("SRNameException", e.getMessage());
           }
           else if (e.getMessage().equals(SystemRequirementsValidationMessages.CHOOSE_BIT_DEPTH)){
               model.addAttribute("SRBitException", e.getMessage());
           }
           else if (e.getMessage().equals(SystemRequirementsValidationMessages.INCORRECT_AMOUNT_FIELD)){
               model.addAttribute("SRAmountException", e.getMessage());

           }else if (e.getMessage().equals(SystemRequirementsValidationMessages.INCORRECT_RAM_FIELD)){
               model.addAttribute("SRRAMException",e.getMessage());
           }
           else if (e.getMessage().equals(SystemRequirementsValidationMessages.EMPTY_OSLANGUAGE_FIELD)){
               model.addAttribute("SRLangException", e.getMessage());
           }
            model.addAttribute("systemRequirements", systemRequirementService.findAll());
            return "views-admin-systemRequirement";
        }
        return "redirect:/systemRequirement";
    }
    @GetMapping("/deleteSystemRequirement/{id}")
    public String delete (@PathVariable int id){
        systemRequirementService.delete(id);
        return "redirect:/systemRequirement";
    }

    @GetMapping("/updateSystemRequirement/{id}")
    public String getSystem(@PathVariable int id, Model model) {
        model.addAttribute("systemRequirement", systemRequirementService.findOne(id));
        return "views-admin-updateSystemRequirement";
    }

    @PostMapping("/updateSystemRequirement/{id}")
    public String updateSystem(@ModelAttribute("systemRequirement") SystemRequirements systemRequirements, @PathVariable int id, Model model) {
        systemRequirements.setId(id);
        systemRequirementService.update(systemRequirements);
        model.addAttribute("systemRequirement", systemRequirementService.findAll());
        return "redirect:/systemRequirement";
    }

}
