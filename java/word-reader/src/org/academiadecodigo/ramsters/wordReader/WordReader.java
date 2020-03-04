package org.academiadecodigo.ramsters.wordReader;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class WordReader implements Iterable<String> {

    private FileReader fileReader;

    private BufferedReader bufferedReader;

    private String line;

    private String result;

    LinkedList<String> listOfWords;

    WordReader(String filePath) {

        try {

            fileReader = new FileReader(filePath);

            bufferedReader = new BufferedReader(fileReader);

            line = "";

            result = "";

            while ((line = bufferedReader.readLine()) != null) {

                result += line + "\n";

                line = bufferedReader.readLine();

            }


            bufferedReader.close();

            listOfWords = new LinkedList<>(Arrays.asList(result.split(" ")));

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @Override
    public Iterator<String> iterator() {

        return listOfWords.iterator();

    }

}
