package com.pb.kalnaus.hw15;

import javax.swing.*;
import java.awt.*;

public class CreateWindowWithConnect {
    ClientChat clientChat = new ClientChat();
    final JFrame popup = new JFrame();
    JTextField txtFieldIpAdressConnect = new JTextField();
    JTextField txtFieldPort = new JTextField();
    JTextField txtFieldNameUser = new JTextField();
    JButton btn = new JButton("Отправить");
    JLabel label1 = new JLabel("Введите IP address:");
    JLabel label2 = new JLabel("Введите port:");
    JLabel label3 = new JLabel("Введите ваше имя в чате:");
    JLabel label4 = new JLabel("");
    JLabel label5 = new JLabel("");


    public void windowConnectWithServer() {
        popup.setLayout(new GridLayout(3, 3, 5, 12));
        txtFieldIpAdressConnect.setText("127.0.0.1");
        txtFieldPort.setText("10000");

        popup.add(label1);
        popup.add(txtFieldIpAdressConnect);
        popup.add(label4);
        popup.add(label2);
        popup.add(txtFieldPort);
        popup.add(label5);
        popup.add(label3);
        popup.add(txtFieldNameUser);
        popup.add(btn);

        popup.setResizable(false);
        popup.setExtendedState(JFrame.NORMAL);
        popup.pack();
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);
        btn.addActionListener(e -> clientChat.connect(txtFieldIpAdressConnect.getText(), txtFieldPort.getText(), txtFieldNameUser.getText(), popup));
    }

}

