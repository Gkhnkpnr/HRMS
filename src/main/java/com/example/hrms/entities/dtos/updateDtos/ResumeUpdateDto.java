package com.example.hrms.entities.dtos.updateDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeUpdateDto {
    private int id;
    private int jobSeekerId;
    private String pictureUrl;
    private String coverLetter="";
}
