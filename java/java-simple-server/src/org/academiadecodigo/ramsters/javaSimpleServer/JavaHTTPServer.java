package org.academiadecodigo.ramsters.javaSimpleServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class JavaHTTPServer {

    public static final int PORT = 8080;

    JavaHTTPServer() {

        ServerSocket serverSocket;

        Socket clientSocket;

        try {

            serverSocket = new ServerSocket(PORT);

            ExecutorService cachedPool = Executors.newCachedThreadPool();

            for (int i = 0; i < 10000; i++) {

                clientSocket = serverSocket.accept();

                System.out.println("CONNECTION WITH " + clientSocket.getInetAddress() + " NUMBER " + i);

                cachedPool.submit(new Handler(clientSocket));

                //Thread thread = new Thread(new Handler(clientSocket));

                //thread.start();

            }

            cachedPool.shutdownNow();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
