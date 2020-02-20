package org.academiadecodigo.ramsters.sniperelite.elements.landscape;

import org.academiadecodigo.ramsters.sniperelite.elements.GameObject;

public class Tree extends GameObject {

    private static int instantiations = 0;

    public Tree() {

        instantiations++;

    }

    @Override
    public String getMessage() {

        return "Tree";

    }

    public static int getInstantiations() {

        return instantiations;

    }

}
