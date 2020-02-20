package org.academiadecodigo.ramsters.sniperelite.elements.targets;

import org.academiadecodigo.ramsters.sniperelite.helper.Random;

public enum BodyParts {
    HEAD(2, 15),
    TORSO(1, 50),
    LIMB(0.5, 80),
    MISS(0, 100);

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

    public static BodyParts getBodyPart() {

        int probability = Random.generateProbability();

        if (probability <= HEAD.probability) {

            return HEAD;

        } else if (probability <= TORSO.probability) {

            return TORSO;

        } else if (probability <= LIMB.probability) {

            return LIMB;

        } else if (probability <= MISS.probability) {

            return MISS;

        }

        return null;

    }

}
