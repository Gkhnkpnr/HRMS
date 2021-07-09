package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employers_activations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerActivation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "is_email_confirmed")
    private boolean isEmail= false;

    @Column(name = "is_employer_actived")
    private boolean isActive=false;
}
