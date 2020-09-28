package com.eandbsolutions;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class KafkaService {
    private String taco = "thing";

    public KafkaService() {
    }

    public KafkaService(String taco) {
        this.taco = taco;
    }

    public String getTaco() {
        return taco;
    }

    public void setTaco(String taco) {
        this.taco = taco;
    }

    public void findFile() {
        String fileName = "/src/main/resources/thing.txt";
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String fileLocation = userDir + fileName;
        File f = new File(fileLocation);
        System.out.println(fileLocation);
        if (f.exists()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


        String content = "";


        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("thing.txt");
        String filePath = classLoader.getResource("thing.txt").getPath();
        System.out.println(filePath);
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                content += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            content = new String(Files.readAllBytes(Paths.get(fileLocation)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println(content);
    }
}
