package com.pb.kalnaus.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private String name;
    private Size size;
    private int price;
    private String color;

    public Skirt(String name, Size size, int price, String color) {
        super(name, size, price, color);
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public String dressWomen() {
        return "Название --> "+ name + " Размер --> " + size.name() + ", Описание --> " + size.getDescription() +
                ",Евро размер --> " + size.getEuroSize() +" Цена --> "+ price +" Цвет --> "+ color;
    }
}
