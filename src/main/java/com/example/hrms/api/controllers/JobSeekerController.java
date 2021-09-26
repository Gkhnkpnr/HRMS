package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
@CrossOrigin
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getJobSeekers")
    public DataResult<List<JobSeeker>> getJobSeekers(){
        return this.jobSeekerService.getJobSeekers();
    }

    @GetMapping("/getJobSeekerById")
    public DataResult<JobSeeker> getJobSeekerById(int jobSeekerId){
        return this.jobSeekerService.getJobSeekerById(jobSeekerId);
    }

    @DeleteMapping("/deleteJobSeekerById")
    public Result deleteJobSeekerById(@RequestParam int jobSeekerId){
        return this.jobSeekerService.deleteJobSeekerById(jobSeekerId);
    }

    @PostMapping("/addJobSeeker")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker){
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }
}
