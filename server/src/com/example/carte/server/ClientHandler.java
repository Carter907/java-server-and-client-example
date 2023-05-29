package com.example.carte.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try(var fromClient = new DataInputStream(clientSocket.getInputStream());
            var toClient = new DataOutputStream(clientSocket.getOutputStream())
                ) {
            do {
                var response = fromClient.readUTF();

                System.out.printf("""
                        client sent the follow response: %s
                        
                        """, response);



            } while(true);



        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
