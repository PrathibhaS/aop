package com.learn.aop.service.impl;

import com.learn.aop.model.Person;
import com.learn.aop.repository.IPersonRepository;
import com.learn.aop.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Override
    public void create(Person p) {
        repository.save(p);
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public Person getPerson(int id) {
        return repository.getOne(id);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }
}
