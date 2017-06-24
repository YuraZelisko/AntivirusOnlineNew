package com.antivirus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public  String index(){

        return "views-base-index";
    }
    @PostMapping("/")
    public  String indexAfetrLogin(){

        return "views-base-index";
    }

    @GetMapping("/opencity")
    public String city(){
        return "views-admin-city";
    }

}
