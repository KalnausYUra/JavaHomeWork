package com.pb.kalnaus.hw8;


import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args) {
        String loginUser;
        String passUser;
        String temp;
        Scanner scanner = new Scanner(System.in);
        Auth auth = new Auth();

        System.out.println("Зарегистрируйтесь пожалуйста на сайте.\nВведите логин: ");
        loginUser = scanner.nextLine().trim();
        System.out.println("Введите пароль: ");
        passUser = scanner.nextLine().trim();
        System.out.println("Введите пароль еще раз(confirmPassword): ");
        temp = scanner.nextLine().trim();


        try {
            auth.signUp(loginUser, passUser, temp);
            System.out.println("Аккаунт создан. Ввойдите в систему, введя свой логин: ");
            temp = scanner.nextLine().trim();
            System.out.println("Введите Ваш пароль: ");
            auth.signIn(temp, scanner.nextLine().trim());

        } catch (WrongLoginException | WrongPasswordException ex1) {
            ex1.printStackTrace();
        }
    }
}
