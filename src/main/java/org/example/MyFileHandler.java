package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileHandler {
    public static void readLinesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            int firstLine = Integer.parseInt(line);
            Item.setCapacity(firstLine);

            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                String[] numbers = nextLine.split(" ");
                Item.createNewItem(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
