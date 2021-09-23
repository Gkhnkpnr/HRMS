package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.DepartmentService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.DepartmentDao;
import com.example.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Result addDepartment(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Success: Deparman Başarılı bir şekilde elendi.");
    }

    @Override
    public DataResult<List<Department>> getAllDepartment() {
        if (this.departmentDao.findAll().isEmpty()){
            return new WarningDataResult<>("Warning: Kayıtlı bölüm bulunamadı");
        }else{
            return new SuccessDataResult<>(this.departmentDao.findAll(), "Success: Bölümler başarıyla listelendi.");
        }
    }
}
