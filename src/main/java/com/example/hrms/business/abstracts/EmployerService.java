package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAllEmployers();
    Result addEmployer (Employer employer);
    Result updateEmployer(Employer employer);
    Result deleteEmployerById(int employerId);
    DataResult<Employer> getEmployerById(int employerId);
    Result uploadPicture(int employerId, MultipartFile file)throws IOException;
    DataResult<List<Employer>> getEmployerByIsUpdatedTrue();
    Result changeIsUpdated(boolean update, int employerId);
}
