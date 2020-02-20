public class Wallet {

    private float amountOfCash = 0;

    public boolean takeCash(float amount) {

        System.out.println("WALLET:");

        if (amountOfCash - amount < 0) {

            System.out.println("Not enough money for that.");

            System.out.println("You only have " + amountOfCash + " in your wallet.");

            System.out.println("\n");

            return false;

        }

        amountOfCash -= amount;

        System.out.println("Took " + amount + " for deposit.");

        System.out.println("You have " + amountOfCash + " in your wallet.");

        System.out.println("\n");

        return true;

    }

    public void saveCash(float amount) {

        System.out.println("WALLET:");

        amountOfCash += amount;

        System.out.println("You have " + amountOfCash + " in your wallet.");

        System.out.println("\n");

    }

}
