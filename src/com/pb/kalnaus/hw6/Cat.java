package com.pb.kalnaus.hw6;

import java.util.Objects;

public class Cat extends Animal {


    private String vision = "острое, ночное зрение";

    public Cat(String food, String location) {

        super(food, location);
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    @Override
    public void makeNoise() {
        System.out.println("Коты мяукают когда хотят кушать");
    }

    @Override
    public void eat() {
        System.out.println("Кот кушает " + getFood() + " с большим удовольствием ");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;

        Cat cat = (Cat) o;

        return vision.equals(cat.vision) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vision, getFood(), getLocation());

    }

    @Override
    public String toString() {
        return "Кот имеет " + vision + ". Любит :" + getFood() +" и проживает на " + getLocation()  ;
    }
}



