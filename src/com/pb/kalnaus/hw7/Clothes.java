package com.pb.kalnaus.hw7;

public abstract class Clothes {
    private String name;
    private Size size;
    private int price;
    private String color;


    public Clothes(String name , Size size, int price, String color) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
    }
}
