public class Bank {

    private float userBalance;

    public Bank(float newBalance) {

        userBalance = newBalance;

        System.out.println("Opened account with " + newBalance);

        System.out.println("\n");

    }

    public boolean withdraw(float amount) {

        System.out.println("BANK:");

        if (userBalance - amount < 0) {

            System.out.println("Not enough money for withdraw.");

            System.out.println("You only have " + userBalance + " in your bank account.");

            System.out.println("\n");

            return false;

        }

        userBalance -= amount;

        System.out.println("Withdrawn " + amount);

        System.out.println("Bank balance: " + userBalance);

        System.out.println("\n");

        return true;

    }

    public void deposit(float amount) {

        System.out.println("BANK:");

        userBalance += amount;

        System.out.println("Deposited " + amount);

        System.out.println("Bank balance: " + userBalance);

        System.out.println("\n");

    }

}
