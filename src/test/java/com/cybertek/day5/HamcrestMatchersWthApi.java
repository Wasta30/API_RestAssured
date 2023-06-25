package com.cybertek.day5;
import io.restassured.http.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchersWthApi {

    /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
           "id": 15,
           "name": "Meta",
           "gender": "Female",
           "phone": 1938695106
        */

    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1(){

        // u can verify from then method like
        given().accept(ContentType.JSON)
                .and().pathParams("id",15)
                .when()
                .get("http://18.234.107.50:8000/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat()
                .contentType("application/json")
                .and()
                .body("id",equalTo(15),"name",is("Meta"),"gender", is("Female"),"phone",is(1938695106))
                .log().all();

// we use body method and put everything here ,before it was with a long procedure , its holding one request
// before then everything is request and after then response start and we do our assertion
        // and this is chaining structure with hamcrest method
        // first methood was contain then we learn path method then json path and this is the 4th method


    }


    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void teacherData(){

        given().accept(ContentType.JSON)
                .and().pathParams("id",3)
                .when().get("https://api.training.cydeo.com/teacher/{id}")
                .then()
                .statusCode(200)
                .and().contentType("application/json;charset=UTF-8")
                .and().header("Date",notNullValue())
                .and().assertThat()
                .body("teachers[0].firstName", is("Tet"))
                .body("teachers[0].lastName",is("DS"))
                .body("teachers[0].gender",equalTo("Male"));



    }

    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){

        given()
                .accept(ContentType.JSON)
                .when().get("https://api.training.cydeo.com/teacher/all")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .and()
                .body("teachers.firstName",hasItems("Tet","Valter","Mario"));






    }






}
