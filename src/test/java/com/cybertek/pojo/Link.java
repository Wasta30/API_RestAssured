package com.cybertek.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Link {


    // i have link inside region
    private String rel;
    private String href;

    public String getRel() {
        return rel;
    }


}

