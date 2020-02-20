package org.academiadecodigo.ramsters.genie;

public class MagicLamp {

    private int maxGenies;

    private int geniesLeft;

    public MagicLamp(int numberOfGenies) {

        maxGenies = numberOfGenies;

        geniesLeft = maxGenies;

    }

    public Genie rub(int numberOfRubs) {

        if (geniesLeft < 0){

            System.out.println("GET ANOTHER LAMP");

            return null;
        }

        if (geniesLeft == 0) {

            System.out.println("YOU JUST GENERATED A DEMON");

            RecyclableDemon demon = new RecyclableDemon();

            geniesLeft--;

            return demon;

        }

        if (numberOfRubs % 2 == 0) {

            geniesLeft--;

            return new FriendlyGenie();

        } else {

            geniesLeft--;

            return new GrumpyGenie();

        }

    }

    public void recharge(Genie genie) {

        if (genie instanceof RecyclableDemon) {

            RecyclableDemon demon = (RecyclableDemon) genie;

            if (demon.getActive()) {

                System.out.println("YOU JUST RECHARGED YOUR LAMP!");

                geniesLeft = maxGenies;

                demon.setActive(false);

            } else {

                System.out.println("You need to use an active demon to recycle.");

            }

        } else {

            System.out.println("You can only recharge lamp with Demon.");

        }

    }

}
