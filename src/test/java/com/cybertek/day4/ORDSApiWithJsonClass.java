package com.cybertek.day4;
import io.restassured.path.json.*;
import com.cybertek.Utilities.HRTestBase;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ORDSApiWithJsonClass extends HRTestBase {


    @DisplayName("Get request to Countries")
    @Test
    public void test1(){
        Response response = get("/countries");

        //get the second country name with JsonPath

        //to use jsonpath we assign response to JsonPath
        JsonPath jsonPath = response.jsonPath();

        String secondCountryName = jsonPath.getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        // get all country ids

        // to get all country id use items.country_id

        List<String> allCountriesIds = jsonPath.getList("items.country_id");
        System.out.println(allCountriesIds);

        //   //get all country names where their region id is equal to 2
// this is like if statement how to get result if u have json and filter it
        // inside item array it refer to each , check each of region id whenever region id is equal to 2 we  want the country name , it is kind of iterator for each region id we get counyty namr and save it inside list of string
        // inside curly base is conditon and afrer it we have value its llike if conditon
        List<String> countryNameWithRegionId2 = jsonPath.getList("items.findAll {it.region_id==3}.country_name");
        System.out.println(countryNameWithRegionId2);


    }


    @DisplayName("GET requesto /employees with query param")
    @Test
    public void test2() {
        //we added limit query param to get 107 employees
        Response response =given().queryParam("limit", 107)
                .when().get("/employees");



        //get me all email of employees who is working as IT_PROG

        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();
        //get me all email of employees who is working as IT_PROG
        List<String> employeeITProgs = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
        System.out.println(employeeITProgs);

        //get me first name of employees who is making more than 10000
        List<String> empNames = jsonPath.getList("items.findAll {it.salary>10000}.first_name");
        System.out.println(empNames);

        //get the max salary first_name
        // both json and response path can have it method
        String kingFirstName = jsonPath.getString("items.max {it.salary}.first_name");
        String kingNameWithPathMethod = response.path("items.max {it.salary}.first_name");
        System.out.println("kingFirstName = " + kingFirstName);
        System.out.println("kingNameWithPathMethod = " + kingNameWithPathMethod);
    }



    }


