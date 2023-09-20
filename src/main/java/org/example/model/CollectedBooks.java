package org.example.model;

public class CollectedBooks extends Book {

    private String collectionDate;
    private String dueDate;


    public CollectedBooks(String title, String author, int quantity) {
        super(title, author, quantity);
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "CollectedBooks{" +
                "collectionDate='" + collectionDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}
