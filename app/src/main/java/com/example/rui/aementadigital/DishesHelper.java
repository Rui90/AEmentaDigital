package com.example.rui.aementadigital;

/**
 * Created by Rui on 21/10/2014.
 */
public class DishesHelper {

    private final static int MEAT = 1;
    private final static int FISH = 2;
    private final static int VEGAN = 3;
    private final static int PASTA = 4;
    private int food_type;
    private String name;
    private double price;
    private String namePrice;

    public DishesHelper(int food_type, String name, String namePrice, double price) {
        this.food_type = food_type;
        this.name = name;
        this.price = price;
        this.namePrice = namePrice;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return food_type;
    }

    public double getPrice() {
        return price;
    }

    public String getNamePrice() {
        return namePrice;
    }
}
