package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getEmployerById(int id);
    void deleteEmployerById(int id);
    List<Employer> getEmployerByUpdatedTrue();

    @Transactional
    @Modifying
    @Query("Update Employer set isUpdated =: update where id =:employerId")
    void changeIsUpdated(boolean update, int employerId);
}
