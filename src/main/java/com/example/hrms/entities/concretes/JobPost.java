package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "salary")
    @NotNull
    private int salary;

    @Column(name = "position_count")
    @NotNull
    private int positionCount;

    @Column(name = "deadline")
    @NotNull
    private LocalDate deadline;

    @Column(name = "airdate")
    @NotNull
    private LocalDateTime airdate = LocalDateTime.now();

    @Column(name = "up_time")
    @NotNull
    private String upTime;

    @Column(name = "type_of_employment")
    @NotNull
    private String typeOfEmployment;

    @Column(name = "is_active")
    @NotNull
    private boolean isActive=true;

    @Column(name = "is_confirmed")
    @NotNull
    private boolean isConfirmed = false;



}
