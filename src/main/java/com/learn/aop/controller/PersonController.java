package com.learn.aop.controller;

import com.learn.aop.model.Person;
import com.learn.aop.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonService personService;

    /*@RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Person p) {
        LOG.debug("inside post");
        personService.create(p);
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAll() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Person getPerson(@PathVariable("id") int pid) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Person p, @PathVariable("id") int id) {

    }
}
