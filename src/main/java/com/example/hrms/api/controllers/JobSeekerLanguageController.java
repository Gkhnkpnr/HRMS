package com.example.hrms.api.controllers;


import com.example.hrms.business.abstracts.JobSeekerLanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeekerLanguage;
import com.example.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekerLanguages")
@CrossOrigin
public class JobSeekerLanguageController {

    private final JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguageController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @GetMapping("/getJobSeekerLanguagesByResumeId")
    public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguagesByResumeId(@RequestParam int resumeId){
        return this.jobSeekerLanguageService.getJobSeekerLanguageByResumeId(resumeId);
    }

    @PostMapping("/addJobSeekerLanguage")
    public Result addJobSeekerLanguage(@RequestBody JobSeekerLanguageAddDto jobSeekerLanguage){
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
    }

    @DeleteMapping("/deleteJobSeekerLanguageById")
    public Result deleteJobSeekerLanguageById(@RequestParam int id){
        return this.jobSeekerLanguageService.deleteJobSeekerLanguageById(id);
    }
}
