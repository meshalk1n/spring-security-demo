package com.example.demo.services;

import com.example.demo.models.Person;
import com.example.demo.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServices {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationServices(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
    }
}