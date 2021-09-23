package com.example.hrms.entities.dtos.addDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostAddDto {
    private int id;
    private int employerId;
    private int cityId;
    private int jobPositionId;
    private String description;
    private LocalDate deadline;
    private String uptime;
    private String typeOfEmployment;
    private int positionCount;
    private int salary;
}
