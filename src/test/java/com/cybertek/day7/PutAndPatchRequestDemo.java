package com.cybertek.day7;

import com.cybertek.Utilities.SpartanTestBase;
import com.cybertek.pojo.Spartan;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import java.util.*;

import static io.restassured.RestAssured.*;
public class PutAndPatchRequestDemo extends SpartanTestBase {


    @DisplayName("PUT request to one spartan for update with Map")
    @Test
    public void PUTRequest(){
        //just like post request we have different options to send body, we will go with map
        Map<String,Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name","BruceWayne");
        putRequestMap.put("gender","Male");
        putRequestMap.put("phone",8811111111L);

        given().contentType(ContentType.JSON) //hey api I am sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id",112)
                .when().put("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send

    }

    @DisplayName("PATCH request to one spartan for partial update with Map")
    @Test
    public void PATCHRequest(){
        //just like post request we have different options to send body, we will go with map
        Map<String,Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("phone",8811111122L);
        putRequestMap.put("name","Peter");

        given().contentType(ContentType.JSON) //hey api I am sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id",112)
                .when().patch("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with requestBody that we send


    }

    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan(){
        int idToDelete= 112;


        given().pathParam("id",idToDelete)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);

        //send a get request after you delete make sure you are getting 404

    }




}
//https://api.training.cydeo.com/swagger-ui.html#/user-controller
//http://18.234.107.50:8000/swagger-ui/#/Spartan%20Controller/searchAllUsingGET