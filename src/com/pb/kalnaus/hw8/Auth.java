package com.pb.kalnaus.hw8;

public class Auth {
    private String login;
    private String password;


    public Auth() {
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        boolean result = login.matches("[a-zA-Z0-9]{5,20}");
        if (!result) {
            throw new WrongLoginException("Ошибка, логин указан неверно!!!");
        }


        result = password.matches("[a-zA-Z0-9_]{6,}");
        if (!(result & password.equals(confirmPassword))) {
            throw new WrongPasswordException("Ошибка, пароль указан неверно!!!");
        }

        setLogin(login);
        setPassword(password);
        System.out.println("Вас успешно зарегистрировано в системе!! ");
    }


    void signIn(String loginZ, String passwordZ) throws WrongLoginException {
        if (loginZ.equals(login) & passwordZ.equals(password)) {
            System.out.println("Вы успешно залогинились на сайт. Поздравляю");
        } else
            throw new WrongLoginException("Ошибка авторизации");
    }
}
