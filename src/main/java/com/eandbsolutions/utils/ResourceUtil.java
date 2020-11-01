package com.eandbsolutions.utils;

public class ResourceUtil {
    public void setResource(String propertyKey, String propertyValue) {
        System.setProperty(propertyKey, propertyValue);
    }
}
