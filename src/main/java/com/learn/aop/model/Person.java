package com.learn.aop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Max(value = 70)
    @NotBlank
    private String name;

    @Size(max = 130)
    private int age;

    private Date dateOfBirth;

    @Pattern(regexp = "[A-Z0-9a-z._%+-]+@([A-Za-z0-9._%+-]+).[A-Za-z]{2,4}]*")
    private String email;

    private boolean isMarried;

    private Date wedAnniv;
}
