package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "resumes")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

    @OneToOne(mappedBy = "resume", cascade = CascadeType.DETACH)
    private SocialMedia socialMedia;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.DETACH)
    private List<Education> educations;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.DETACH)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.DETACH)
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.DETACH)
    private List<Technology> technologies;

}
