package com.cybertek.day3;
import com.cybertek.Utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class SpartanTestWithPath extends SpartanTestBase {




 /*
     Given accept type is json
     And path param id is 10
     When user sends a get request to "api/spartans/{id}"
     Then status code is 200
     And content-type is "application/json"
     And response payload values match the following:
          id is 10,
          name is "Lorenza",
          gender is "Female",
          phone is 3312820936
   */



    @DisplayName("Get spartan method wit Path Method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).and().pathParams("id", 10).when()
                .get("api/spartans/{id}");


        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());


        // we test json inside by .path method remember this
        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        // this method T will return whatever variable u pass let say int and string on next side
        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        assertEquals(10,id);
        assertEquals("Lorenza",name);
        assertEquals("Female",gender);
        assertEquals(3312820936l,phone);

    }


    @DisplayName("GET all spartan and navigate with Path()")
    @Test
    public void test2(){


        Response response = given().accept(ContentType.JSON).when().get("/api/spartans");

      //  response.prettyPrint();

        // how to get only one id when u have multiple id in spartan ?
        // use index as this is aray so put index and get id number from there

        int firstID = response.path("id[0]");
        System.out.println("firstID = " + firstID);

        String name = response.path("name[0]");
        System.out.println("name = " + name);

        // how to get last name use index [-1]

        String lastName = response.path("name[-1]");
        System.out.println("lastName = " + lastName);


        // to get all name use list of string
//save names inside the list of string
        List<String> names = response.path("name");
        System.out.println(names);

        // we can also use loop and get names one by one

      for (String n : names){
          System.out.println(n);
      }

    }


}
