package org.example.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileUtils {
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
    }

    public static void removeFile(String filePath) {
        java.io.File file = new java.io.File(filePath);
        if (file.delete()) {
            System.out.println("File deleted successfully: " + filePath);
        } else {
            System.out.println("Failed to delete the file: " + filePath);
        }
    }
}