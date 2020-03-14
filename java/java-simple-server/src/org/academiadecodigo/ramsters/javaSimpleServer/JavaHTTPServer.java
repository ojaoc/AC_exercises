package org.academiadecodigo.ramsters.javaSimpleServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class JavaHTTPServer {

    private ServerSocket serverSocket;

    private Socket clientSocket;

    private PrintWriter out;

    private BufferedOutputStream bufferedOutputStream;

    private BufferedReader in;

    private FileInputStream fileInputStream;


    JavaHTTPServer(int portNumber) {

        try {

            serverSocket = new ServerSocket(portNumber);

            clientSocket = serverSocket.accept();

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

                            index,0, index.length

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

        serverSocket.close();

        clientSocket.close();

        out.close();

        in.close();

        fileInputStream.close();

        bufferedOutputStream.close();

    }

}
