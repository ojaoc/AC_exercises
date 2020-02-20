package org.academiadecodigo.ramsters.farm;

public class Animal {

    private String species;

    private String noise;

    private static int count = 0;

    public Animal(String species, String noise) {

        this.species = species;

        this.noise = noise;

        count++;

    }

    public void getCount() {

        System.out.println(noise + "! -----> " + "animal number: " + count + "\n");

    }

    public boolean checkIfWolf() {

        return species.equals("Wolf");

    }

}
