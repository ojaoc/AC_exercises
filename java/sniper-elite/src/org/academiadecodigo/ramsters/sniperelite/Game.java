package org.academiadecodigo.ramsters.sniperelite;

import org.academiadecodigo.ramsters.sniperelite.elements.GameObject;
import org.academiadecodigo.ramsters.sniperelite.elements.landscape.Tree;
import org.academiadecodigo.ramsters.sniperelite.elements.shooter.SniperRifle;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.*;
import org.academiadecodigo.ramsters.sniperelite.helper.Random;

public class Game {

    private GameObject[] gameObjects;

    private SniperRifle sniperRifle;

    private int shotsFired;


    public Game(int numberOfElements) {

        gameObjects = createObjects(numberOfElements);

        this.sniperRifle = new SniperRifle();

        this.shotsFired = 0;

    }

    public void start() {

        for (int i = 0; i < gameObjects.length; i++) {

            if (gameObjects[i] instanceof Tree) continue;

            Destroyable target = (Destroyable) gameObjects[i];

            while (!target.isDestroyed()) {

                sniperRifle.shoot(target);

                shotsFired++;

            }

            if (i + 1 > gameObjects.length) break;

            if (target instanceof Barrel && !(gameObjects[i + 1] instanceof Tree)) {

                Destroyable hitByExplosion = (Destroyable) gameObjects[i + 1];

                hitByExplosion.hit(100);

            }

        }

    }

    private GameObject[] createObjects(int numberOfElements) {

        GameObject[] elements = new GameObject[numberOfElements];

        for (int i = 0; i < elements.length; i++) {

            if (Random.generateProbability() <= 70) {

                int probability = Random.generateProbability();

                if (probability <= 50) {

                    elements[i] = new SoldierEnemy();

                } else if (probability <= 75){

                    elements[i] = new ArmouredEnemy();

                } else if (probability <= 100) {

                    elements[i] = new Barrel();

                }

            } else {

                elements[i] = new Tree();

            }

        }

        return elements;

    }

}
