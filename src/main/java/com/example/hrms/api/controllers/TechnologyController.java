package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Technology;
import com.example.hrms.entities.dtos.addDtos.TechnologyAddDto;
import com.example.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologyController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getTechnologies")
    public DataResult<List<Technology>> getTechnologies(){
        return this.technologyService.getTechnologies();
    }

    @GetMapping("/getTechnologiesByResumeId")
    public DataResult<List<Technology>> getTechnologiesByResumeId(@RequestParam int resumeId){
        return this.technologyService.getTechnologyByResumeId(resumeId);
    }

    @PostMapping("/addTechnology")
    public Result addTechnology(@RequestBody TechnologyAddDto technology){
        return this.technologyService.addTechnology(technology);
    }

    @PutMapping("/updateTechnology")
    public Result updateTechnology(@RequestBody TechnologyUpdateDto technology){
        return this.technologyService.updateTechnology(technology);
    }

    @DeleteMapping("/deleteTechnologyById")
    public Result deleteTechnologyById(@RequestParam int id){
        return this.technologyService.deleteTechnologyById(id);
    }
}
