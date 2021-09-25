package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@CrossOrigin
public class CitiesController {

    private final CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getCities")
    public DataResult<List<City>> getCities(){
        return this.cityService.getCities();
    }

}
