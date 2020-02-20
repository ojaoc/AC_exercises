package org.academiadecodigo.ramsters.sniperelite.elements.targets;

public enum BodyParts {
    HEAD(2, 10),
    TORSO(1, 80),
    LIMB(0.5, 30);

    private double multiplier;

    private int probability;

    BodyParts(double multiplier, int probability) {

        this.multiplier = multiplier;

        this.probability = probability;

    }

    public double getMultiplier() {

        return this.multiplier;

    }

    public int getProbability() {

        return this.probability;

    }

}
