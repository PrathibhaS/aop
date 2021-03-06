package com.learn.aop.service.impl;

import com.learn.aop.exception.ObjectNotFoundException;
import com.learn.aop.model.Person;
import com.learn.aop.repository.IPersonRepository;
import com.learn.aop.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Person getPerson(int id) throws ObjectNotFoundException {
        Optional<Person> result = repository.findById(id);
        return result.orElseThrow(() -> new ObjectNotFoundException("ID " + id + " not found"));
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteById(id);
    }
}
