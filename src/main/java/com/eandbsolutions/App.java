package com.eandbsolutions;

import org.joda.time.Instant;

public class App {

    public static void main(String[] args) {
        System.out.println("Here");
        Instant instant = new Instant();
        String thing = instant.toString();
        System.out.println(thing);
    }
}
