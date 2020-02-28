package org.academiadecodigo.ramsters.uniqueWord;

public class Main {

    public static void main(String[] args) {

        UniqueWord uniqueWord = new UniqueWord();

        uniqueWord.add("Twinkle Twinkle Little Star");
        uniqueWord.add("Twinkle Twinkle High Noon");
        uniqueWord.add("Camel Feels Ass Fucked");

        for (String each : uniqueWord)  {

            System.out.println(each);

        }

    }

}
