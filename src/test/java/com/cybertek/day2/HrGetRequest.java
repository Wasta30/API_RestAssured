package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HrGetRequest {

    // it will run before anything
    // its valid for one class
    // ords is rest api for oracle database
    @BeforeAll
    public static void init(){
        RestAssured.baseURI= "http://18.234.107.50:1000/ords/hr";
    }


    @DisplayName("Get request to /regions")
    @Test
    public void test1(){

        // so url will execute first and no need to write here
        Response response = get("/regions");

        // print status code
        System.out.println(response.statusCode());

    }


    /*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */


    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON).when().get("/regions/2");

        System.out.println(response.statusCode());


        assertEquals("application/json",response.contentType());


        assertTrue(response.body().asString().contains("Americas"));

    }



}
