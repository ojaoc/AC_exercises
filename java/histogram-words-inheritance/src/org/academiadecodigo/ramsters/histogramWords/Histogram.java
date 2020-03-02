package org.academiadecodigo.ramsters.histogramWords;

import java.util.HashMap;
import java.util.Iterator;

public class Histogram extends HashMap<String, Integer> implements Iterable<String> {

    public Histogram() {

        super();

    }

    public void addString(String sentence) {

        String[] splitSentence = sentence.split(" ");

        Integer count = 1;

        for (String each : splitSentence) {

            if (containsKey(each)) {

                count += get(each);

            }

            put(each, count);

            count = 1;

        }

    }

    @Override
    public Iterator<String> iterator() {

        return keySet().iterator();

    }



}
