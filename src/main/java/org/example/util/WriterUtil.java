package org.example.util;

import org.example.exceptions.InvalidPathException;
import org.example.model.Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.example.service.LibraryServiceImpl.inventory;

public class WriterUtil {

    public static final String INVENTORY_PATH = "src/main/resources/inventory.csv";
    public static final String SEPARATOR = ", ";

    public static void writeInventoryToFile() {

        // try with resources
        /*
        *
        * try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(INVENTORY_PATH))) {
        *
        * }
        *
        * */

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(INVENTORY_PATH));

            StringBuilder sb = new StringBuilder();

            String header = "ID, TITLE, AUTHOR, QUANTITY";

            sb.append(header);
            sb.append("\n");

            for(Book book: inventory) {
                String line = book.getId() + SEPARATOR +
                        book.getTitle() + SEPARATOR +
                        book.getAuthor() + SEPARATOR +
                        book.getQuantity();
                sb.append(line);
                sb.append("\n");
            }

            bufferedWriter.write(sb.toString());

            bufferedWriter.close();

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
