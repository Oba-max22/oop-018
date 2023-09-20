package org.example;

import org.example.enums.Role;
import org.example.model.Book;
import org.example.model.User;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.example.service.LibraryService;
import org.example.service.LibraryServiceImpl;
import java.util.*;

public class Main {
    public static final String HELLO_WORLD = "Hello World!";

    public static void main(String[] args) {
        // Maven Gradle
        // Strings
        /*
        String (reference), char, int, long, byte, short, double, float

        Integer, Long, Byte, Short, Double, Float, Character

        Objects: Example Main main = new Main();
         */

        /*
            Library

            Librarian -> Keeping inventory, add new book, Lending Books

            Customers -> Enquire availability of books, Register(Get Library Card), Borrow books.
         */


/*
        System.out.println(HELLO_WORLD);

        int n = getLengthOfVar();

        char firstCharInStr = HELLO_WORLD.charAt(0);
        char secondCharInStr = HELLO_WORLD.charAt(1);
//        char errorCharInStr = HELLO_WORLD.charAt(12);
        char lastCharInStr = HELLO_WORLD.charAt(n-1);

        System.out.println(firstCharInStr);
        System.out.println(lastCharInStr);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);


        int[] numArr = {0,1,2,3,4,5,6};

        int[] oNumArr = new int[7];
        System.out.println(Arrays.toString(oNumArr));

        for (int i = 0; i < oNumArr.length; i++) {
            int x = (i + 1);
            int squared = (int) Math.pow(x, 2);
            oNumArr[i] = squared;
        }

        System.out.println(Arrays.toString(oNumArr));

//        System.out.println(oNumArr[9]);

        ArrayList<Integer> numList = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            numList.add(i);
        }
        numList.add(7);

        System.out.println(numList);

        System.out.println(numList.get(numList.size() - 1));


//        System.out.println(inventory);

        int counter = 1;
        while(counter <= 100) {
            System.out.println(counter);
            counter++;
        }
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

        libraryService.addBookToInventory(librarian, book3);
        System.out.println();
        libraryService.addBookToInventory(librarian, book1);
        System.out.println();
        libraryService.addBookToInventory(librarian, book2);
        System.out.println();
        libraryService.addBookToInventory(librarian, book4);
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

    public static int getLengthOfVar() {
        return HELLO_WORLD.length();
    }

    /*
     * class Car {
     *   Engine engine;
     *   Tyre tyre;
     *   Body body;
     *
     *
     *   // constructor, getters etc.
     * }
     *
     * class Engine  {
     *   String type;
     *   String mileage;
     *   String fuelType;
     *
     * // constructor, getters etc.
     * }
     *
     * class Tyre {}
     * class Body {}
     *
     * */
}