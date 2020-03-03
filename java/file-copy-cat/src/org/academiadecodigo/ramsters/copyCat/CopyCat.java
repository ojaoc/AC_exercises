package org.academiadecodigo.ramsters.copyCat;

import java.io.*;

class CopyCat {

    private FileInputStream inputStream;

    private FileOutputStream outputStream;

    CopyCat(String filePath, String destination) {

        try {

            inputStream = new FileInputStream(filePath);

            outputStream = new FileOutputStream(destination);

            int read = inputStream.read();

            while (read != -1) {

                outputStream.write(read);

                read = inputStream.read();

            }

        } catch (IOException ex) {

            System.out.println(ex.toString());

        } finally {

            if (inputStream != null && outputStream != null) {

                closeStreams(inputStream, outputStream);

            }

        }

    }

    private void closeStreams(FileInputStream input, FileOutputStream output) {

        try {

            input.close();

            output.close();

        } catch (IOException ex) {

            System.out.println(ex.toString());

        }


    }

}
