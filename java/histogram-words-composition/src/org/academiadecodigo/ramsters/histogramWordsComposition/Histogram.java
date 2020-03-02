package org.academiadecodigo.ramsters.histogramWordsComposition;

import java.util.HashMap;
import java.util.Iterator;

public class Histogram implements Iterable<String> {

    HashMap<String, Integer> hashMap;

    public Histogram() {

        hashMap = new HashMap<>();

    }

    public void addString(String sentence) {

        String[] splitSentence = sentence.split(" ");

        Integer count = 1;

        for (String each : splitSentence) {

            if (hashMap.containsKey(each)) {

                count += hashMap.get(each);

            }

            hashMap.put(each, count);

            count = 1;

        }
    }

    public Integer getValue(String key) {

        return hashMap.get(key);

    }

    @Override
    public Iterator<String> iterator() {

        return hashMap.keySet().iterator();

    }

}
