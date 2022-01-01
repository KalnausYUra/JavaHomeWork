package com.pb.kalnaus.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread_Out implements Runnable {
    String dataFromUser;
    private final Socket server;
    private PrintWriter outServer;
    private BufferedReader inConsole;

    public void setOutServer(PrintWriter outServer) {
        this.outServer = outServer;
    }

    public void setInConsole(BufferedReader inConsole) {
        this.inConsole = inConsole;
    }

    public ClientThread_Out(Socket server) throws IOException {
        this.server = server;
    }


    @Override
    public void run() {
        dataFromUser = ClientChat.message;
        try {

            while (true) {
                dataFromUser = inConsole.readLine();

                if (!((dataFromUser) == null))
                    outServer.println(dataFromUser);
                if ("exit".equalsIgnoreCase(dataFromUser)) {
                    break;
                }
            }
            outServer.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
