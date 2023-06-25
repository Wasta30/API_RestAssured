package com.cybertek.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
"id": 15
"name": "Meta"
"gender": "Female"
"phone": 1938695106
 */
@Getter
@Setter
@ToString

@JsonIgnoreProperties(value="id",allowSetters = true)
// for the id value , we do not need it when posting the reuwest , so we tell jackson pls dont use id when sterilaze
public class Spartan {

    // we will create our field and type
    // getter setter
    // to String

    private int id;
    private String name;
    private String gender;
    private long phone;



}
