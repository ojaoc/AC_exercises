package org.academiadecodigo.ramsters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAnalyser {

    private static final int DESIRED_LENGTH = 5;
    private static final int DESIRED_NUMBER_WORDS = 5;
    private static Supplier<Stream<String>> streamSupplier1;
    private static Supplier<Stream<String>> streamSupplier2;

    public static void main(String[] args) {


        final String PATH_NAME_1 = "sampleText.txt";

        final String PATH_NAME_2 = "sampleText2.txt";


        String firstWord;


        streamSupplier1 = () -> {

            try {

                return Files.lines(Paths.get(PATH_NAME_1))
                        .flatMap(line -> Stream.of(line.split("\\W+")));

            } catch (IOException e) {

                e.printStackTrace();

            }

            return null;

        };

        streamSupplier2 = () -> {

            try {

                return Files.lines(Paths.get(PATH_NAME_2))
                        .flatMap(line -> Stream.of(line.split("\\W+")));

            } catch (IOException e) {

                e.printStackTrace();

            }

            return null;

        };

        System.out.println("Word count: " + countWord() + "\n");

        System.out.println("First word with " + DESIRED_LENGTH + " characters: " + firstOptional() + "\n");

        System.out.println("First " + DESIRED_NUMBER_WORDS + " words with " + DESIRED_LENGTH + " characters: ");
        nWordsWithLengthX().forEach(System.out::println);
        System.out.println("\n");

        System.out.println("These two files have the following words in common: ");
        compareTextFiles(streamSupplier2).forEach(System.out::println);

    }

    private static int countWord() {

        return (int) streamSupplier1
                .get()
                .count();

    }

    private static String firstOptional() {

        return streamSupplier1
                .get()
                .filter(word -> word.length() == DESIRED_LENGTH)
                .findFirst()
                .orElse("SUCH WORD NOT FOUND");

    }

    private static List<String> nWordsWithLengthX() {

        return streamSupplier1
                .get()
                .filter(word -> word.length() == DESIRED_LENGTH)
                .parallel()
                .limit(DESIRED_NUMBER_WORDS)
                .collect(Collectors.toList());

    }

    private static Set<String> compareTextFiles(Supplier<Stream<String>> streamSupplierToCompare) {

        List<String> list = streamSupplier1
                .get()
                .collect(Collectors.toList());

        list.retainAll(

                streamSupplierToCompare
                        .get()
                        .collect(Collectors.toList())

        );

        return new HashSet<>(list);

    }

}
