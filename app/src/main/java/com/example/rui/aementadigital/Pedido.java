package com.example.rui.aementadigital;

/**
 * Created by Rui on 04/11/2014.
 */
public class Pedido {

    private String produtName;
    private double price;
    private int quantidade;

    public Pedido(String nome, double price, int quantidade) {
        this.produtName = nome;
        this.price = price;
        this.quantidade = quantidade;

    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }
}
