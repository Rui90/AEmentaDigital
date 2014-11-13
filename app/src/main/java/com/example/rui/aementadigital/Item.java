package com.example.rui.aementadigital;

/**
 * Created by Rui on 13/11/2014.
 */
public class Item {

    private String nameaux;
    private double priceaux;

    public Item(String name, double price) {
        this.nameaux = name;
        this.priceaux = price;
    }

    public String getName() {
        return this.nameaux;
    }

    public double getPrice() {
        return this.priceaux;
    }
}
