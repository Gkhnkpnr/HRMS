package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result addSchool(School school);
    DataResult<List<School>> getSchools();
}
