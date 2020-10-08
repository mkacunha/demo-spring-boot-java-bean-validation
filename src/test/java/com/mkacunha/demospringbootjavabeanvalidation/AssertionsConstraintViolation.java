package com.mkacunha.demospringbootjavabeanvalidation;

import org.opentest4j.AssertionFailedError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AssertionsConstraintViolation {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static <E> void assertViolations(E entity, String violation) {
        Set<ConstraintViolation<E>> constraintViolations = validator.validate(entity);

        if (constraintViolations.isEmpty()) {
            throw new AssertionFailedError(entity.getClass().getSimpleName() + " entity does not contain violations");
        }

        List<String> violations = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        if (!violations.contains(violation)) {
            throw new AssertionFailedError(entity.getClass().getSimpleName() + " entity does not contain violation", violation, violations);
        }
    }

}
