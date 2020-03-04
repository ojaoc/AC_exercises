package org.academiadecodigo.ramsters.wordReader;

public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        WordReader wordReader = new WordReader("baconIpsum.txt");

        for (String each : wordReader) {

            System.out.println(each);

        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

    }

}
