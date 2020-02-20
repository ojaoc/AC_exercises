public class Main {

    public static void main(String[] args) {

        // Instantiate players and game

        Player johny = new Player("Sr.João");

        Player arturo = new Player("Arturito");

        Game engine = new Game(johny, arturo);

        // Kick-off game

        engine.start();

    }

}
