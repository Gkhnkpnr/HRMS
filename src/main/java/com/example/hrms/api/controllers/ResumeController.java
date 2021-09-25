package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.ResumeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.addDtos.ResumeAddDto;
import com.example.hrms.entities.dtos.updateDtos.ResumeUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;

public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getResumeByJobSeekerId")
    public DataResult<Resume> findResumeByJobSeekerId(int jobSeekerId){
        return this.resumeService.findByJobSeekerId(jobSeekerId);
    }

    @PostMapping("/addResume")
    public Result addResume(@RequestBody ResumeAddDto resumeAddDto){
        return this.resumeService.addResume(resumeAddDto);
    }

    @PutMapping("/updateResume")
    public Result updateResume (@RequestBody ResumeUpdateDto resumeUpdateDto){
        return this.resumeService.updateResume(resumeUpdateDto);
    }

    @PutMapping("/addPicture")
    public Result addPicture(int resumeId, MultipartFile file)throws IOException {
        return this.resumeService.uploadPicture(resumeId, file);
    }
}
