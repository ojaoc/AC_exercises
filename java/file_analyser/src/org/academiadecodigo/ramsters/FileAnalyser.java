package org.academiadecodigo.ramsters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FileAnalyser {

    public static void main(String[] args) {

        final String PATH_NAME = "sampleText.txt";

        final int DESIRED_LENGTH = 9;

        double wordCount;

        String firstWord;


        Supplier<Stream<String>> streamSupplier = () -> {

            try {

                return Files.lines(Paths.get(PATH_NAME))
                    .flatMap(line -> Stream.of(line.split("\\W+")));

            } catch (IOException e) {

                e.printStackTrace();

            }

            return null;

        };

        wordCount = streamSupplier
                .get()
                .count();

        System.out.println("Word count: " + (int) wordCount);

        Optional<String> firstOptional = streamSupplier
                .get()
                .filter(word -> word.length() == DESIRED_LENGTH)
                .findFirst();

        firstWord = firstOptional.orElse("SUCH WORD NOT FOUND");

        System.out.println("First word with " + DESIRED_LENGTH + " characters: " + firstWord);

    }

}
