package com.example.hrms.core.adapters;

import com.example.hrms.core.services.MernisCheckService;
import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.mernisValidator.MernisValidatorManager;
import org.springframework.beans.factory.annotation.Autowired;

public class MernisValidatorManagerAdapter implements MernisCheckService {
    private final MernisValidatorManager mernisValidatorManager;

    @Autowired
    public MernisValidatorManagerAdapter(MernisValidatorManager mernisValidatorManager) {
        this.mernisValidatorManager = mernisValidatorManager;
    }

    @Override
    public boolean isMernis(JobSeeker jobSeeker) {
        return this.mernisValidatorManager.isMernis(jobSeeker);
    }
}
