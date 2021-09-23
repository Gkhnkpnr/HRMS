package com.example.hrms.core.services;

import com.example.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
    boolean isMernis(JobSeeker jobSeeker);
}
