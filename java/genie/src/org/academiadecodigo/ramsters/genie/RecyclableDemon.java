package org.academiadecodigo.ramsters.genie;

public class RecyclableDemon extends Genie {

    private boolean active = true;

    public RecyclableDemon() {

        super("Recyclable Demon");

        System.out.println("I can grant you all the wishes you like, " +
                "but if you want your lamp back I need to disappear.");

    }

    @Override
    public void grantWish(String wish) {

        if (active) {

            super.grantWish(wish);

        } else {

            System.out.println("This demon is not active.");

        }

    }

    public boolean getActive() {

        return active;

    }

    public void setActive(boolean isActive) {

        active = isActive;

    }

}
