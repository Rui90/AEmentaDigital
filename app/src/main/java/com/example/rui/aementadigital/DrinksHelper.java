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
    private String namePrice;

    public DrinksHelper(int drink_type, String name, String namePrice, double price) {
        this.drink_type = drink_type;
        this.name = name;
        this.price = price;
        this.namePrice = namePrice;
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

    public String getNamePrice() {
        return namePrice;
    }
}
