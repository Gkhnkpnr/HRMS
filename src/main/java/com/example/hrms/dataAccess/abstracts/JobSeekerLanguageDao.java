package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
    List<JobSeekerLanguage> getJobSeekerLanguageByResumeId(int id);
    void deleteJobSeekerLanguageById(int id);
}
