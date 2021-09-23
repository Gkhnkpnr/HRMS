package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.SocialMedia;
import com.example.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import com.example.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;

import java.util.List;

public interface SocialMediaService {
    Result addSocialMedia(SocialMediaAddDto socialMedia);
    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);
    DataResult<SocialMedia> getSocialMediaByResumeId(int id);
}
