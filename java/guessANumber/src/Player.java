import java.util.ArrayList;

public class Player {

    private static int numberOfPlayers = 0;
    private static ArrayList<Integer> attempts = new ArrayList<>();
    private static int minGuess;
    private static int maxGuess;
    private int playerNumber;
    private String name;

    public Player(String newName) {

        playerNumber = numberOfPlayers + 1;

        numberOfPlayers++;

        name = newName;

        System.out.println(getPlayerName() + " is player number " + playerNumber);

    }

    public static void storeRange(int[] range) {

        minGuess = range[0];

        maxGuess = range[1];

    }

    public String getPlayerName() {

        return name;

    }

    public int guessNumber() {

        int guess = Game.randomGenerator(minGuess, maxGuess);

        if (Player.attempts.contains(guess)) {

            return guessNumber();

        } else {

            Player.attempts.add(guess);

        }

        return guess;

    }

}
