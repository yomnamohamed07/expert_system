/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject16;

/**
 *
 * @author mahmoud
 */ import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mavenproject16 {


        
        // Add action listeners to buttons




class Book {
    private String title;
    private String author;
    private String category;
    private int counter;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.counter = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
    
    public int getCounter() {
        return counter;
    }
    
    public void increaseCounter() {
        counter++;
    }
    
    public void decreaseCounter() {
        counter--;
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class LibrarySystem implements Library {
    private List<Book> books;
    private List<User> users;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(String title, String author, String category) {
        Book book = new Book(title, author, category);
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void deleteBook(Book book) {
        books.remove(book);
        System.out.println("Book deleted: " + book.getTitle());
    }

    public void addUser(String username, String password) {
        User user = new User(username, password);
        users.add(user);
        System.out.println("User added: " + user.getUsername());
    }

    public void deleteUser(User user) {
        users.remove(user);
        System.out.println("User deleted: " + user.getUsername());
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getCategory().contains(keyword)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public List<User> searchUsers(String keyword) {
        List<User> searchResults = new ArrayList<>();
        for (User user : users) {
            if (user.getUsername().contains(keyword)) {
                searchResults.add(user);
            }
        }
        return searchResults;
    }

    public int getBookCount() {
        return books.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Library librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Adding books
        librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction");

        // Deleting a book
        List<Book> searchResults = librarySystem.searchBooks("The Great Gatsby");
        if (!searchResults.isEmpty()) {
            Book bookToDelete = searchResults.get(0);
            librarySystem.deleteBook(bookToDelete);
        }

        // Adding users
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        librarySystem.addUser(username, password);

        // Searching for books
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        searchResults = librarySystem.searchBooks(keyword);
        for (Book book : searchResults) {
            System.out.println("Search result: " + book.getTitle());
        }
        
        // Printing the book count
        System.out.println("Number of books: " + librarySystem.getBookCount());
    }
}
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
