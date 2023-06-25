package com.cybertek.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;


public class ORDSApiTestWithParameters {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI= "http://18.234.107.50:1000/ords/hr";



}

  /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */



    @DisplayName("GET request to \"/countries\" with Query Param")
    @Test
    public void test(){


        Response response = given().accept(ContentType.JSON).and().queryParam("q", "{\"region_id\":2}").log().all()
                .when().get("/countries");


        assertEquals(200,response.statusCode());


        // how to get any header ? after response.header and ggive name of

        assertEquals("application/json",response.header("Content-Type"));

        assertTrue(response.body().asString().contains("United States of America"));

        response.prettyPrint();



    }
 /*
        Send a GET request to employees and get only employees who works as a IT_PROG
     */



    @DisplayName("GET request to \"/employees\" with Query Param")
    @Test
    public void test1(){


        Response response = given().accept(ContentType.JSON).and().queryParam("q", "{\"job_id\": \"IT_PROG\"}").log().all()
                .when().get("/employees");


        assertEquals(200,response.statusCode());


        // how to get any header ? after response.header and ggive name of

        assertEquals("application/json",response.header("Content-Type"));

        assertTrue(response.body().asString().contains("IT_PROG"));

        response.prettyPrint();



    }

// remember we dont have ords documents and jamal told us q is the key , in above exercise we


    // can we verify if all jobs belong to IT prog what is
//  never use as string method , learn diff ways to navigate inside json

}
