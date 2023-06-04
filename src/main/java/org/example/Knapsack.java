package org.example;

import java.util.ArrayList;

public class Knapsack {
    public static void main(String[] args) {
        String useDir = System.getProperty("user.dir");
        System.out.println(useDir);
        MyFileHandler.readLinesFromFile(useDir + "/src/main/java/org/example/file.txt");
        System.out.println("Number of items " + Item.getNumOfItems());
        Item.printAllItems();

        System.out.println("\nCounting...");
        System.out.println("------------------------------------\nSolution");

        BruteForce.doBruteForce();
    }
}
