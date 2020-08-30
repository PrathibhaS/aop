package com.learn.aop.model;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String name;
    private int age;
    private Date dateOfBirth;
    private String email;
    private boolean isMarried;
    private Date wedAnniv;
}
