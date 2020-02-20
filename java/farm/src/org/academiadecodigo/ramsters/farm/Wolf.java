package org.academiadecodigo.ramsters.farm;

public class Wolf extends Animal {

    private boolean isExchanged;

    public Wolf() {

        super("Wolf", "WOOOOOOOOOO");

        isExchanged = false;

    }

    public void isExchanged() {

        if (!isExchanged) {

            isExchanged = true;

        } else {

            System.out.println("This wolf has already been exchanged.");

        }

    }

}
