package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "system_personals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemPersonal extends User{

    @Column(name = "username")
    @NotNull
    private String username;
}
