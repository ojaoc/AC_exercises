package org.academiadecodigo.ramsters.iterableRange.range;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private int min;

    private int max;


    public Range(int min, int max) {

        this.min = min;

        this.max = max;

    }

    @Override
    public Iterator<Integer> iterator() {

       return new RangeIterator();

    }

    private class RangeIterator implements Iterator<Integer> {

        int i = min - 1;

        @Override
        public boolean hasNext() {

            return i + 1 <= max;

        }

        @Override
        public Integer next() {

            i += 1;

            return i;

        }

    }

}