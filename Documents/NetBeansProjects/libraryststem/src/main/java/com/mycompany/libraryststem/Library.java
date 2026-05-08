/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libraryststem;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mahmoud
 */
class Library {
    private List<Book> books;
    private Map<String, String> users; // username, password
    private Map<String, String> admins; // adminname, password

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
        admins = new HashMap<>();
        // Add some initial books
        books.add(new Book("Book1", "Author1"));
        books.add(new Book("Book2", "Author2"));
        books.add(new Book("Book3", "Author3"));
        // Add some initial users and admins
        users.put("user", "password");
        admins.put("admin", "password");
    }

    public boolean login(String username, String password, boolean isAdmin) {
        Map<String, String> targetMap = isAdmin ? admins : users;
        return targetMap.containsKey(username) && targetMap.get(username).equals(password);
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public void deleteBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No books found matching the keyword.");
        } else {
            System.out.println("Search Results:");
            for (Book book : result) {
                System.out.println(book);
            }
        }
    }
}
