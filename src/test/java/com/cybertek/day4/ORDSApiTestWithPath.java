package com.cybertek.day4;

import com.cybertek.Utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class ORDSApiTestWithPath extends HRTestBase {


    @DisplayName("Get request to countries with Path method")
    @Test
    public void test1(){

        Response response= given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());
// how to retrive specific json key value from jsno body , byy path method
        // print limit result

        System.out.println("response.path(\"limit\") = " + response.path("limit"));

//print hasMore
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //prinnt first countryID
        String firstCountryId = response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);
        //print second country name
        String secondCountryname = response.path("items[1].country_name");
        System.out.println("secondCountryname = " + secondCountryname);

        //print "http://52.207.61.129:1000/ords/hr/countries/CA"

       String thirdHref = response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);

        //get me all country names
        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);

        // json path finder website remember wasta
// if there is an array and u dont provide index it will return the array list
        // even if u have one value it will give array list so always give index number

        // assert that all region ids are equal to 2

        List <Integer>  allRegionIds= response.path("items.region_id");

        // how to assert ? i mean how to verify , use for each loop


       for (Integer regionsID : allRegionIds){
           System.out.println("regionsID = " + regionsID);
           assertEquals(2,regionsID);

       }






        }


    @DisplayName("GET request to \"/employees\" with Query Param")
    @Test
    public void test2(){


        Response response = given().accept(ContentType.JSON).and().queryParam("q", "{\"job_id\": \"IT_PROG\"}").log().all()
                .when().get("/employees");


        assertEquals(200,response.statusCode());


        assertEquals("application/json",response.header("Content-Type"));

        assertTrue(response.body().asString().contains("IT_PROG"));

        // make sure we have only id prog as job id
        List<String> allJobIDs = response.path("items.job_id");

        for (String jobID: allJobIDs){
            assertEquals("IT_PROG",jobID);
            System.out.println("jobID = " + jobID);
        }


    }









}
