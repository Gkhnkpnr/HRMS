package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "jobseekers")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker extends User{

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "identity_number")
    @NotNull
    private String identityNumber;

    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "jobseeker", cascade = CascadeType.DETACH)
    private List<Resume> resumes;

    @OneToMany(mappedBy = "jobseeker", cascade = CascadeType.DETACH)
    private List<Favorite> favorites;

}
