package org.example.service;

import org.example.model.User;

public interface CustomerService {

    String register(User user);

    String borrowBook(User user, String title, int durationInDays);
}
