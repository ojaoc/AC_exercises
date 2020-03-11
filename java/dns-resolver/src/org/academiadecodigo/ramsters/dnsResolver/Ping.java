package org.academiadecodigo.ramsters.dnsResolver;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

class Ping {

    private static final int timeout = 1500;

    public static void reach() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert a URL: ");

        String inputHost = scanner.nextLine();


        try {

            InetAddress address = InetAddress.getByName(inputHost);

            if (address.isReachable(timeout)) {

                System.out.println("Server is reachable.");

            } else {

                System.out.println("Cannot reach server.");

            }

            System.out.println("Server address: " + address.getHostAddress());

            reach();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }


    }

}
