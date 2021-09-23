package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
    SocialMedia getSocialMediaByResumeId(int id);
}
