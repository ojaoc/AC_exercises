package org.academiadecodigo.ramsters.genie;

public class FriendlyGenie extends Genie {

    public FriendlyGenie() {

        super("Friendly Genie");

        System.out.println("I'm in a good mood, " +
                "so I will grant you three wishes.");

    }

    @Override
    public void grantWish(String wish) {

        super.grantWish(wish);

        if (getAvailableWishes() == 0) {

            System.out.println("No more wishes for you.");

            setAvailability(false);

        }

    }

}
