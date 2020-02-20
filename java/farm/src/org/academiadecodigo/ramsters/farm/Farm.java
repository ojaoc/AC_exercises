package org.academiadecodigo.ramsters.farm;

public class Farm {

    private boolean closed = false;

    public Animal buyAnimal() {

        if (!closed) {

            RandomNumber probability = new RandomNumber();

            switch (probability.get()) {

                case 1:

                    return new Wolf();

                default:

                    return new Sheep();

            }

        } else {

            System.out.println("This farm doesn't sell any more animals.");

            return null;

        }

    }

    public void closeDoors(Animal sample) {

        if (sample instanceof Wolf) {

            ((Wolf) sample).isExchanged();

            closed = true;

            System.out.println("The farm has closed doors.");

        } else {

            System.out.println("You can only exchange a wolf.");

        }

    }

}
