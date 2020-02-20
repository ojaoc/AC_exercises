package org.academiadecodigo.ramsters.sniperelite.elements.targets;

import org.academiadecodigo.ramsters.sniperelite.Game;
import org.academiadecodigo.ramsters.sniperelite.elements.GameObject;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType type;

    private int currentDamage;

    private boolean destroyed;


    public Barrel() {

        this.type = BarrelType.getBarrelType();

        this.currentDamage = type.getMaxDamage();

        destroyed = false;

    }

    @Override
    public boolean isDestroyed() {

        return destroyed;

    }

    @Override
    public void hit(int damage) {

        if (damage <= 0) return;

        currentDamage -= damage;

        if (currentDamage <= 0) {

            currentDamage = 0;

            destroyed = true;

        }

    }

    @Override
    public String getMessage() {

        return "Barrel";

    }

}
