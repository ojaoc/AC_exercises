public class Game {

    private Player player1;
    private Player player2;
    private int min;
    private int max;
    private int secretNumber;

    private int numberOfRounds;

    public Game(Player firstPlayer, Player secondPlayer) {

        player1 = firstPlayer;

        player2 = secondPlayer;

    }

    public static int randomGenerator(int min, int max) {

        int range = max - min + 1;

        return (int) (Math.random() * range) + min;

    }

    public void start(int min, int max) {

        this.min = min;

        this.max = max;

        System.out.println("Guess a number between " + min + " and " + max);

        this.secretNumber = randomGenerator(min, max);

    }

    public int[] getRange() {

        return new int[]{min, max};

    }

    public void validateGuess(int[] guesses) {

        boolean guessOne = guesses[0] == secretNumber;

        boolean guessTwo = guesses[1] == secretNumber;

        numberOfRounds++;

        if (guessOne) {

            if (guessTwo) { // both true

                System.out.println("It's a draw. The answer is " + secretNumber);

                Main.main(null); // Start over

            } else { // First true, second false

                System.out.println(player1.getPlayerName() + " is the winner! The correct answer is " + secretNumber);

                displayRounds();

            }

        } else {

            if (guessTwo) { // First false, second true

                System.out.println(player2.getPlayerName() + " is the winner! The correct answer is " + secretNumber);

                displayRounds();

            } else { // Both false

                System.out.println("You are both wrong, try again. Your guesses: " + guesses[0] + " and " + guesses[1]);

                validateGuess(new int[]{player1.guessNumber(), player2.guessNumber()});

            }

        }

    }

    private void displayRounds() {

        System.out.println("It took " + numberOfRounds + " rounds to complete the game.");

    }

}
