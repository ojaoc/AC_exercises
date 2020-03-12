package org.academiadecodigo.ramsters.TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {

    private Socket clientSocket;

    private PrintWriter out;

    private BufferedReader in;


    Client(String hostName, Integer portNumber) {

        Scanner scanner = new Scanner(System.in);

        try {

            clientSocket = new Socket(hostName, portNumber);

            out = new PrintWriter(

                    clientSocket.getOutputStream(),

                    true

            );

            in = new BufferedReader(

                    new InputStreamReader(

                            clientSocket.getInputStream()

                    )

            );

            String message = scanner.nextLine();

            out.println(message);

            System.out.println(in.readLine());

            disconnect();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    private void disconnect() throws IOException {

        in.close();

        out.close();

        clientSocket.close();

    }

}
