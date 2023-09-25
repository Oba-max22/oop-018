package org.example;

import org.example.enums.Role;
import org.example.model.Book;
import org.example.model.User;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.example.service.LibraryService;
import org.example.service.LibraryServiceImpl;
import org.example.util.WriterUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
            Library

            Librarian -> Keeping inventory, add new book, Lending Books

            Customers -> Enquire availability of books, Register(Get Library Card), Borrow books.
         */

        User librarian = new User("John", "Akpata",
                "08012345678", Role.LIBRARIAN);
        User firstCustomer = new User("Temitope", "Agbaje",
                "08012345679", Role.CUSTOMER);

        Book book1 = new Book("Flowers", "Sandra Brown", 1);
        Book book2 = new Book("A thousand splendid suns", "Khaleed Hosseini", 1);
        Book book3 = new Book("Things Fall Apart", "Chinua Achebe", 1);
        Book book4 = new Book("Things Fall Apart", "Chinua Achebe", 1);

        LibraryService libraryService = new LibraryServiceImpl();

        libraryService.addBookToInventory(librarian, book1);
        System.out.println();
        libraryService.addBookToInventory(librarian, book2);
        System.out.println();
        libraryService.addBookToInventory(librarian, book3);
        System.out.println();

        System.out.println(libraryService.displayInventory(firstCustomer));
        System.out.println();
        System.out.println(libraryService.displayInventory(librarian));
        System.out.println();

        CustomerService customerService = new CustomerServiceImpl();

        System.out.println(customerService.register(librarian));
        System.out.println();
        System.out.println(customerService.register(firstCustomer));
        System.out.println();
        System.out.println(customerService.borrowBook(firstCustomer, "Percy Jackson", 2));
        System.out.println();
        System.out.println(customerService.borrowBook(firstCustomer, "Things Fall Apart",4));
        System.out.println();
        System.out.println(customerService.borrowBook(firstCustomer, "Flowers", 5));
        System.out.println();
        System.out.println(customerService.borrowBook(firstCustomer, "Flowers", 5));
        System.out.println();
        System.out.println(libraryService.displayInventory(librarian));

    }

}