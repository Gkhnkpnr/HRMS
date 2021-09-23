package com.example.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAddDto {
    private int id;
    private int jobSeekerId;
    private String pictureUrl;
    private String coverLetter = "";
}
