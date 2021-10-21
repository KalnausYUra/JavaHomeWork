package com.pb.kalnaus.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        final int randoms = new Random().nextInt(101);
        int counter = 0;
        String a;

        System.out.println("Программа загадала целое число в диапазоне от 0 до 100 и " +
                "предлагает Вам его отгадать.");
        System.out.println("Вы можете досрочно завершить угадывать числа, введя слово exit");

        while (true) {
            counter++;
            System.out.println("Введите целочисленное число до 100 = ");
            a = in.next();
            if(a.trim().equals("exit")) break;

            if (Integer.valueOf(a) == randoms) {
                System.out.println("Поздравляю. Это было  число = "+ randoms + ".");
                System.out.println("Произведено " + counter + " итераций.");
                break;

            } else if (Integer.valueOf(a) > randoms) {
                System.out.println("Введеное Вами число больше загаданого программой");
            } else
                System.out.println("Введеное Вами число меньше загаданого программой");

        }
    }
}
