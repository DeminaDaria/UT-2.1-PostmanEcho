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
                .body("Cat")
                .log().all()
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("data", equalTo("Cat"))
                .contentType(ContentType.JSON)
                .log().all()
        ;
    }

    @Test
    void shouldTestPostValueRu() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Пингвин")

                .log().all()
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("data", equalTo("Пингвин"))
                .contentType(ContentType.JSON)
                .log().all()
        ;
    }
}
