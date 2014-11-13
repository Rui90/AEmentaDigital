package com.example.rui.aementadigital;

/**
 * Created by guilh_000 on 24/10/2014.
 */
public class DessertsHelper {

    private final static int BOLOS = 1;
    private final static int CAFE = 2;
    private final static int DOCES = 3;
    private final static int FRUTAS = 4;
    private int dessert_type;
    private String name;
    private double price;
    private String priceName;

    public DessertsHelper(int dessert_type, String name, String priceName, double price) {
        this.dessert_type = dessert_type;
        this.name = name;
        this.price = price;
        this.priceName = priceName;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return dessert_type;
    }

    public double getPrice() {
        return price;
    }

    public String getNamePrice() {
        return priceName;
    }
}
