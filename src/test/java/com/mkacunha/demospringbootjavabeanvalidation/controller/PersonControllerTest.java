package com.mkacunha.demospringbootjavabeanvalidation.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @LocalServerPort
    private int serverPort = 0;

    @BeforeEach
    void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    void post() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"\",\"document\": \"\"}")
                .post("/api/people")
                .then()
                .statusCode(400)
                .body("violations[0]", Matchers.equalTo("CPF Invalid"))
                .body("violations[1]", Matchers.equalTo("Name is required"));

    }
}