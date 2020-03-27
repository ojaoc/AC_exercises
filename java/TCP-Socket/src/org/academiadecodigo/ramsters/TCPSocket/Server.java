package org.academiadecodigo.ramsters.TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server {

    Server(Integer portNumber) {

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);

            ExecutorService cachedPool = Executors.newCachedThreadPool();

            while (true) {

                Socket clientSocket = serverSocket.accept();

                cachedPool.submit(new Handler(clientSocket));

                cachedPool.shutdown();

            }

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

}
