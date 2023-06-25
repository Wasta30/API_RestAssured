package com.cybertek.Utilities;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;
public class SpartanAuthTestBase {

    @BeforeAll
    public static void init() {
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://18.234.107.50:7000";


    }
    }
