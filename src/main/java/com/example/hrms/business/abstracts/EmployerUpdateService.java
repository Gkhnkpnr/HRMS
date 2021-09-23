package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
    DataResult<EmployerUpdate> getEmployerUpdateById(int employerId);

    Result deleteEmployerUpdateById(int employerId);

    Result addEmployerUpdate(EmployerUpdate employerUpdate);
}
