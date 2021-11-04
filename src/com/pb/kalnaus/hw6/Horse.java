package com.pb.kalnaus.hw6;

import java.util.Objects;

public class Horse extends Animal{

    private String kindHorse = "пони";

    public String getKindHorse() {
        return kindHorse;
    }

    public void setKindHorse(String kindHorse) {
        this.kindHorse = kindHorse;
    }

    public Horse(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("Конь топчит копытами в " + getLocation());
    }

    @Override
    public void eat() {
        System.out.println("Лошадка кушает: " + getFood());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;

        Horse horse = (Horse) o;

        return kindHorse.equals(horse.kindHorse) ;
    }


    @Override
    public int hashCode() {
        return Objects.hash(kindHorse, getFood(), getLocation());

    }

    @Override
    public String toString() {
        return "Есть вид лошадок: " + kindHorse + ". Они кушают :" + getFood() +" и проживают на " + getLocation()  ;
    }





}
