package org.example.service;

import org.example.model.Book;
import org.example.model.User;

import java.util.List;

public interface LibraryService {

    String displayInventory(User user);
    String addBookToInventory(User user, Book book);

}
