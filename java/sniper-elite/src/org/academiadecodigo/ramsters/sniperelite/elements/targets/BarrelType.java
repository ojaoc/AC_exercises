package org.academiadecodigo.ramsters.sniperelite.elements.targets;

import org.academiadecodigo.ramsters.sniperelite.helper.Random;

import java.lang.management.PlatformLoggingMXBean;

public enum BarrelType {
    PLASTIC(200, 50),
    WOOD(100, 75),
    METAL(400, 100);


    private int maxDamage;

    private int probability;


    BarrelType(int maxDamage, int probability) {

        this.maxDamage = maxDamage;

        this.probability = probability;

    }

    public int getMaxDamage() {

        return maxDamage;

    }

    public static BarrelType getBarrelType() {

        int probability = Random.generateProbability();

        if (probability <= PLASTIC.probability) {

            return PLASTIC;

        } else if (probability <= WOOD.probability) {

            return WOOD;

        } else if (probability <= METAL.probability) {

            return METAL;

        }

        return null;

    }

}
