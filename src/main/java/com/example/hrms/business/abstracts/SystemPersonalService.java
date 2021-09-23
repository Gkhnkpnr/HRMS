package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.SystemPersonal;

import java.util.List;

public interface SystemPersonalService {
    DataResult<List<SystemPersonal>> getSystemPersonals();
    Result addSystemPersonal(SystemPersonal systemPersonal);
    Result updateSystemPersonal(SystemPersonal systemPersonal);
    DataResult<SystemPersonal> getSystemPersonalById(int systemPersonalId);
    Result deleteSystemPersonalById(int systemPersonalId);
}
