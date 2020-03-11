package org.academiadecodigo.ramsters.UdpUppercase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.nio.charset.Charset;

public class UDPSocket {

    String hostName;

    Integer portNumber;

    String message;

    public UDPSocket(String hostName, Integer portNumber, String message) {

        this.hostName = hostName;

        this.portNumber = portNumber;

        this.message = message;

    }

    public void send() {

        byte[] sendBuffer;

        DatagramSocket socket;

        DatagramPacket sendPacket;

        try {

            sendBuffer = message.getBytes(Charset.forName("UTF-8"));

            socket = new DatagramSocket(portNumber);

            sendPacket = new DatagramPacket(

                    sendBuffer,

                    sendBuffer.length,

                    InetAddress.getByName(hostName),

                    portNumber

            );

            socket.send(sendPacket);

            socket.close();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    public void receive() {

        byte[] receiveBuffer;

        DatagramSocket socket;

        DatagramPacket receivePacket;

        try {

            receiveBuffer = new byte[1024];

            socket = new DatagramSocket(portNumber);

            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            socket.receive(receivePacket);

            System.out.println(receivePacket.getAddress() + " has sent a packet from port " + receivePacket.getPort());

            byte[] filteredBuffer = new byte[receivePacket.getLength()];

            for (int i = 0; i < receivePacket.getLength() - 1; i++) {

                filteredBuffer[i] = receiveBuffer[i];

            }

            // Now let's send that back in uppercase

            String upperCaseS = new String(filteredBuffer).toUpperCase() + " HAS COVID-19.";

            byte[] resendBuffer = upperCaseS.getBytes();

            // socket = new DatagramSocket(receivePacket.getPort(), receivePacket.getAddress());

            DatagramPacket resendPacket = new DatagramPacket(

                    resendBuffer,

                    resendBuffer.length,

                    receivePacket.getAddress(),

                    receivePacket.getPort()

            );

            socket.send(resendPacket);

            socket.close();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
