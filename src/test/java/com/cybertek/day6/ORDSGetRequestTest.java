package com.cybertek.day6;

import com.cybertek.Utilities.HRTestBase;
import com.cybertek.pojo.Employee;
import com.cybertek.pojo.Region;
import com.cybertek.pojo.Regions;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static java.lang.reflect.Array.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class ORDSGetRequestTest extends HRTestBase {


// create pojo classes for this response
    //then test it with sending get request to regions endpoint and
    // only pointing first region and converting your pojo

    @Test
    public void regionTest(){

        JsonPath jsonPath = get("/regions").then().statusCode(200).log().body().extract().jsonPath();


        Region region1 = jsonPath.getObject("items[0]", Region.class);
        // we are getting region 1 from item 0 , we practicwe two things together right now , pointing specific class and getting

        System.out.println("region1 = " + region1);

        System.out.println("region1.getRegion_id() = " + region1.getRId());
        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());
        System.out.println("region1.getLinks().get(0).getHref() = " + region1.getLinks().get(0).getHref());


    // jsonschema2pojo remember this website

        // we have variable name not matching with , if not matching use jsonproperty annotation
        // if the name is change from json , lets say region_id i make it regionID so i have to tell jackson whenver u see regionID put region_id here


    }



    @DisplayName("GET request to /employees and only get couple of values as a Pojo class\"")
    @Test
    public void employeeTest(){

        Employee employee1 = get("/employees").then().statusCode(200).extract().jsonPath().getObject("items[0]", Employee.class);
// we are getting error when we create pojo woith only 4 value we got unrecognied field etc because we dont have employee id fiweld in our pojo class how can we tell jackson ignore all key wthat we dont have in our pojjo class

        System.out.println("employee1 = " + employee1);


    }


    /* send a get request to regions
        verify that region ids are 1,2,3,4
        verify that regions names Europe ,Americas , Asia, Middle East and Africa
        verify that count is 4
        try to use pojo as much as possible
        ignore non used fields

     */


@DisplayName("Get request to region only some field test")
    @Test
    public void regionPojoTest(){
//send a get request and save everthing inside the regions object
    //since we prepare pojo also for the all properties we dont need to use any path so as() method is enough

    Regions regions = get("/regions").then().statusCode(200).extract().response().as(Regions.class);

    // verify count is 4
    assertThat(regions.getCount(),is(4));


    // create empty list to store value
    List<String> regionNames = new ArrayList<>();
    List<Integer> regionIds = new ArrayList<>();

    // get list of regions out of region object
    List<Region> items = regions.getItems();


    // loop through each of the region , save their ids and names to empty list that we prepare

    for(Region region : items){
        regionIds.add(region.getRId());
        regionNames.add(region.getRegion_name());


    }

//prepare expected result
    List<Integer> expectedRegionIds = Arrays.asList(1,2,3,4);
    List<String>  expectedRegionNames = Arrays.asList("Europe", "Americas", "Asia", "Middle East and Africa");


    //compare two result
    assertThat(regionIds,is(expectedRegionIds));
    assertThat(regionNames,is(expectedRegionNames));


}


}
