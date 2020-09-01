package com.learn.aop.service.impl;

import com.learn.aop.model.Person;
import com.learn.aop.repository.IPersonRepository;
import com.learn.aop.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Override
    public void create(Person p) {
        repository.save(p);
    }

    @Override
    public List<Person> getall() {
        return null;
    }

    @Override
    public Person getPerson(int ID) {
        return null;
    }

    @Override
    public void deleteByID(int ID) {

    }
}
