package org.example.demo.test.controller;

import org.example.demo.test.dao.PersonRepository;
import org.example.demo.test.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPerson(Person person) {
        personRepository.save(person);
    }
}
