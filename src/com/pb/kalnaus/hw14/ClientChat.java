package com.pb.kalnaus.hw14;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientChat {
    static String message;


    public static void main(String[] args) {
        BufferedReader inServer;
        PrintWriter outServer;
        BufferedReader inConsole;
        String name;

        String serverIp = "127.0.0.1";
        int serverPort = 10000;
        System.out.println("Соединяемся с сервером " + serverIp + ":" + serverPort);
        try {
            Socket server = new Socket(serverIp, serverPort);
            inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
            outServer = new PrintWriter(server.getOutputStream(), true);
            inConsole = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите ваше имя: ");
            name = inConsole.readLine();
            System.out.println("Ваше имя : " + name);
            message = name;
            System.out.println("Вы в чате, напишите сообщение :");
            ClientThread_Out getMessage = new ClientThread_Out(server);
            ClientThread_In sendMessage = new ClientThread_In(server);
            sendMessage.setInServer(inServer);
            getMessage.setInConsole(inConsole);
            getMessage.setOutServer(outServer);

            new Thread(getMessage).start();
            new Thread(sendMessage).start();
            outServer.println(name);

        } catch (Exception e) {
            System.out.println("Нет возможности соеденится");
        }
    }
}
