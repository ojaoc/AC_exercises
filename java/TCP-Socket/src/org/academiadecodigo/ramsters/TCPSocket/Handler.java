package org.academiadecodigo.ramsters.TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler implements Runnable {

    private PrintWriter out;

    private BufferedReader in;

    Socket clientSocket;

    public Handler(Socket clientSocket) {

        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {

        try {

            out = new PrintWriter(

                    clientSocket.getOutputStream(),

                    true

            );

            in = new BufferedReader(

                    new InputStreamReader(

                            clientSocket.getInputStream()

                    )

            );

            System.out.println("Connected to " + clientSocket.getInetAddress() + " Thread: " + Thread.currentThread());

            while (true) {

                System.out.println(in.readLine());

                if (in.readLine().split(" ")[0].equals("/quit")) break;

            }

            out.println("Disconnected");

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

