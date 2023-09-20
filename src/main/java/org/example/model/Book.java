package org.example.model;

public class Book {

    public static int count = 0;

    private int id;
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.id = count;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
