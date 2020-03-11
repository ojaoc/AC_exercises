package org.academiadecodigo.ramsters.UdpUppercase;

public class Main {

    public static void main(String[] args) {

        String hostName = args[0];

        int portNumber = Integer.parseInt(args[1]);

        String message = args[2];

        UDPSocket udpSocket = new UDPSocket(hostName, portNumber, message);

        while (true) {

            udpSocket.receive();

        }


    }

}
