package com.example.rui.aementadigital;

/**
 * Created by guilh_000 on 24/10/2014.
 */
public class DrinksHelper {

    private final static int VINHO = 1;
    private final static int CERVEJA = 2;
    private final static int REFRIGERANTE = 3;
    private int drink_type;
    private String name;
    private double price;

    public DrinksHelper(int drink_type, String name, double price) {
        this.drink_type = drink_type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getType() {
        return drink_type;
    }

    public double getPrice() {
        return price;
    }
}
