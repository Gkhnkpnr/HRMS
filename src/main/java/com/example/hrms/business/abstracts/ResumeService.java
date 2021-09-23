package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.addDtos.ResumeAddDto;
import com.example.hrms.entities.dtos.updateDtos.ResumeUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResumeService {
    Result addResume (ResumeAddDto resume);
    Result updateResume(ResumeUpdateDto resume);
    DataResult<Resume> findByJobSeekerId(int jobSeekerId);
    Result uploadPicture(int resumeId, MultipartFile file) throws IOException;
}
