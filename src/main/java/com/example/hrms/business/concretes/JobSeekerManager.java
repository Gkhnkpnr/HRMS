package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.services.EmailCheckService;
import com.example.hrms.core.services.MernisCheckService;
import com.example.hrms.core.utilities.EmailValidator;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private final JobSeekerDao jobSeekerDao;
    private final MernisCheckService mernisCheckService;
    private final EmailCheckService emailCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService, EmailCheckService emailCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService = mernisCheckService;
        this.emailCheckService = emailCheckService;
    }

    @Override
    public DataResult<List<JobSeeker>> getJobSeekers() {
        if ((long) this.jobSeekerDao.findAll().size() > 0){
            return new SuccessDataResult<>(this.jobSeekerDao.findAll(),"Tüm iş arayanlar başarılı bir şekilde listelendi.");
        }else{
            return new WarningDataResult<>(this.jobSeekerDao.findAll(), "Herhangi bir iş arayan bulunamadı");
        }
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        try{
            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())){
                return new ErrorResult("Email formata uygun değildir.");
            }else if(!mernisCheckService.isMernis(jobSeeker)){
                return new ErrorResult("TCKN geçerli değil");
            }else{
                this.jobSeekerDao.save(jobSeeker);
                return new SuccessResult("İş arayan kullanıcı sistemine başarılı bir şekilde eklendi "+ emailCheckService.emailValidator(jobSeeker));
            }
        }catch (Exception e){
            if (e.getMessage().contains("[uc_users_email]")){
                return new ErrorResult("Eposta sistemde kayıtlı lütfen başka bir eposta deneyiniz.");
            }else{
                return new ErrorResult("Kimlik numarası sistemde kayıtlı lütfen başka bir kimlik numarası deneyiniz.");
            }
        }
    }

    @Override
    public Result deleteJobSeekerById(int id) {
        this.jobSeekerDao.deleteJobSeekerById(id);
        return new SuccessResult("İş arayan başarılı bir şekilde sistemden silindi");
    }

    @Override
    public DataResult<JobSeeker> getJobSeekerById(int jobSeekerId) {
        if (this.jobSeekerDao.getJobSeekerById(jobSeekerId) == null){
            return new WarningDataResult<>("Kayıtlı iş arayan bulunamadı");
        }else{
            return new SuccessDataResult<>(this.jobSeekerDao.getJobSeekerById(jobSeekerId), "İş arayan başarılı bir şekilde listelendi");
        }
    }
}
