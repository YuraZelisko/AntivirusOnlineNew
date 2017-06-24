package com.antivirus.controller;

import com.antivirus.entity.City;
import com.antivirus.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 6/19/2017.
 */

//@Controller
//public class CityController{
//
//    @Autowired
//    private CityService cityService;
//
//    @GetMapping("/city")
//    private String saveCity(City city){
//        cityService.findAll();
//        return "views-admin-city";
//    }


@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public List<City> loadCities(){
        return cityService.findAll();
    }

    @PostMapping("/city")
    public List<City> saveCity(@RequestBody City city) {
        cityService.save(city);
        return cityService.findAll();
    }

    @DeleteMapping("/city")
    public List<City> deleteCity(@RequestBody String idCity){

        cityService.delete(Integer.valueOf(idCity));

        return cityService.findAll();
    }


    @PutMapping("/city")
    public List<City> updateCity(@RequestBody String info){

        cityService.update(info);

        return cityService.findAll();
    }

}