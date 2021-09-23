package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobSeekerLanguageService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import com.example.hrms.entities.concretes.JobSeekerLanguage;
import com.example.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private final JobSeekerLanguageDao jobSeekerLanguageDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao, DtoConverterService dtoConverterService) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save((JobSeekerLanguage) this.dtoConverterService.dtoClassConverter(jobSeekerLanguage, JobSeekerLanguage.class));
        return new SuccessResult("Yabancı dil bilgisi başarıyla eklenmiştir.");
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByResumeId(int id) {
        if (this.jobSeekerLanguageDao.getJobSeekerLanguageByResumeId(id).isEmpty()){
            return new WarningDataResult<>("Listelenecek yabancı dil bulunamadı");
        }else{
            return new SuccessDataResult<>(this.jobSeekerLanguageDao.getJobSeekerLanguageByResumeId(id), "Yabancı diller başarılı olarak listelendi");
        }
    }

    @Override
    public Result deleteJobSeekerLanguageById(int id) {
        this.jobSeekerLanguageDao.deleteJobSeekerLanguageById(id);
        return new SuccessResult("Yabancı dil başarılı bir şekilde silindi");
    }
}
