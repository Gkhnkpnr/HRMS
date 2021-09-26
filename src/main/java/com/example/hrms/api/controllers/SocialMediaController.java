package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.SocialMediaService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.SocialMedia;
import com.example.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import com.example.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediaController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getSocialMediaByResumeId")
    public DataResult<SocialMedia> getSocialMediaByResumeId(@RequestParam int resumeId){
        return this.socialMediaService.getSocialMediaByResumeId(resumeId);
    }

    @PostMapping("/addSocialMedia")
    public Result addSocialMedia(@RequestBody SocialMediaAddDto socialMedia){
        return this.socialMediaService.addSocialMedia(socialMedia);
    }

    @PutMapping("/updateSocialMedia")
    public Result updateSocialMedia(@RequestBody SocialMediaUpdateDto socialMedia){
        return this.socialMediaService.updateSocialMedia(socialMedia);
    }
}
