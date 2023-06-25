package com.cybertek.day5;

import com.cybertek.Utilities.SpartanTestBase;
import io.restassured.http.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class SpartanHamcrestTest extends SpartanTestBase {

    @DisplayName("GET spartan/search and chaining together")
    @Test
    public void test1() {
        //along with this statement, I want to save names inside the List<String>
        List<String> name = given().accept(ContentType.JSON)
                .and()
                .queryParams("nameContains", "j",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .and()
                .body("totalElement", greaterThanOrEqualTo(3))
                .extract().response().jsonPath().getList("content.name");
// extract allow us to get whatever we get
        System.out.println(name);


    }




    @DisplayName("GET spartan/search and chaining together")
    @Test
    public void test2(){






    }
}
