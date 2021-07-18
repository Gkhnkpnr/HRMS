package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "jobseekers_activation")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerActivation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Jobseeker_id")
    private int jobseekerId;

    @Column(name = "is_email_confirmed")
    private boolean isEmail= false;

    @Column(name = "is_mernis_valid")
    private boolean isMernis = false;

}
