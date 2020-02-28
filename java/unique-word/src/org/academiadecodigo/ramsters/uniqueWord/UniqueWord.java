package org.academiadecodigo.ramsters.uniqueWord;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class UniqueWord implements Iterable<String> {

    private TreeSet<String> treeSet;

    public UniqueWord() {

        this.treeSet = new TreeSet<>();

    }

    public void add(String string) {

        String[] split = string.split(" ");

        Collections.addAll(treeSet, split);

    }

    @Override
    public Iterator<String> iterator() {

        return treeSet.iterator();

    }

}

