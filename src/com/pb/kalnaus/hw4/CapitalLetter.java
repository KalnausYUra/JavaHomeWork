package com.pb.kalnaus.hw4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CapitalLetter {

//Изменение первой буквы в слове на верхний регистр
static String caplet (String a) {
    return  a.substring(0,1).toUpperCase() + a.substring(1);
}

//разбивка текста на слова и вывод текста
static void separation(String t) {
    StringTokenizer st = new StringTokenizer(t, " \t\n\r");
    while (st.hasMoreTokens()) {
        System.out.print(caplet(st.nextToken()) + " ");
    }
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст, программа переведет первую букву слов в верхний регистр");

        String text = in.nextLine();
        separation(text);
    }
}
