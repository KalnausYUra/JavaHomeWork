package com.pb.kalnaus.hw15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerChat {

    public static void main(String[] args) {
        new ServerChat();
    }

    private ArrayList<Handler> clients = new ArrayList<Handler>();

    public ServerChat() {
        System.out.println("Старт сервера");
        int port = 10000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            ExecutorService threadPool = Executors.newFixedThreadPool(10);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Handler handler = new Handler(clientSocket, this);
                clients.add(handler);
                threadPool.submit(handler);
            }
        } catch (IOException e) {
            System.out.println("Не могу установить соединение " + port);
            System.exit(-1);
        }
    }

    // отправляем сообщение всем клиентам
    public void sendMessageToAllClients(String msg) {
        for (Handler o : clients) {
            o.sendMsg(msg);
        }
    }

    // удаляем клиента из коллекции при выходе из чата
    public void removeClient(Handler client) {
        clients.remove(client);
    }
}
