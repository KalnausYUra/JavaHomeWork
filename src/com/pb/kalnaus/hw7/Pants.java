package com.pb.kalnaus.hw7;

public class Pants extends Clothes implements ManClothes,WomenClothes{
    private String name;
    private Size size;
    private int price;
    private String color;

    public Pants(String name, Size size, int price, String color) {
        super(name, size, price, color);
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public String dressMan() {

        return "Название --> "+ name + " Размер --> " + size.name() + ", Описание --> " + size.getDescription() +
                ",Евро размер --> " + size.getEuroSize() +" Цена --> "+ price +" Цвет --> "+ color;
    }

    @Override
    public String dressWomen() {
        return "Название --> "+ name + " Размер --> " + size.name() + ", Описание --> " + size.getDescription() +
                ",Евро размер --> " + size.getEuroSize() +" Цена --> "+ price +" Цвет --> "+ color;
    }
}
