package com.example.demo.services;

import com.example.demo.models.Person;
import com.example.demo.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServices {

    private final PasswordEncoder passwordEncoder;

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationServices(PasswordEncoder passwordEncoder, PeopleRepository peopleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword())); // шифрование пароля
        peopleRepository.save(person);
    }
}