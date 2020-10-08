package com.mkacunha.demospringbootjavabeanvalidation.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private UUID id = UUID.randomUUID();

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    @CPF(message = "CPF Invalid")
    @Column(name = "document")
    private String document;

    protected Person() {
        // JPA
    }

    public Person(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return document.equals(person.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}
