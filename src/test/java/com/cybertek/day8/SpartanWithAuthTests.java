package com.cybertek.day8;

import com.cybertek.Utilities.SpartanAuthTestBase;
import io.restassured.http.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
public class SpartanWithAuthTests extends SpartanAuthTestBase {

    @DisplayName("Get /api/spartans as a public user(guest)")
    @Test
    public void test1(){

        // 401 error expected as api doesnt know who am i now

        get("/api/spartans").then().statusCode(401).log().all();





    }


    @DisplayName("GET /api/spartans as admin user expect 200")
    @Test
    public void testAdmin(){
// how to pass admin  adminn as a username and password?
        given().auth().basic("admin","admin")
                .and().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .log().all();

    }



    @DisplayName("Delete/spartans/{id} as editor user expect 403")
    @Test
    public void testEditorDelete(){

        given().auth().basic("editor","editor")
                .and().accept(ContentType.JSON)
                .when()
                .delete("/api/spartans")
                .then().statusCode(403).log().body();




    }





}

/*

        As a homework,write a detealied test for Role Base Access Control(RBAC)
            in Spartan Auth app (7000)
            Admin should be able take all CRUD
            Editor should be able to take all CRUD
                other than DELETE
            User should be able to only READ data
                not update,delete,create (POST,PUT,PATCH,DELETE)
       --------------------------------------------------------
        Can guest even read data ? no , status code :  401 for all

 */