package com.pb.kalnaus.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1,operand2;
        String sign;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое целочисленное число = ");
        operand1 = in.nextInt();

        System.out.println("Введите второе целочисленное число = ");
        operand2 = in.nextInt();

        System.out.println("Введите знак арифметической операции = ");
        sign = in.next();

        switch (sign.trim()) {
                case "+" :
                        System.out.println("Сумма: " +operand1 +" + " +operand2  +" = " + (operand1+=operand2));
                        break;

                case "-" :
                        System.out.println("Сумма: " +operand1 +" - " +operand2  +" = " + (operand1-=operand2));
                        break;

                case "*" :
                        System.out.println("Сумма: " +operand1 +" * " +operand2  +" = " + (operand1*=operand2));
                        break;

                case "/" :
                        if(operand2==0)
                        {
                                System.out.println("Нет возможности выполнить деление на 0!");

                        } else {
                                System.out.println("Сумма: " + operand1 + " / " + operand2 + " = " + (operand1 /= operand2));
                        }
        }
        in.close();
    }
}

