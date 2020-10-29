package com.eandbsolutions.models;

public class UtilityInj {
    private String taco = "taco";

    public String getTaco() {
        System.out.println("In the UtilityInj");
        return taco;
    }
}
