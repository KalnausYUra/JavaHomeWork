package com.pb.kalnaus.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Инициализация переменных
        int[] array = new int[10];
        int summ =0, summArray =0, numberOfPositives =0, bubble = 0, buffer;


        System.out.println("Введите 10 чисел для наполнения массива");
// Наполнение массива
        for(int i =0; i< array.length;i++) {
            array[i] = scanner.nextInt();
    }
        System.out.print("Элементы массива: ");

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        summ+=array[i];
        }
        System.out.println();
        System.out.println("Сумма всех элементов = " + summ);

        //сщитаем все положительные элементы и количество положительных элементов. Выводим на экран
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                summArray += array[i];
                numberOfPositives++;
            }
        }
        System.out.println("Сумма всех положительных элементов массива = " + summArray);
        System.out.println("Количество всех положительных элементов массива = "+ numberOfPositives);

//Сортируем массив по методу пузыря
        while (bubble == 0) {
            bubble = -1;
        for (int i = 0; i < array.length-1;i++) {
            if (array[i] > array[i + 1]) {
                bubble = 0;
                buffer = array[i + 1];
                array[i+1] = array[i];
                array[i] = buffer;
            }
        }
        }

        //Вывод  на экран отсортированого массива
        System.out.print("Отсортированый массив от меньшего к большему : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            summ+=array[i];
        }
    }
}
