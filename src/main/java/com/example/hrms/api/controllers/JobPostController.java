package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPost;
import com.example.hrms.entities.dtos.addDtos.JobPostAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobposts")
@CrossOrigin
public class JobPostController {

    private final JobPostService jobPostService;

    @Autowired
    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/getJobPosts")
    public DataResult<List<JobPost>> getJobPosts(){
        return this.jobPostService.getAllJobPosts();
    }

    @GetMapping("/getSortedJobPosts")
    public DataResult<List<JobPost>> getSortedJobPosts(){
        return this.jobPostService.getSortedJobPosts();
    }

    @GetMapping("/getActiveJobPosts")
    public DataResult<List<JobPost>> getActiveJobPosts(){
        return this.jobPostService.getActiveJobPosts();
    }

    @GetMapping("/getJobPostsByCompanyName")
    public DataResult<List<JobPost>> getJobPostsByCompanyName(String companyName){
        return this.jobPostService.getJobPostByCompanyName(companyName);
    }

    @GetMapping("/getJobPostByEmployerId")
    public DataResult<List<JobPost>> getJobPostByEmployerId(int employerId){
        return this.jobPostService.getJobPostByEmployerId(employerId);
    }

    @GetMapping("/getActiveJobPostsSorted")
    public DataResult<List<JobPost>> findAllByIsActiveTrueSorted(@RequestParam boolean isDesc){
        return this.jobPostService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getJobPostsByIsActiveTrueAndIsConfirmedTrue")
    public DataResult<List<JobPost>> getJobPostsByIsActiveTrueAndIsConfirmedTrue(){
        return this.jobPostService.getJobPostByIsActiveTrueAndIsConfirmedTrue();
    }

    @GetMapping("/getActiveAndConfirmedJobPostCount")
    public int getActiveAndConfirmedJobPostCount(){
        if (Math.round((double) this.jobPostService.getJobPostByIsActiveTrueAndIsConfirmedTrue().getData().size()/5) <1){
            return 1;
        }else{
            return (int) Math.ceil((double) this.jobPostService.getJobPostByIsActiveTrueAndIsConfirmedTrue().getData().size()/(double) 5);
        }
    }

    @GetMapping("/getJobPostByIsActiveTrueAndIsConfirmedTrueByPageDesc")
    public DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrueByPageDesc(@RequestParam int pageNo, int pageSize){
        return this.jobPostService.getJobPostByIsActiveTrueAndIsConfirmedTrueByPageDesc(pageNo - 1, pageSize);
    }

    @GetMapping("/getJobPostByIsActiveTrueAndIsConfirmedTrueByPageAsc")
    public DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrueByPageAsc(@RequestParam int pageNo, int pageSize){
        return this.jobPostService.getJobPostByIsActiveTrueAndIsConfirmedTrueByPageAsc(pageNo - 1, pageSize);
    }

    @GetMapping("/getJobPostById")
    public DataResult<JobPost> getJobPostById(int jobPostId){
        return this.jobPostService.getJobPostById(jobPostId);
    }

    @DeleteMapping("/deleteJobPostById")
    public Result deleteJobPostById(@RequestParam int jobPostId){
        return this.jobPostService.deleteJobPostById(jobPostId);
    }

    @PostMapping("/addJobPost")
    public Result addJobPost(@RequestBody JobPostAddDto jobPost){
        return this.jobPostService.addJobPost(jobPost);
    }
}
