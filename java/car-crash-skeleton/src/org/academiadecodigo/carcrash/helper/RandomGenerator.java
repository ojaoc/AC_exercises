package org.academiadecodigo.carcrash.helper;

import org.academiadecodigo.carcrash.field.Field;

public class RandomGenerator {

    public static int generateProbability() {

        return (int) (Math.random() * 100) + 1;

    }

    public static int generateCol() {

        return (int) (Math.random() * Field.getWidth());

    }

    public static int generateRow() {

        return (int) (Math.random() * Field.getHeight());

    }

}
