package com.pb.kalnaus.hw6;

import java.lang.reflect.Field;
import java.util.Arrays;



public class VetСlinic {



    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Animal cat = new Cat("мяско", "всеx континентах.");
        Animal dog = new Dog("косточки", "на всех континентах, живет вместе с людьми.");
        Animal horse = new Horse("траву", "лугах и степях.");

        Animal[] animals = new Animal[] {cat,dog,horse};
        Veterinarian vet = new Veterinarian();

for (int i = 0;i<animals.length;i++) {
   vet.treatAnimal(animals[i]);
   animals[i].eat();
   animals[i].sleep();
    System.out.println("Location: " + animals[i].getLocation());
   animals[i].makeNoise();
    System.out.println(animals[i].toString());
    System.out.println("----------------------------hashCode--> " + animals[i].hashCode());
if(i == animals.length-1) break;
else {
    System.out.println("equals : " + animals[i].equals(animals[i+1]));
            }
        }

// Рефлексия. Объект класса Veterinarian создайте с помощью рефлексии.
        Class c = vet.getClass();
        System.out.println("NameClass = " + c.getName());
        System.out.println("Methods = " + Arrays.toString(c.getMethods()));
        System.out.println("Fields =  " + Arrays.toString(c.getDeclaredFields()));
        Field field = c.getDeclaredField("testStroka");
        field.setAccessible(true);
        System.out.println(field.get(vet));
        field.set(vet, 15);
        System.out.println(field.get(vet)); // получилось, изменили.
    }
}
