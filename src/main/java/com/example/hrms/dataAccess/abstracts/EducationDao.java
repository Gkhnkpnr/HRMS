package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {
    List<Education> getEducationEndDateByResumeId(int id, Sort sort);

    void deleteEducationById(int id);
}
