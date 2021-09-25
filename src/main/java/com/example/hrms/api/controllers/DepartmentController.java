package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.DepartmentService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getDepartments")
    public DataResult<List<Department>> getDepartments(){
        return this.departmentService.getAllDepartment();
    }

    @PostMapping("/addDepartment")
    public Result addDepartment(@RequestBody Department department){
        return this.departmentService.addDepartment(department);
    }
}
