package com.betterjavacode.reusablesociallogin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class User
{
    public String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
