package com.cybertek.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    // need only first 4 value
   // tell jackson to ignore rest of the value
    /*
    first name
    last name
    job id
    salary
     */

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("job_id")
    private String jobId;

    private int salary;




}
