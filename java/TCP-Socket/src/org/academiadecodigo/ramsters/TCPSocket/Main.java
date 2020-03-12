package org.academiadecodigo.ramsters.TCPSocket;

public class Main {

    public static void main(String[] args) {

        String hostName = args[0];

        Integer portNumber = Integer.parseInt(args[1]);

        // Client client = new Client(hostName, portNumber);

        Server server = new Server(portNumber);

    }

}
