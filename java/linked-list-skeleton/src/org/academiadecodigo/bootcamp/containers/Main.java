package org.academiadecodigo.bootcamp.containers;

import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        for (String each : list) {

            System.out.println(each);

        }

    }

}
