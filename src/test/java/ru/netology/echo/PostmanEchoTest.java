package ru.netology.echo;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {
    @Test
    void shouldTestPostValue() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .log().all()
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
                .contentType(ContentType.JSON)
                .log().all()
        ;
    }


}
