package com.cybertek.day5;
import com.cybertek.Utilities.SpartanTestBase;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class JSONtoJavaTest extends SpartanTestBase {


    @DisplayName("GET one Spartan and deserialize to Map")
    @Test
    public void oneSpartanToMap() {

        Response response = given().pathParam("id", 15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200).extract().response();

        //get the json and convert it to the map
// so we convert json response to map
        Map<String,Object> jsonMap = response.as(Map.class);

        System.out.println(jsonMap.toString());
        //after we got the map, we can use hamcrest or junit assertions to do assertion
        String actualname = (String) jsonMap.get("name");
        assertThat(actualname,is("Meta"));

//need Jackson (Databind) or Gson in the classpath for converting to java
// fot this i  add jackson in pomxml



    }
    @DisplayName("GET all spartans to JAVA data structure")
    @Test
    public void getAllSpartan(){

        Response response = get("/api/spartans").then().statusCode(200).extract().response();

        //we need to convert json to java  which is deserialize

        List<Map<String,Object>> jsonList = response.as(List.class);

        System.out.println("jsonList.get(1).get(\"name\") = " + jsonList.get(1).get("name"));

        Map<String,Object> spartan3 = jsonList.get(2);
        System.out.println(spartan3);


    }


    }
