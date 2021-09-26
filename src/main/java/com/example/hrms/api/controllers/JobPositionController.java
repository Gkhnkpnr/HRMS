package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getPositions")
    public DataResult<List<JobPosition>> getPositions(){
        return this.jobPositionService.getJobPositions();
    }

    @PostMapping("/addposition")
    public Result addJobPosition(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.addJobPosition(jobPosition);
    }
}
