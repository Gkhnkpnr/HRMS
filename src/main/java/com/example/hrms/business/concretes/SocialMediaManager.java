package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.SocialMediaService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.SocialMediaDao;
import com.example.hrms.entities.concretes.SocialMedia;
import com.example.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import com.example.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SocialMediaManager implements SocialMediaService{

    private final SocialMediaDao socialMediaDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao, DtoConverterService dtoConverterService) {
        this.socialMediaDao = socialMediaDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addSocialMedia(SocialMediaAddDto socialMedia) {
        this.socialMediaDao.save((SocialMedia) this.dtoConverterService.dtoClassConverter(socialMedia, SocialMedia.class));
        return new SuccessResult("Sosyal medya başarıyla sisteme eklendi.");

    }

    @Override
    public Result updateSocialMedia(SocialMediaUpdateDto socialMedia) {
        this.socialMediaDao.save((SocialMedia) this.dtoConverterService.dtoClassConverter(socialMedia, SocialMedia.class));
        return new SuccessResult("Sosyal medya başarılı bir şekilde güncellendi");
    }

    @Override
    public DataResult<SocialMedia> getSocialMediaByResumeId(int id) {
        if (this.socialMediaDao.getSocialMediaByResumeId(id) == null){
            return new WarningDataResult<>("Listelenecek Sosyal Medya bulunamadı");
        }else{
            return new SuccessDataResult<>(this.socialMediaDao.getSocialMediaByResumeId(id), "Sosyal medya başarılı şekilde listelendi.");
        }
    }
}
