package org.academiadecodigo.ramsters.farm;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Farm farm = new Farm();

        Animal[] animalTruck = new Animal[100];

        ArrayList<Integer> wolvesPositions = new ArrayList<>();

        for (int i = 0; i < animalTruck.length; i++) {

            animalTruck[i] = farm.buyAnimal();

            animalTruck[i].getCount();

            if (animalTruck[i].checkIfWolf()) {

                wolvesPositions.add(i);

            }

        }

        farm.closeDoors(animalTruck[wolvesPositions.get(0)]);

    }

}
