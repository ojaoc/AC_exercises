package org.academiadecodigo.ramsters.iterableRange;

import org.academiadecodigo.ramsters.iterableRange.range.Range;

public class Main {

    public static void main(String[] args) {

        Range range = new Range(1, 50);

        for (Integer each : range) {

            System.out.println(each);

        }
    }


}
