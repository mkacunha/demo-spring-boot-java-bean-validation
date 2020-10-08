package com.mkacunha.demospringbootjavabeanvalidation.controller;

import com.mkacunha.demospringbootjavabeanvalidation.dto.PersonDto;
import com.mkacunha.demospringbootjavabeanvalidation.model.Person;
import com.mkacunha.demospringbootjavabeanvalidation.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/api/people")
    public void post(@RequestBody PersonDto dto) {
        personRepository.save(new Person(dto.getName(), dto.getDocument()));
    }
}
