package org.academiadecodigo.ramsters.sniperelite;

import org.academiadecodigo.ramsters.sniperelite.elements.GameObject;
import org.academiadecodigo.ramsters.sniperelite.elements.landscape.Tree;
import org.academiadecodigo.ramsters.sniperelite.elements.shooter.SniperRifle;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.ArmouredEnemy;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.Enemy;
import org.academiadecodigo.ramsters.sniperelite.elements.targets.SoldierEnemy;
import org.academiadecodigo.ramsters.sniperelite.helper.Random;

public class Game {

    private GameObject[] gameObjects;

    private SniperRifle sniperRifle;

    private int shotsFired;


    public Game(int numberOfElements) {

        this.gameObjects = createObjects(numberOfElements);

        this.sniperRifle = new SniperRifle();

        this.shotsFired = 0;

    }

    public void start() {

        for (GameObject target : gameObjects) {

            if (target instanceof Tree) continue;

            System.out.println("\nAiming for " + target.getMessage());

            while (!((Enemy) target).isDead()) {

                sniperRifle.shoot((Enemy) target);

                System.out.println("\n" + target.getMessage() + "'s health: " + ((Enemy) target).getHealth());

                shotsFired++;

            }

            System.out.println("\nTERMINATED.");

        }

        System.out.println("\nAll dead. " + shotsFired + " shots fired.");

    }

    private GameObject[] createObjects(int numberOfElements) {

        GameObject[] elements = new GameObject[numberOfElements];

        for (int i = 0; i < elements.length; i++) {

            if (Random.generateProbability() <= 70) {

                if (Random.generateProbability() <= 50) {

                    elements[i] = new SoldierEnemy();

                } else {

                    elements[i] = new ArmouredEnemy();

                }

            } else {

                elements[i] = new Tree();

            }

        }

        System.out.println("\nThere are " + SoldierEnemy.getInstantiations() + " regular soldiers, " + ArmouredEnemy.getInstantiations() + " armoured soldiers and " + Tree.getInstantiations() + " trees.");

        return elements;

    }

}
