package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.business.abstracts.SystemPersonalService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.SystemPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemPersonals")
@CrossOrigin
public class SystemPersonalController {

    private final SystemPersonalService systemPersonalService;
    private final JobPostService jobPostService;
    private final EmployerService employerService;

    @Autowired
    public SystemPersonalController(SystemPersonalService systemPersonalService, JobPostService jobPostService, EmployerService employerService) {
        this.systemPersonalService = systemPersonalService;
        this.jobPostService = jobPostService;
        this.employerService = employerService;
    }

    @GetMapping("/getSystemPersonals")
    public DataResult<List<SystemPersonal>> getSystemPersonals(){
        return this.systemPersonalService.getSystemPersonals();
    }

    @GetMapping("/getSystemPersonalById")
    public DataResult<SystemPersonal> getSystemPersonalById(int systemPersonalId){
        return this.systemPersonalService.getSystemPersonalById(systemPersonalId);
    }

    @GetMapping("/getEmployerByUpdatedTrue")
    public DataResult<List<Employer>> getEmployerByUpdatedTrue(){
        return this.employerService.getEmployerByIsUpdatedTrue();
    }

    @DeleteMapping("/deleteSystemPersonalById")
    public Result deleteSystemPersonalById(@RequestParam int systemPersonalId){
        return this.systemPersonalService.deleteSystemPersonalById(systemPersonalId);
    }

    @PostMapping("/addSystemPersonal")
    public Result addSystemPersonal(@RequestBody SystemPersonal systemPersonal){
        return this.systemPersonalService.addSystemPersonal(systemPersonal);
    }

    @PutMapping("/updateSystemPersonal")
    public Result updateSystemPersonal(@RequestBody SystemPersonal systemPersonal){
        return this.systemPersonalService.updateSystemPersonal(systemPersonal);
    }

    @PostMapping("/changeIsConfirmed")
    public Result changeIsConfirmed(@RequestParam boolean confirm, int jobPostId){
        return this.jobPostService.changeIsConfirmed(confirm, jobPostId);
    }
}
