package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.dtos.addDtos.EducationAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getEducations")
    public DataResult<List<Education>> getEducations(){
        return this.educationService.getAllEducation();
    }

    @GetMapping("/getEducationByResumeId")
    public DataResult<List<Education>> getEducationByResumeId(@RequestParam int resumeId){
        return this.educationService.getEducationByResumeId(resumeId);
    }

    @PostMapping("/addEducation")
    public Result addEducation(@RequestBody EducationAddDto education){
        return this.educationService.addEducation(education);
    }

    public Result deleteEducationById(@RequestParam int id){
        return this.educationService.deleteEducationById(id);
    }
}
