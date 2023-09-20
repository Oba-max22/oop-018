package org.example.service;

import org.example.enums.Role;
import org.example.model.Book;
import org.example.model.CollectedBooks;
import org.example.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.service.LibraryServiceImpl.inventory;

public class CustomerServiceImpl implements CustomerService {

    private static final String UNAUTHORIZED_ACCESS = "Only Customer allowed!";
    private static final String REGISTRATION_SUCCESS = "Customer registered successfully!";
    private static final String CUSTOMER_ALREADY_EXISTS = "Customer Already Exists!";

    private final List<User> registeredCustomers = new ArrayList<>();

    @Override
    public String register(User user) {

        if (!user.getRole().equals(Role.CUSTOMER)) {
            return UNAUTHORIZED_ACCESS;
        }

        if (registeredCustomers.contains(user)) {
            return CUSTOMER_ALREADY_EXISTS;
        }

        registeredCustomers.add(user);

        return REGISTRATION_SUCCESS;
    }

    @Override
    public String borrowBook(User user, String title, int durationInDays) {

        Book book = null;
        int bookIndex = 0;

        for (int i = 0; i < inventory.size(); i++) {
            Book item = inventory.get(i);

            if (item.getTitle().equalsIgnoreCase(title)) {
                book = item;
                bookIndex = i;
            }
        }

        if (book == null) {
            return "No book matching title!";
        }

        if (book.getQuantity() == 0) {
            return "Out of stock!";
        }

        book.setQuantity(book.getQuantity() - 1);

        // persist inventory changes.
        inventory.remove(bookIndex);
        inventory.add(bookIndex, book);

        CollectedBooks collectedBooks = new CollectedBooks(book.getTitle(), book.getAuthor(), 1);
        LocalDate currentDate = LocalDate.now();
        collectedBooks.setCollectionDate(currentDate.toString());
        collectedBooks.setDueDate(currentDate.plusDays(durationInDays).toString());

        List<CollectedBooks> userCollection = new ArrayList<>();
        userCollection.add(collectedBooks);
        user.setCollection(userCollection);

        return user.toString();
    }
}
