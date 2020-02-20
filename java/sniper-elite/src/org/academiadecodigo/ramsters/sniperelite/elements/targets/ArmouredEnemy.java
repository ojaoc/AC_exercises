package org.academiadecodigo.ramsters.sniperelite.elements.targets;

public class ArmouredEnemy extends Enemy {

    private static int instantiations = 0;

    private int armour;


    public ArmouredEnemy() {

        super();

        this.armour = 50;

        instantiations++;

    }

    @Override
    public void hit(int damage) {

        if (this.armour > 0) {

            if (this.armour < damage) {

                int remainingDamage = damage - armour;

                armour = 0;

                super.hit(remainingDamage);

            } else {

               armour -= damage;

            }

            System.out.println("\nThis soldier has " + this.armour + " remaining armor.");

        } else {

            super.hit(damage);

        }

    }

    @Override
    public String getMessage() {

        return "Armoured Enemy";

    }

    public static int getInstantiations() {

        return instantiations;

    }

}
