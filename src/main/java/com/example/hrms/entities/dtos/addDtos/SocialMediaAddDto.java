package com.example.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialMediaAddDto {
    private int id;
    private int resumeId;
    private String githubUsername;
    private String linkedinUsername;
}
