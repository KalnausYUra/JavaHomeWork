package com.pb.kalnaus.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    //Сравнивание двух массивов слов между собой
static boolean comparison (String[] a, String[] b) {
    if (a.length != b.length) return false; // если длина масивов разная, априори нет анаграмы
    int temp = 0;
    char[] text1;
    char[] text2;

    for (int i = 0; i < a.length; i++) {     //первый текст
        for (int j = 0; j < b.length; j++) {    // второй текст

            if (a[i].length() == b[j].length()) {
                text1 = a[i].toCharArray();
                text2 = b[j].toCharArray();

                Arrays.sort(text1);
                Arrays.sort(text2);

                if(Arrays.equals(text1, text2)) {
                    temp++;
                    break;
                }
                else
                    continue;
            } else continue;
        }
    }
    if (temp == a.length) return true;
    else
    return false;
}

    //Разбивка текста на массив слов + убирание всех знаков препинания
static String[] separate (String s) {
s = s.replaceAll("\\p{P}", "").toLowerCase();
    String[] words = s.split("\\s+");
    return words ;
}

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первый текст анаграммы :");
        String textA = in.nextLine();
           System.out.println("Введите второй текст анаграммы :");
         String textB = in.nextLine();

       boolean exit =  comparison(separate(textA),separate(textB));
       if(exit == true) {
            System.out.println("Первая строка является анаграммой другой строки. Поздравляю");
        }
        else {
            System.out.println("Первая строка не является анаграммой другой строки. Извените. Вы ввели разный текст");
        }

    }
}
