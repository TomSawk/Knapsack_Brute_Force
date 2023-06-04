package org.example;
public class BruteForce {
    private static int capacity = Item.getCapacity();
    private static int[] values = Item.getValues();
    private static int[] weights = Item.getWeights();
    private static int numItems = Item.getNumOfItems();
    private static int totalWeight=0;
    private static int maxValue = 0;
    private static int bestItems = 0;

    public static void doBruteForce(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < (1 << numItems); i++) {
            int currentWeight = 0;
            int currentValue = 0;

            for (int j = 0; j < numItems; j++) {
                if (((i >> j) & 1) == 1) {
                    currentWeight += weights[j];
                    currentValue += values[j];
                }
            }

            if (currentWeight <= capacity && currentValue > maxValue) {
                maxValue = currentValue;
                bestItems = i;
            }
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;


        System.out.println("Knapsack items:");
        for (int i = 0; i < numItems; i++) {
            if (((bestItems >> i) & 1) == 1) {
                System.out.println("Item " + (i + 1) + ": value = " + values[i] + ", weight = " + weights[i]);
                totalWeight+=weights[i];
            }
        }
        System.out.println("Knapsack items:");
        System.out.print("");
        for (int i = 0; i < numItems; i++) {
            if (((bestItems >> i) & 1) == 1) {
                System.out.print(" [1] ");
            }else {
                System.out.print(" [0] ");
            }
        }
        System.out.print("");

        System.out.println("\nTotal value: " + maxValue);
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Execution time: " + executionTime/1000 + " seconds");
    }
}