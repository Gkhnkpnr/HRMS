package com.example.hrms.mernisValidator;

import com.example.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class MernisValidatorManager {

    public boolean isMernis(JobSeeker jobSeeker){
        return jobSeeker.getIdentityNumber().length()==11;
    }
}
