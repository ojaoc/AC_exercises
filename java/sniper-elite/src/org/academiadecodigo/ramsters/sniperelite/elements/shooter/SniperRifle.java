package org.academiadecodigo.ramsters.sniperelite.elements.shooter;

import org.academiadecodigo.ramsters.sniperelite.elements.targets.BodyParts;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.Enemy;
import org.academiadecodigo.ramsters.sniperelite.helper.Random;

public class SniperRifle {

    private int baseDamage;

    public SniperRifle() {

        this.baseDamage = 50;

    }

    public void shoot(Enemy target) {

        int probability = Random.generateProbability();

        int damageOutput;

        System.out.println("\nPEW!");

        if (probability <= BodyParts.HEAD.getProbability()) {

            damageOutput = (int) (this.baseDamage * BodyParts.HEAD.getMultiplier());

            System.out.println("\nHEADSHOT!");

        } else if (probability <= BodyParts.LIMB.getProbability()) { // Miss the shot

            damageOutput = (int) (this.baseDamage * BodyParts.LIMB.getMultiplier());

            System.out.println("\nHIT ONE OF THE LIMBS!");

        } else if (probability <= BodyParts.TORSO.getProbability()) {

            damageOutput = (int) (this.baseDamage * BodyParts.TORSO.getMultiplier());

            System.out.println("\nHIT THE TORSO.");

        } else {

            damageOutput = 0; // Miss the shot.

            System.out.println("\nMISSED.");

        }

        target.hit(damageOutput);

    }

}
