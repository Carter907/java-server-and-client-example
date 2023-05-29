package com.example.carte.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server {

    public final int NUM_OF_CONNECTIONS = 3;

    public void establishConnection() {
        try {
            var server = new ServerSocket(8080);
            var executorService = Executors.newFixedThreadPool(NUM_OF_CONNECTIONS);
            do {
                var clientSocket = server.accept();
                executorService.execute(new ClientHandler(clientSocket));

            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
