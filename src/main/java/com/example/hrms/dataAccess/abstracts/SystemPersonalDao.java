package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.SystemPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonalDao extends JpaRepository<SystemPersonal, Integer> {
    SystemPersonal getSystemPersonalById(int id);

    void deleteSystemPersonalById(int id);

}
