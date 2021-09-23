package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {
    Result addDepartment(Department department);
    DataResult<List<Department>> getAllDepartment();
}
