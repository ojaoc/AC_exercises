package org.academiadecodigo.ramsters.TCPSocket;

public class Main {

    public static void main(String[] args) {

        Integer portNumber = Integer.parseInt(args[1]);

        new Server(portNumber);

    }

}
