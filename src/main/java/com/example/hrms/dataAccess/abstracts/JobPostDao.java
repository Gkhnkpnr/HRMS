package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost, Integer> {
    List<JobPost> findAllByIsActiveTrue();
    List<JobPost> getJobPostByIsActiveTrueAndEmployer_CompanyName(String companyName);
    List<JobPost> findAllByIsActiveTrue(Sort sort);
    List<JobPost> getJobPostByIsActiveTrueAndIsConfirmedTrue(Pageable pageable);
    List<JobPost> getJobPostIsActiveTrueAndIsConfirmedTrue();
    List<JobPost> getJobPostByEmployer_CompanyName(String companyName, Sort sort);
    List<JobPost> getJobPostByEmployerId(int id, Sort sort);

    @Query("Update JobPost set isActive =:active where id=:jobPostId")
    void changeIsActive(boolean active, int jobPostId);

    @Query("Update JobPost set isConfirmed =:confirm where id=:jobPostId")
    void changeIsConfirmed(boolean confirmed, int jopPostId);

    JobPost getJobPostById(int id);

    void deleteByJobPostById(int id);
}
