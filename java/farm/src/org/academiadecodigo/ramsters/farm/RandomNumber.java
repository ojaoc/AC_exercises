package org.academiadecodigo.ramsters.farm;

public class RandomNumber {

    private int number;

    public RandomNumber() {

        number = (int) (Math.random() * 100) + 1;

    }

    public int get() {

        return number;

    }

}
