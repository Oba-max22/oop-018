package org.example.util;

import org.example.exceptions.InvalidPathException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.util.WriterUtil.INVENTORY_PATH;

public class ReaderUtil {

    public static String readFromFileToStandardOutput() {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INVENTORY_PATH));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            bufferedReader.close();
        } catch (IOException io) {
            io.printStackTrace();
        }

        return sb.toString();
    }

}
