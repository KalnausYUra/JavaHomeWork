package com.pb.kalnaus.hw6;

import java.util.Objects;

public class Dog extends Animal {

    private String makeSounds = "лаять, выть или рычать";

    public Dog(String food, String location) {

        super(food, location);
    }

    public String getMakeSounds() {
        return makeSounds;
    }

    public void setMakeSounds(String makeSounds) {
        this.makeSounds = makeSounds;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака бушует, когда грается с "+ getFood());
    }



    @Override
    public void eat() {
        System.out.println("Собака кушает " + getFood());

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;

        Dog dog = (Dog) o;

        return makeSounds.equals(dog.makeSounds) ;
    }


    @Override
    public int hashCode() {
        return Objects.hash(makeSounds, getFood(), getLocation());

    }

    @Override
    public String toString() {
        return "Собака умеет " + makeSounds + ". Любит : " + getFood() +"и проживает на " + getLocation()  ;
    }
}