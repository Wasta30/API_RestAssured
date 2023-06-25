package com.cybertek.Utilities;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBase {

    @BeforeAll
    public static void init(){
        baseURI= "http://18.234.107.50:8000";
    }


}
