package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobExperience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> getJobExperienceEndDateByResumeId(int id, Sort sort);

    void deleteJobExperienceById(int id);
}
