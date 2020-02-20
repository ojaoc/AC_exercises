public class Game {

    private Player player1;
    private Player player2;

    private int numberOfRounds = 3;


    public Game(Player firstPlayer, Player secondPlayer) {

        player1 = firstPlayer;

        player2 = secondPlayer;

    }

    public void start() {

        switch (player1.chooseHand()) {

            case ROCK:

                if (player2.chooseHand() == Hand.SCISSORS) { // TODO: CHANGE THIS!!!!!!!!!!!!!!!!

                    System.out.println(player1.getName() + " wins round.");

                    player1.incrementScore();

                    numberOfRounds--;

                } else if (player2.chooseHand() == Hand.PAPER) {

                    System.out.println(player2.getName() + " wins round.");

                    player2.incrementScore();

                    numberOfRounds--;

                } else {

                    System.out.println("Draw.");

                }

                break;

            case PAPER:

                if (player2.chooseHand() == Hand.ROCK) {

                    System.out.println(player1.getName() + " wins round.");

                    player1.incrementScore();

                    numberOfRounds--;

                } else if (player2.chooseHand() == Hand.SCISSORS) {

                    System.out.println(player2.getName() + " wins round.");

                    player2.incrementScore();

                    numberOfRounds--;

                } else {

                    System.out.println("Draw.");

                }

                break;

            case SCISSORS:

                if (player2.chooseHand() == Hand.PAPER) {

                    System.out.println(player1.getName() + " wins round.");

                    player1.incrementScore();

                    numberOfRounds--;

                } else if (player2.chooseHand() == Hand.ROCK) {

                    System.out.println(player2.getName() + " wins round.");

                    player2.incrementScore();

                    numberOfRounds--;

                } else {

                    System.out.println("Draw.");

                }

                break;

        }

        checkRound();

    }

    private void checkRound() {

        if (numberOfRounds == 0) {

            System.out.println("Game over.");

            if (player1.getScore() > player2.getScore()) {

                System.out.println("------------------------------------");

                System.out.println(player1.getName() + " wins the game!!");

                System.out.println("------------------------------------");

            } else {

                System.out.println("------------------------------------");

                System.out.println(player2.getName() + " wins the game!!");

                System.out.println("------------------------------------");

            }


        } else {

            start();

        }

    }

}
