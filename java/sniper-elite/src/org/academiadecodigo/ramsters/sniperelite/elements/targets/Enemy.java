package org.academiadecodigo.ramsters.sniperelite.elements.targets;

import org.academiadecodigo.ramsters.sniperelite.elements.GameObject;

public abstract class Enemy extends GameObject implements Destroyable {

    private boolean isDead;

    private int health;

    public Enemy() {

        isDead = false;

        health = 100;

    }

    @Override
    public boolean isDestroyed() {

        return isDead;

    }

    public void hit(int damage) {

        if (damage < 0) return;

        health -= damage;

        if (health <= 0) {

            health = 0;

            isDead = true;

        }

    }

    public int getHealth() {

        return health;

    }

}
