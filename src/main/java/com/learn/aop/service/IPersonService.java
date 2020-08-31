package com.learn.aop.service;

import com.learn.aop.model.Person;

import java.util.List;

public interface IPersonService {

    public void create(Person p);

    public List<Person> getall();

    public Person getPerson(int ID);

    public void deleteByID(int ID);
}
