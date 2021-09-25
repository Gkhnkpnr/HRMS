package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerUpdateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employersUpdate")
@CrossOrigin
public class EmployerUpdateController {

    private final EmployerUpdateService employerUpdateService;

    @Autowired
    public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("/getEmployerUpdateById")
    public DataResult<EmployerUpdate> getEmployerById(int employerId){
        return this.employerUpdateService.getEmployerUpdateById(employerId);
    }

    @DeleteMapping("/deleteEmployerUpdateById")
    public Result deleteEmployerById(@RequestParam int employerId){
        return this.employerUpdateService.deleteEmployerUpdateById(employerId);
    }

    @PostMapping("/addEmployerUpdate")
    public Result addEmployerUpdate(@RequestBody EmployerUpdate employerUpdate){
        return this.employerUpdateService.addEmployerUpdate(employerUpdate);
    }
}
