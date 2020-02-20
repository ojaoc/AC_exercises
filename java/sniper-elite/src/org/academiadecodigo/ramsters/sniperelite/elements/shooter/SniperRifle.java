package org.academiadecodigo.ramsters.sniperelite.elements.shooter;

import org.academiadecodigo.ramsters.sniperelite.elements.targets.BodyParts;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.Destroyable;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.Enemy;
import org.academiadecodigo.ramsters.sniperelite.helper.Random;

public class SniperRifle {

    private int baseDamage;

    public SniperRifle() {

        this.baseDamage = 50;

    }

    public void shoot(Destroyable target) {

        int probability = Random.generateProbability();

        int damageOutput;

        if (target instanceof Enemy) {

            damageOutput = (int) (this.baseDamage * BodyParts.getBodyPart().getMultiplier());

        } else {

            damageOutput = baseDamage;

        }

        target.hit(damageOutput);

    }

}
