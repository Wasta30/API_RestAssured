package com.cybertek.day8;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BookItTest {


    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "https://cybertek-reservation-api-qa3.herokuapp.com";

    }

    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNDAiLCJhdWQiOiJzdHVkZW50LXRlYW0tbGVhZGVyIn0.xNvdQRyrYMb3Ec5QByHwXowBo3zPK2jQQS1eJ2RYIto";



    @DisplayName("Get all campuses")
    @Test
    public void testAuth1(){
        // put key in header and value is access token
        given().header("Authorization",accessToken)
                .and().accept(ContentType.JSON)
                .when()
                .get("/api/campuses")
                .then()
                .statusCode(200)
                .log().all();





    }


}
