package com.pb.kalnaus.hw15;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread_Get_Message implements Runnable {
    private BufferedReader inServer;
    String message;
    ClientChat chat = new ClientChat();


    public void setInServer(BufferedReader inServer) {
        this.inServer = inServer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!((message = inServer.readLine()) == null))
                    chat.PrintMessageOnMainFrame(message);
            }
        } catch (IOException e) {
            chat.PrintMessageOnMainFrame("Вы не в чате...");
        }
    }
}