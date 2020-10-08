package com.mkacunha.demospringbootjavabeanvalidation.model;

import com.mkacunha.demospringbootjavabeanvalidation.AssertionsConstraintViolation;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {


    @Test
    void constraint_whenNameIsBlank_shouldReturnConstraintViolation() {
        Person person = new Person("", "39922910063");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        boolean contains = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()).contains("Name is required");
        assertTrue(contains);
    }

    @Test
    void constraint_whenCpfInvalid_shouldReturnConstraintViolation() {
        Person person = new Person("Person Name", "Invalid Document");
        AssertionsConstraintViolation.assertViolations(person, "CPF Invalid");
    }

    @Test
    void constraint_whenNameIsNull_shouldReturnConstraintViolation() {
        Person person = new Person("Person Name", "Invalid Document");
        AssertionsConstraintViolation.assertViolations(person, "Name is required");
    }

    @Test
    void constraint_test() {
        Person person = new Person("Person Name", "39922910063");
        AssertionsConstraintViolation.assertViolations(person, "Name is required");
    }
}