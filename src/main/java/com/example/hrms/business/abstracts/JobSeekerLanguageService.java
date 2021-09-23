package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeekerLanguage;
import com.example.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

import java.util.List;

public interface JobSeekerLanguageService {
    Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage);
    DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByResumeId(int id);
    Result deleteJobSeekerLanguageById(int id);
}
