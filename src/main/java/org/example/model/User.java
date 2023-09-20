package org.example.model;

import org.example.enums.Role;

import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Role role;
    private List<CollectedBooks> collection;

    // No args constructor
    public User() {

    }

    // All args constructor
    public User(String firstName, String lastName, String phoneNumber, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<CollectedBooks> getCollection() {
        return collection;
    }

    public void setCollection(List<CollectedBooks> collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}