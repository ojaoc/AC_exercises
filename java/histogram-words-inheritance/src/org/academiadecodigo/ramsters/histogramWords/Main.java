package org.academiadecodigo.ramsters.histogramWords;

public class Main {

    public static void main(String[] args) {

        Histogram histogram = new Histogram();

        histogram.addString("Hello Hello Hello World");

        histogram.addString("Can You Hear Me");

        histogram.addString("Hello Campers In Top Lane Fuck Me");

        for (String each : histogram) {

            System.out.println(each + " " + histogram.get(each));

        }

    }

}
