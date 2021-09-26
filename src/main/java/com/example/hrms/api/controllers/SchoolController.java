package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getSchools")
    public DataResult<List<School>> getSchools(){
        return this.schoolService.getSchools();
    }

    @PostMapping("/addSchool")
    public Result addSchool(@RequestBody School school){
        return this.schoolService.addSchool(school);
    }
}
