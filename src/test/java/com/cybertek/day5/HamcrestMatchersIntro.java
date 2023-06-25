package com.cybertek.day5;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @ DisplayName("Assertion with numbers")
    @Test
    public void simpleTest1(){
        // assertion library
        // hamcrest is library not related to api , diff from junit and testng
        // assertion with english
        // first introduce it without api and further learning api with it


        // is method is a method
        ////actual 5+5
        // so its like 5+5 equal to 10 and for ths we use is method which comes from Matchers class
        assertThat(5+5,is(10));

        // same as is method : equal To
        assertThat(5+5,equalTo(10));

        //matchers has 2 overloaded version
        //first that accept actual value
        //second taht accept another matchers
        //below examples is method is accepting another matchers equal to make it readable

        // it increases the readibility , we just combine above
        assertThat(5+5,is(equalTo(10)));

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo(9))));


       // number comparison
        //greaterThan()
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()
        assertThat(5+5,is(greaterThan(9)));





}



    @DisplayName("Assertion with String")
    @Test
    public void stringHamcrest(){
        String text = "EU10 is learning Hamcrest";

        // check if string equal to another string
        //checking for euqality is same as numbers
        assertThat(text,is("EU10 is learning Hamcrest"));
        assertThat(text,equalTo("EU10 is learning Hamcrest"));
        assertThat(text,is(equalTo("EU10 is learning Hamcrest")));


       // check if this text starts with EU10
        assertThat(text,startsWith("EU10"));
        //now do it in case insensitive manner
        assertThat(text,startsWithIgnoringCase("eu10"));
        //endswith
        assertThat(text,endsWith("rest"));


        //check if text contains String learning
        assertThat(text,containsString("learning"));
        //with ignoring case
        assertThat(text,containsStringIgnoringCase("LEARNING"));

        String str ="  ";

        //check if above str is blank
        assertThat(str,blankString());
        //check if trimmed str is empty string
        assertThat(str.trim(),emptyString());


    }


    @DisplayName("Hamcrest for Collection")
    @Test
    public void testCollection(){
        List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

        // we have list of integers
        //check size of the list
        assertThat(listOfNumbers,hasSize(10));
        //check if this list hasItem 77
        assertThat(listOfNumbers,hasItem(77));
        //check if this list hasItems 77,54,23
        assertThat(listOfNumbers,hasItems(77,54,23));

        //check if all numbers greater than 0
        // everytime , u  can put everythinh is , or all region id , without any loop u can put anything contains with , starts with etc
        assertThat(listOfNumbers,everyItem(greaterThan(0)));






    }




    }





