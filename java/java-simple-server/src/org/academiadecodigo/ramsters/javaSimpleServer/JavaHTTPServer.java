package org.academiadecodigo.ramsters.javaSimpleServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class JavaHTTPServer {

    public static final int PORT = 8080;

    JavaHTTPServer() {

        ServerSocket serverSocket;

        Socket clientSocket;

        try {

            serverSocket = new ServerSocket(PORT);

            while (true) {

                clientSocket = serverSocket.accept();

                Thread thread = new Thread(new Handler(clientSocket));

                thread.start();

            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
