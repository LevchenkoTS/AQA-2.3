package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void shouldPostToPostman() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    public void shouldReturnCurrency() {

        given()
                .baseUri("https://postman-echo.com")
                .body("currency:RUB")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("currency:RUB"))
        ;
    }
    @Test
    public void shouldReturnName() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("name:Ann")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("name:Ann"))
        ;
    }

    @Test
    public void shouldReturnId() {

        given()
                .baseUri("https://postman-echo.com")

                .body("id:2")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("id:2"))
        ;
    }
}
