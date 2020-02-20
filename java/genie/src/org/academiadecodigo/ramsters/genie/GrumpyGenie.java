package org.academiadecodigo.ramsters.genie;

public class GrumpyGenie extends Genie {

    public GrumpyGenie() {

        super("Grumpy Genie");

        System.out.println("OMG not again! What do you want??? " +
                "Be quick.");

    }

    @Override
    public void grantWish(String wish) {

        super.grantWish(wish);

        setRefuse(true);

        if (getAvailableWishes() == 0) {

            System.out.println("No more wishes for you.");

            setAvailability(false);

        }

    }

}
