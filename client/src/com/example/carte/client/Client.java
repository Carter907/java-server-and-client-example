package com.example.carte.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private Socket serverConnection;

    public Client() {
        try {
            serverConnection = new Socket(InetAddress.getLocalHost(), 8080);

            try (var fromServer = new DataInputStream(serverConnection.getInputStream());
                 var toServer = new DataOutputStream(serverConnection.getOutputStream());
            ) {
                do {
                    toServer.writeUTF("hello world");
                    toServer.flush();
                    System.out.printf("""
                    server sent the following: %s
                        
                        """, fromServer.readUTF());

                } while(true);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void connect() {


    }
}
