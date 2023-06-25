package com.cybertek.Utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HRTestBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI= "http://18.234.107.50:1000/ords/hr";
    }

}
