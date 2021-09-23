package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.SchoolDao;
import com.example.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private final SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result addSchool(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Okul başarıyla sisteme eklendi");
    }

    @Override
    public DataResult<List<School>> getSchools() {
        if (this.schoolDao.findAll().isEmpty()){
            return new WarningDataResult<>("Kayıtlı okul bulunamadı.");
        }else{
            return new SuccessDataResult<>(this.schoolDao.findAll(),"Kayıtlı okullar başarılı bir şekilde listelendi.");
        }
    }
}
