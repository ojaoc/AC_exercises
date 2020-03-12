package org.academiadecodigo.ramsters.TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

    private ServerSocket serverSocket;

    private Socket clientSocket;

    private PrintWriter out;

    private BufferedReader in;


    Server(Integer portNumber) {

        try {

            serverSocket = new ServerSocket(portNumber);

            clientSocket = serverSocket.accept();

            out = new PrintWriter(

                    clientSocket.getOutputStream(),

                    true

            );

            in = new BufferedReader(

                    new InputStreamReader(

                            clientSocket.getInputStream()

                    )

            );

            System.out.println("Connected to " + clientSocket.getInetAddress());

            System.out.println(in.readLine());

            out.println("I have received your message.");

            disconnect();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    private void disconnect() throws IOException {

        in.close();

        out.close();

        serverSocket.close();

        clientSocket.close();

    }

}
