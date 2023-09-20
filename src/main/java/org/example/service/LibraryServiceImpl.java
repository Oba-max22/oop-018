package org.example.service;

import org.example.enums.Role;
import org.example.model.Book;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    private static final String BOOK_ALREADY_EXISTS = "Book already exists";
    private static final String UNAUTHORIZED_ACCESS = "Only Librarian allowed!";
    private static final String BOOK_ADDITION_SUCCESS = "Book added successfully!";

    public static final List<Book> inventory = new ArrayList<>();

    @Override
    public String displayInventory(User user) {

        // return error message if user is not librarian
        if (!(user.getRole().equals(Role.LIBRARIAN))) {
            return UNAUTHORIZED_ACCESS;
        }

        return this.inventory.toString();
    }

    @Override
    public String addBookToInventory(User user, Book book) {

        if (!user.getRole().equals(Role.LIBRARIAN)) {
            return UNAUTHORIZED_ACCESS;
        }

        // fix duplicate title && authors in inventory
        if (bookExistsByTitleAndAuthor(book)) {
            return BOOK_ALREADY_EXISTS;
        }

        this.inventory.add(book);

        return BOOK_ADDITION_SUCCESS;
    }

    private boolean bookExistsByTitleAndAuthor(Book book) {
        boolean result = false;

        for(Book item: inventory) {

            boolean condition = item.getTitle().equalsIgnoreCase(book.getTitle())
                    && item.getAuthor().equalsIgnoreCase(book.getAuthor());

            result = (result || condition); // result |= condition;
        }

        return result;
    }
}
