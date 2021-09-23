package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getJobPositions() {
        if ((long) this.jobPositionDao.findAll().size() > 0){
            return new SuccessDataResult<>(this.jobPositionDao.findAll(), "İş Pozisyonları başarılı bir şekilde listelendi");
        }else{
            return new WarningDataResult<>(this.jobPositionDao.findAll(), "Listelenecek iş pozisyonu bulunamadı");
        }
    }

    @Override
    public Result addJobPosition(JobPosition jobPosition) {
        try{
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("İş Pozisyonu başarılı bir şekilde kaydedildi.");
        }catch (Exception e){
            return new ErrorResult("Sisteme kayıtlı böyle bir pozisyon mevcut");
        }
    }
}
