package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {
    EmployerUpdate getEmployerUpdateById(int id);

    @Transactional
    void  deleteEmployerUpdateById(int id);
}
