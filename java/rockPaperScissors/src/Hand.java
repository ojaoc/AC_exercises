public enum Hand {

    ROCK,
    PAPER,
    SCISSORS;

    public static Hand getPlay() {

        return Hand.values()[RandomNumber.generate(Hand.values().length)];

    }

}
