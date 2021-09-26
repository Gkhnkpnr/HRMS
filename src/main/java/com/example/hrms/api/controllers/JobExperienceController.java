package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.dtos.addDtos.JobExperienceAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperienceController {

    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getJobExperienceByResumeId")
    public DataResult<List<JobExperience>> getJobExperienceByResumeId(@RequestParam int resumeId){
        return this.jobExperienceService.getJobExperienceByResumeId(resumeId);
    }

    @PostMapping("/addJobExperience")
    public Result addJobExperience(@RequestBody JobExperienceAddDto jobExperience){
        return this.jobExperienceService.addJobExperience(jobExperience);
    }

    @DeleteMapping("/deleteJobExperienceById")
    public Result deleteJobExperienceById(@RequestParam int id){
        return this.jobExperienceService.deleteJobExperienceById(id);
    }
}
