public class Player {

    private String name;

    private int score = 0;

    public Player(String setName) {

        name = setName;

    }

    public Hand chooseHand() {

        return Hand.getPlay();

    }

    public String getName() {

        return name;

    }

    public void incrementScore() {

        score++;


    }

    public int getScore() {

        return score;

    }

}
