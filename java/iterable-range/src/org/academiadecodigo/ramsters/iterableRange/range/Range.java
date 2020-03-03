package org.academiadecodigo.ramsters.iterableRange.range;

import org.academiadecodigo.ramsters.iterableRange.Direction;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private int min;

    private int max;

    private Direction direction;


    public Range(int min, int max, Direction direction) {

        this.min = min;

        this.max = max;

        this.direction = direction;

    }

    @Override
    public Iterator<Integer> iterator() {

        switch (direction) {

            case MIN_TO_MAX:

                return new Iterator<>() {

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

                };

            case MAX_TO_MIN:

                return new Iterator<>() {

                    int i = max + 1;

                    @Override
                    public boolean hasNext() {

                        return i - 1 >= min;

                    }

                    @Override
                    public Integer next() {

                        i -= 1;

                        return i;

                    }

                };

        }

        return null;

    }

}