package com.eandbsolutions;

import com.eandbsolutions.models.User;
import com.eandbsolutions.services.DatabaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    public static void main(String[] args) throws JsonProcessingException {
        DatabaseService databaseService = new DatabaseService();
        databaseService.getTables();
        User user = databaseService.getItem();
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(user);
        System.out.println(jsonString);
    }
}
