package com.eandbsolutions.services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public static void findLocalFile(String filePath) {
        File f = new File(filePath);
        System.out.println(filePath);
        if (f.exists()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        try {
            String fileContents = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println(fileContents);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String findResourceFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        String filePath = classLoader.getResource("thing.txt").getPath();
        File f = new File(filePath);
        System.out.println(filePath);
        if (f.exists()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String content = "";

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

        System.out.println(content);

        return content;
    }
}
