package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {

    private final EmployerService employerService;
    private final JobPostService jobPostService;

    @Autowired
    public EmployerController(EmployerService employerService, JobPostService jobPostService) {
        this.employerService = employerService;
        this.jobPostService = jobPostService;
    }

    @GetMapping("/getEmployers")
    public DataResult<List<Employer>> getEmployers(){
        return this.employerService.getAllEmployers();
    }

    @GetMapping("/getEmployerById")
    public DataResult<Employer> getEmployerById(int employerId){
        return this.employerService.getEmployerById(employerId);
    }

    @DeleteMapping("/deleteEmployerById")
    public Result deleteEmployerById(@RequestParam int employerId){
        return this.employerService.deleteEmployerById(employerId);
    }

    @PostMapping("/addEmployer")
    public Result addEmployer(@RequestBody Employer employer){
        return this.employerService.addEmployer(employer);
    }

    @PutMapping("/updateEmployer")
    public Result updateEmployer(@RequestBody Employer employer){
        return this.employerService.updateEmployer(employer);
    }

    @PostMapping("/changeIsActive")
    public Result changeIsActive(@RequestParam boolean active, int jobPostId){
        return this.jobPostService.changeIsActive(active, jobPostId);
    }

    @PostMapping("/changeIsUpdated")
    public Result changeIsUpdated(@RequestParam boolean updated, int jobPostId){
        return this.employerService.changeIsUpdated(updated, jobPostId);
    }

    public Result addPicture(int employerId, MultipartFile file) throws IOException{
        return this.employerService.uploadPicture(employerId, file);
    }
}
