package org.academiadecodigo.ramsters.iterableRange;

import org.academiadecodigo.ramsters.iterableRange.range.Range;

public class Main {

    public static void main(String[] args) {

        Range range = new Range(1, 50, Direction.MIN_TO_MAX);

        Range range2 = new Range(1, 50, Direction.MAX_TO_MIN);

        for (Integer each : range) {

            System.out.println(each);

        }

        System.out.println("\n\n");

        for (Integer each : range2) {

            System.out.println(each);

        }
    }


}
