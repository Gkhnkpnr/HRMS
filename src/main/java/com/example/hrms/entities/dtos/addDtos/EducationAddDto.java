package com.example.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationAddDto {
    private int id;
    private int resumeId;
    private int schoolId;
    private int departmentId;
    private LocalDate startDate;
    private LocalDate endDate;
}
