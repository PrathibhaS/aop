package com.learn.aop.service;

import com.learn.aop.exception.ObjectNotFoundException;
import com.learn.aop.model.Person;

import java.util.List;

public interface IPersonService {

    void create(Person p);

    List<Person> getAll();

    Person getPerson(int id) throws ObjectNotFoundException;

    void deleteByID(int id);
}
