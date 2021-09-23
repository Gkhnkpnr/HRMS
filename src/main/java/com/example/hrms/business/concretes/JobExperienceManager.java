package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobExperienceDao;
import com.example.hrms.entities.concretes.JobExperience;
import com.example.hrms.entities.dtos.addDtos.JobExperienceAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addJobExperience(JobExperienceAddDto jobExperience) {
        this.jobExperienceDao.save((JobExperience) this.dtoConverterService.dtoClassConverter(jobExperience, JobExperience.class));
        return new SuccessResult("Kariyer bilgisi başarılı bir şekilde eklendi.");
    }

    @Override
    public DataResult<List<JobExperience>> getJobExperienceByResumeId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        if (this.jobExperienceDao.getJobExperienceByEndDateByResumeId(id, sort).isEmpty()){
            return new WarningDataResult<>("listelenecek iş tecrübesi bulunamadı");
        }else{
            return new SuccessDataResult<>(this.jobExperienceDao.getJobExperienceByEndDateByResumeId(id, sort),"İş tecrübeleri başarılı bir şekilde sıralanıp listelendi.");
        }
    }

    @Override
    public Result deleteJobExperienceById(int id) {
        this.jobExperienceDao.deleteJobExperienceById(id);
        return new SuccessResult("Tecrübe başarılı bir şekilde silindi.");
    }
}
