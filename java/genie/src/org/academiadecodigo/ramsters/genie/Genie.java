package org.academiadecodigo.ramsters.genie;

public class Genie {

    private int availableWishes;

    private String genieType;

    private boolean refuse;

    private boolean available;

    public Genie(String type) {

        availableWishes = 3;

        refuse = false;

        available = true;

        setGenieType(type);

        System.out.println("I'm a " + getGenieType());

    }

    public void grantWish(String wish) {

        if (available) {

            if (refuse) {

                System.out.println("Hmmmm... I don't feel like doing that.");

            } else {

                System.out.println("Your wish " + wish + " has been granted!");

            }

            availableWishes--; // IF SOMETHING BREAKS IS BECAUSE OF THIS

            System.out.println("You have " + getAvailableWishes() + " wishes.");

        }

    }

    public int getAvailableWishes() {

        if (availableWishes < 0) return 0;

        return availableWishes;

    }

    public String getGenieType() {

        return genieType;

    }

    public void setGenieType(String type) {

        genieType = type;

    }

    public void setAvailability(boolean isAvailable) {

        available = isAvailable;

    }

    public void setRefuse(boolean isRefusing) {

        refuse = isRefusing;

    }

}
