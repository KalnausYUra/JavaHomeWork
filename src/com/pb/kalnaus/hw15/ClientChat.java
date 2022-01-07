package com.pb.kalnaus.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientChat {
    static int stateConnect;
    static JTextArea textArea;
    static JTextField textField;
    static PrintWriter outServer;


    public static void main(String[] args) {
        CreateWindowWithConnect createWindowWithConnect = new CreateWindowWithConnect();
        JFrame frame = new JFrame("Чат");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Файл");
        JMenu m2 = new JMenu("Помощь");
        mb.add(m1);
        mb.add(m2);
        JMenuItem JItemConnect = new JMenuItem("Соединить");
        JMenuItem JItemExit = new JMenuItem("Выход");
        JMenuItem JItemHelp = new JMenuItem("О программе");
        m1.add(JItemConnect);
        m1.add(JItemExit);
        m2.add(JItemHelp);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Введите текст:");
        textField = new JTextField(14);
        JButton button = new JButton("Send");
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        textArea = new JTextArea();
        textArea.setEditable(false);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
        button.addActionListener(new MainFrameButtonClick());

        JItemExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Программа завершила работу", "Выход",
                        JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });


        JItemHelp.addActionListener(e -> JOptionPane.showMessageDialog(null, "Программа чат\n" +
                        "Для соеденения с сервером: Файл -> Соединить. \nДля выхода с программы: " +
                        " Файл -> Выход", "Помощь",
                JOptionPane.WARNING_MESSAGE));

        JItemConnect.addActionListener(e -> createWindowWithConnect.windowConnectWithServer());
    }


    void PrintMessageOnMainFrame(String messageReceived) {
        textArea.append(messageReceived + "\n");
    }


    void connect(String serverIp, String serverPort, String name, JFrame popup) {
        BufferedReader inServer;
        Socket server;
        popup.setVisible(false);
        if (name.length() == 0) {
            textArea.append("Вы не ввели имя пользователя, соеденитесь с сервером еще раз" + "\n");
            return;
        }

        try {
            server = new Socket(serverIp, Integer.valueOf(serverPort));
            inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
            outServer = new PrintWriter(server.getOutputStream(), true);
            ClientThread_Get_Message getMessage = new ClientThread_Get_Message();
            getMessage.setInServer(inServer);
            new Thread(getMessage).start();

            textArea.append("Соединяемся с сервером " + serverIp + ":" + serverPort + "\n");
            textArea.append("Ваше имя : " + name + "\n" + "Вы в чате, пишите сообщение :" + "\n");
            outServer.println(name);
            stateConnect = 1;

        } catch (IOException | NumberFormatException e) {
            textArea.append("Нет возможности соеденится" + "\n" + "Возможно сервер отключен." + "\n");
            stateConnect = 0;
        }
    }

    ;


    private static class MainFrameButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (stateConnect == 1 && !(textField.getText().length() == 0)) {
                outServer.println(textField.getText());
                textField.setText("");
            }
        }
    }


}
