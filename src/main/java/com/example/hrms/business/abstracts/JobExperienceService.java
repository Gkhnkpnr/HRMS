package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.dtos.addDtos.JobExperienceAddDto;

import java.util.List;

public interface JobExperienceService {
    Result addJobExperience(JobExperienceAddDto jobExperience);
    DataResult<List<JobExperience>> getJobExperienceByResumeId(int id);
    Result deleteJobExperienceById(int id);
}
