package com.cybertek.day6;

import com.cybertek.Utilities.SpartanTestBase;
import com.cybertek.pojo.Search;
import com.cybertek.pojo.Spartan;
import io.restassured.http.ContentType;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.*;
public class SpartanPojoGetRequestTest extends SpartanTestBase {


    @DisplayName("GET one spartan and convert it to Spartan Object")
    @Test
    public void oneSpartanPojo() {

// i aam telling rest assured librarby convert my spartan class to take json and de stralize it into my class
        // send get req to one spartan and save it in response object

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .log().all()
                .extract().response();

        //De serialize --> JSON to POJO (java custom class)
        //2 different way to do this
        //1.using as() method
        //we convert json response to spartan object with the help of jackson
        //as() method uses jackson to de serialize(converting JSON to Java class)

// pls convert spartan class and save it inside spartan15 object
        // we have to  create
        Spartan spartan15 = response.as(Spartan.class);
        System.out.println("spartan15 = " + spartan15);
        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());


        //second way of deserialize json to java
        //2.using JsonPath to deserialize to custom class

        JsonPath jsonPath = response.jsonPath();

        // i m leaving path empty and after comma give class name
        Spartan s15 = jsonPath.getObject("", Spartan.class);
        System.out.println("s15 = " + s15);
        System.out.println("s15.getName() = " + s15.getName());
        System.out.println("s15.getGender() = " + s15.getGender());
        System.out.println("s15.getPhone() = " + s15.getPhone());
//line 50 and line 38 same thing











    }



    @DisplayName("Get one spartan from search endpoint result and use POJO")
    @Test
    public void spartanSearchWithPojo(){

        ///spartans/search?nameContains=a&gender=Male
        // send get request to above endpoint and save first object with type Spartan POJO

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().queryParams("nameConatins", "a", "gender", "Male")
                .when().get("/api/spartans/search")
                .then().statusCode(200).extract().jsonPath();


        //get first spartan from content list and put inside spartan object
        Spartan s1 = jsonPath.getObject("content[0]", Spartan.class);
        System.out.println("s1.getName() = " + s1.getName());
        System.out.println("s1.getGender() = " + s1.getGender());
        System.out.println("s1.getId() = " + s1.getId());
        System.out.println("s1.getPhone() = " + s1.getPhone());

// as method nt give u option to give the path





    }

    @Test
    public void test3(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParams("nameConatins", "a", "gender", "Male")
                .when().get("/api/spartans/search")
                .then().statusCode(200).extract().response();


        Search searchResult = response.as(Search.class);

        System.out.println("searchResult.getContent().get(0).getName() = " + searchResult.getContent().get(0).getName());
        System.out.println("searchResult.getContent().get(1) = " + searchResult.getContent().get(1));
        System.out.println("searchResult.getContent().get(0) = " + searchResult.getContent().get(0));


    }

// content refer to list of spartan
    @DisplayName("GET  /spartans/search and save as List<Spartan>")
    @Test
    public void test4(){


        List<Spartan> SpartanList = given().accept(ContentType.JSON)
                .and().queryParams("nameConatins", "a", "gender", "Male")
                .when().get("/api/spartans/search")
                .then().statusCode(200).extract().jsonPath().getList("content", Spartan.class);

// here we are converting json to java using jsonpath
        // we want to get all content snf its inside content
        // and the class for this i created is Spartan class
        // and this content of object is converted to list of spartan

        System.out.println("SpartanList.get(1).getName() = " + SpartanList.get(1).getName());

    }



    }




