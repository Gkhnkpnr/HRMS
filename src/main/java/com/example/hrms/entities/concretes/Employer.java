package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employers", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User{

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "website")
    @NotNull
    private String website;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "picture_url")
    private String pictureUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobPost> jobPosts;

    @Column(name = "is_updated")
    private boolean isUpdated = false;

}
