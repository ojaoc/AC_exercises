package org.academiadecodigo.ramsters.sniperelite.elements.targets;

public class SoldierEnemy extends Enemy {

    private static int instantiations = 0;

    public SoldierEnemy() {

        instantiations++;

    }

    @Override
    public void hit(int damage) {

        super.hit(damage);

    }

    @Override
    public String getMessage() {

        return "Soldier Enemy";

    }

    public static int getInstantiations() {

        return instantiations;

    }

}
