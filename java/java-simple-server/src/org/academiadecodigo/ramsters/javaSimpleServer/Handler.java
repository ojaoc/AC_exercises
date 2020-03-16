package org.academiadecodigo.ramsters.javaSimpleServer;

import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {

    private PrintWriter out;

    private BufferedOutputStream bufferedOutputStream;

    private BufferedReader in;

    private FileInputStream fileInputStream;

    private Socket clientSocket;

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

            bufferedOutputStream = new BufferedOutputStream(

                    clientSocket.getOutputStream()

            );

            in = new BufferedReader(

                    new InputStreamReader(

                            clientSocket.getInputStream()

                    )

            );

            switch (in.readLine()) {

                case "GET / HTTP/1.1":

                    out.println("HTTP/1.1 200\n");

                    byte[] index = readFile("index.html");

                    bufferedOutputStream.write(

                            index, 0, index.length

                    );

                    bufferedOutputStream.flush();

                    break;

                case "GET /swag HTTP/1.1":

                    out.println("HTTP/1.1 200\n");

                    byte[] swag = readFile("swag.html");

                    bufferedOutputStream.write(

                            swag, 0, swag.length

                    );

                    bufferedOutputStream.flush();

                    break;

                case "GET /virus HTTP/1.1":

                    while (true) {

                        out.println("HTTP/1.1 200\n");

                    }

                default:

                    out.println("HTTP/1.1 404 Resource Unavailable\n");

                    byte[] four0four = readFile("404.html");

                    bufferedOutputStream.write(

                            four0four, 0, four0four.length

                    );

                    bufferedOutputStream.flush();

                    break;

            }

            disconnect();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    private byte[] readFile(String filePath) {

        try {

            fileInputStream = new FileInputStream(filePath);

            return fileInputStream.readAllBytes();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

        return new byte[0];

    }

    private void disconnect() throws IOException {

        clientSocket.close();

        out.close();

        in.close();

        fileInputStream.close();

        bufferedOutputStream.close();

    }

}
