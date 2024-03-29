package com.example.rui.aementadigital;

/**
 * Created by guilh_000 on 24/10/2014.
 */
public class StartersHelper {

    private final static int ENTRADAS = 1;
    private final static int SOPAS = 2;
    private int starter_type;
    private String name;
    private double price;
    private String namePrice;

    public StartersHelper(int starter_type, String name, String namePrice, double price) {
        this.starter_type = starter_type;
        this.name = name;
        this.price = price;
        this.namePrice = namePrice;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return starter_type;
    }

    public double getPrice() {
        return price;
    }

    public String getNamePrice() {
        return namePrice;
    }
}
