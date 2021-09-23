package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getJobSeekers();
    Result addJobSeeker(JobSeeker jobSeeker);
    Result deleteJobSeekerById(int id);
    DataResult<JobSeeker> getJobSeekerById(int jobSeekerId);
}
