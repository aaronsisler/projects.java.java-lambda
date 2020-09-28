package com.eandbsolutions;

public class App {

    public static void main(String[] args) {
        System.out.println("Here");
        KafkaService kafkaService = new KafkaService();
        String returnedValue = kafkaService.getTaco();
        System.out.println("First: " + returnedValue + "\n");
        kafkaService.setTaco("more tacos");
        returnedValue = kafkaService.getTaco();

        System.out.println("Second: " + returnedValue + "\n");

        // Reading file location
        kafkaService.findFile();
    }
}
