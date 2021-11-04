package com.pb.kalnaus.hw6;

public class Animal {
    private String food;
    private String location;


    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


public void makeNoise() {
    System.out.println("Зверь шумит на " + location + " этой локации");
}

public void eat() {
    System.out.println("Зверь кушает: " + food);

}
    public void sleep() {
        System.out.println( " Животное спит на локации: " + location);
    }


}
