package com.cybertek.day4;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
public class CBTrainingAPI {


    // if there is no array we do not need to specify index
    // if theres an json object inside json object always give name of value and no need to specofy index , index is for array
    @BeforeAll
    public static void init() {

        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "https://api.training.cydeo.com";

    }


    @DisplayName("GET Request to individual student")
    @Test
    public void test1() {
        //send a get request to student id 23401 as a path parameter and accept header application/json
        //verify status code=200 /content type=application/json;charset=UTF-8 /Content-Encoding = gzip
        //verify Date header exists
        //assert that
            /*
                firstName Vera
                batch 14
                section 12
                emailAddress aaa@gmail.com
                companyName Cybertek
                state IL
                zipCode 60606

                using JsonPath
             */


    }
}
