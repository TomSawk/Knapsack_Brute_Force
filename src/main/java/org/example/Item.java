package org.example;

import java.util.ArrayList;

public class Item {
    private final int id;
    private final int value;
    private final int weight;
    public static int capacity;
    private static ArrayList<Item> items = new ArrayList<>();

    Item(int value, int weight){
        this.value=value;
        this.weight =weight;
        items.add(this);
        id=items.size();
    }
    public int getValue() {
        return value;
    }
    public int getWeight() {
        return weight;
    }
    public static int getCapacity() {
        return capacity;
    }
    public static void setCapacity(int capacity) {
        Item.capacity = capacity;
    }
    public static int getNumOfItems(){
        return items.size();
    }
    public static void printAllItems(){
        System.out.println("Capacity: " + capacity);
        for (Item item:items) {
            System.out.println(item);
        }
    }
    public static void createNewItem(int value, int weight){
        new Item(value, weight);
    }
    public static ArrayList<Item> getItems() {
        return items;
    }
    public static int[] getWeights(){
        return items.stream()
                .map(Item::getWeight)
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public static int[] getValues(){
        return items.stream()
                .map(Item::getValue)
                .mapToInt(Integer::intValue)
                .toArray();
    }
    @Override
    public String toString() {
        return String.format("(%-2d)\tItem [value: %3d weight: %2d]", id, value, weight);
    }
}