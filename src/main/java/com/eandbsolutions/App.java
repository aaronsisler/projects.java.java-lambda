package com.eandbsolutions;

import com.eandbsolutions.models.User;
import com.eandbsolutions.services.DatabaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    public static void main(String[] args) throws JsonProcessingException {
        DatabaseService databaseService = new DatabaseService();
        User user = databaseService.getItem();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        System.out.println(jsonString);
    }
}
