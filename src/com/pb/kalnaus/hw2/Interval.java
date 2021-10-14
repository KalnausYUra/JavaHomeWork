package com.pb.kalnaus.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {

        int operand1;
        Scanner in = new Scanner(System.in);

        System.out.println("Программа выясняет в какой промежуток попадает введенное Вами число [0 -14] [15 - 35]" +
                " [36 - 50] [51 - 100]" );
        System.out.println("Введите целочисленное число = ");
        operand1 = in.nextInt();

        if(operand1>=0 && operand1<=14) {
            System.out.println("Ваш промежуток [0 -14]");

        } else if (operand1>=15 && operand1<=35){
            System.out.println("Ваш промежуток [15 - 35]");

        } else if (operand1>=36 && operand1<=50){
            System.out.println("Ваш промежуток [36 - 50]");

        } else if (operand1>=51 && operand1<=100){
            System.out.println("Ваш промежуток [51 - 100]");

        }else {
            System.out.println("Ваше число не попадает не в какой из доступных промежутков");
        }
    }
}
