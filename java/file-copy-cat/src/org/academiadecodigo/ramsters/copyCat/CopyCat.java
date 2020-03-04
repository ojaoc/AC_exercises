package org.academiadecodigo.ramsters.copyCat;

import java.io.*;

class CopyCat {

    private FileInputStream inputStream;

    private FileOutputStream outputStream;

    private byte[] buffer;

    CopyCat(String filePath, String destination) {

        buffer = new byte[1024];

        try {

            inputStream = new FileInputStream(filePath);

            outputStream = new FileOutputStream(destination);

            int read = inputStream.read(buffer);

            while (read != -1) {

                outputStream.write(buffer, 0, read);

                read = inputStream.read(buffer);

            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

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
