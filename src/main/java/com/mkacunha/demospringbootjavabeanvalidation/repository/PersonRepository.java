package com.mkacunha.demospringbootjavabeanvalidation.repository;

import com.mkacunha.demospringbootjavabeanvalidation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
