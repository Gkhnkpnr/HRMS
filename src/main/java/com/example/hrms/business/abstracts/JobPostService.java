package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPost;
import com.example.hrms.entities.dtos.addDtos.JobPostAddDto;
import org.springframework.data.domain.Sort;

import javax.xml.crypto.Data;
import java.util.List;

public interface JobPostService {
    DataResult<List<JobPost>> getAllJobPosts();
    DataResult<List<JobPost>> getSortedJobPosts();
    DataResult<List<JobPost>> getActiveJobPosts();
    DataResult<List<JobPost>> getJobPostByCompanyName(String companyName);
    DataResult<List<JobPost>> findAllByIsActiveTrue(boolean isDesc);
    DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo, int pageSize);
    DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize);
    DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrue();
    DataResult<JobPost> getJobPostById(int jobPostId);
    DataResult<List<JobPost>> getJobPostByEmployerId(int employerId);
    Result changeIsActive(boolean active, int jobPostId);
    Result changeIsConfirmed(boolean confirmed, int jobPostId);
    Result addJobPost(JobPostAddDto jobPost);
    Result deleteJobPostById(int jobPostId);
}
