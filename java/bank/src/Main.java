public class Main {

    public static void main(String[] args) {

        Bank millenium = new Bank(99.65f);

        Wallet carlosWallet = new Wallet();

        User carlos = new User(millenium, carlosWallet);

        carlos.withdrawCash(-12);

        carlos.withdrawCash(50);

        carlos.withdrawCash(300000000);

        carlos.depositCash(-70);

        carlos.depositCash(10);

        carlos.withdrawCash(99.65f);

        carlos.withdrawCash(1);

    }

}
