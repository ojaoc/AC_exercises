/*

   TODO: Improve exercise
   It's a good idea to create an Array of
   players, because we can add any amount we want

   The main() method has too much stuff

   Create a class RandomGenerator with a method overload, so you can define either
   only the max value or, if you want, a min and a max. Don't copy and paste the same line
   of code for both methods

   Create a class GuessANumber(). It makes no sense to have the generator and the guess a number methods
   inside the Game class. The game should be responsible for managing the game but it should not have
   those methods

*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // Get input

        // Instantiate Players and Game

        Player one = new Player("Maria");

        Player two = new Player("Johny");

        Game newGame = new Game(one, two);

        // Defining range

        System.out.println("What range of numbers do you want?");

        System.out.println("From: ");

        int min = scan.nextInt();

        System.out.println("To: ");

        int max = scan.nextInt();

        // Start Game

        newGame.start(min, max);

        Player.storeRange(newGame.getRange());

        newGame.validateGuess(new int[]{one.guessNumber(), two.guessNumber()});

    }

}
