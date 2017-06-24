package com.antivirus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 5/28/2017.
 */
@Controller
public class DeliveryController {

    @GetMapping("/delivery")
    public String delivery(){
        return "views-user-delivery";
    }
}
