package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.services.CloudinaryService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.ResumeDao;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.addDtos.ResumeAddDto;
import com.example.hrms.entities.dtos.updateDtos.ResumeUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ResumeManager implements ResumeService {
    private final ResumeDao resumeDao;
    private final CloudinaryService cloudinaryService;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
        this.resumeDao = resumeDao;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;
    }


    @Override
    public Result addResume(ResumeAddDto resume) {
        if (resume.getPictureUrl().equals("")){
            resume.setPictureUrl("https://res.cloudinary.com/gokhanakpinar/image/upload/v1623696505/sample.jpg");
            this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resume, Resume.class));
            return new SuccessResult("Success: CV başarılı bir şekilde yüklendi.");
        }else{
            this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resume, Resume.class));
            return new SuccessResult("Success: CV başarılı bir şekilde yüklendi");
        }
    }

    @Override
    public Result updateResume(ResumeUpdateDto resume) {
        if (resume.getPictureUrl().equals("")){
            resume.setPictureUrl("https://res.cloudinary.com/gokhanakpinar/image/upload/v1623696505/sample.jpg");
            this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resume, Resume.class));
            return new SuccessResult("Success: CV başarılı bir şekilde güncellendi");
        }else{
            this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resume, Resume.class));
            return new SuccessResult("Success: CV başarılı bir şekilde güncellendi.");
        }
    }

    @Override
    public DataResult<Resume> findByJobSeekerId(int jobSeekerId) {
        if (this.resumeDao.findByJobSeekerId(jobSeekerId)==null){
            return new WarningDataResult<>("Warning: Kayıtlı CV bulunamadı");
        }else{
            return new SuccessDataResult<>("Success: CV'ler başarılı bir şekilde listelendi");
        }
    }

    @Override
    public Result uploadPicture(int resumeId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.addPicture(file);
        var url = result.getData().get("url");
        Resume res = this.resumeDao.getOne(resumeId);
        res.setPictureUrl(url.toString());
        this.resumeDao.save(res);
        return new SuccessResult("Success: Resim başarı bir şekilde yüklendi.");
    }
}
