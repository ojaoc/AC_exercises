public class User {

    private Wallet personalWallet;

    private Bank myBank;

    public User(Bank company, Wallet newWallet) {

        personalWallet = newWallet;

        myBank = company;

    }

    public void withdrawCash(float amount) {

        if (amount < 0) {

            System.out.println("Something went wrong.");

            System.out.println("\n");

            return;

        }

        if (myBank.withdraw(amount)) {

            personalWallet.saveCash(amount);

        }

    }

    public void depositCash(float amount) {

        if (amount < 0) {

            System.out.println("Something went wrong.");

            System.out.println("\n");

            return;

        }

        if (personalWallet.takeCash(amount)) {

            myBank.deposit(amount);

        }

    }

}
