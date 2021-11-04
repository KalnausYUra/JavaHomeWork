package com.pb.kalnaus.hw6;

public class Veterinarian {

    public Veterinarian() {
    }

    private int  testStroka = 10;

    public void treatAnimal(Animal animal) {
        System.out.println("Это животное кушает: " + animal.getFood() +" и проживает на " + animal.getLocation());
    }
}
