package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
    List<Technology> getTechnologyByResumeId(int id);
    void deleteTechnologyById(int id);
}
