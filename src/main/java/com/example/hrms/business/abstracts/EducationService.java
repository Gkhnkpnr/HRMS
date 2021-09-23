package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.dtos.addDtos.EducationAddDto;

import java.util.List;

public interface EducationService {
    Result addEducation(EducationAddDto education);
    DataResult<List<Education>> getAllEducation();
    DataResult<List<Education>> getEducationByResumeId(int id);
    Result deleteEducationById(int id);
}
