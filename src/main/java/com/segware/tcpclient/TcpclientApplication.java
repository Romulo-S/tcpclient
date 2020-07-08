package com.segware.tcpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

@SpringBootApplication
public class TcpclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcpclientApplication.class, args);

        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            Socket cliente = new Socket(ip.getHostAddress(),12345);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date data_atual = (Date)entrada.readObject();
            JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            System.out.println("Conexão encerrada");
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
