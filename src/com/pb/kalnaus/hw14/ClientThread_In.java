package com.pb.kalnaus.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ClientThread_In implements Runnable {
    private final Socket server;
    private BufferedReader inServer;
    String message;

    public ClientThread_In(Socket server) {
        this.server = server;
    }

    public void setInServer(BufferedReader inServer) {
        this.inServer = inServer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!((message = inServer.readLine()) == null))
                    System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println("Вы вышли с чата");
        }
    }
}
