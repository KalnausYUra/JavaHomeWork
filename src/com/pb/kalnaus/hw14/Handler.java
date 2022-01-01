package com.pb.kalnaus.hw14;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Handler implements Runnable {
    private Socket socket;
    private ServerChat server;
    // исходящее сообщение
    private PrintWriter outMessage;
    // входящее собщение
    private Scanner inMessage;
    //Scanner in ;
    String clientMessage = "";

    public Handler(Socket socket, ServerChat server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.outMessage = new PrintWriter(socket.getOutputStream());
        this.inMessage = new Scanner(socket.getInputStream());
    }

    @Override
    public void run() {
        clientTread(clientMessage);
    }

    private void clientTread(String clientMessage) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter((socket.getOutputStream()), true);

            System.out.println("Регистрация клиента...");

            String name = in.readLine();
            boolean done = false;
            while (!done) {
                if (!in.ready()) {
                    clientMessage = in.readLine();
                }
                System.out.println("server get message: " + clientMessage);
                if (!(clientMessage == null)) {
                    server.sendMessageToAllClients(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime()) + " " + name + ": " + clientMessage);
                }
                if ("exit".equalsIgnoreCase(clientMessage)) {
                    done = true;
                }
            }
            System.out.println("Закрываем соединение с клиентом" + name);
            out.close();
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // клиент выходит из чата
    public void close() {
        // удаляем клиента из списка
        server.removeClient(this);
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

