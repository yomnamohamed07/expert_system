/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// name :yomna mohamed fathy 
// id:202201425
package com.mycompany.librarycatalogue;
import java.util.Scanner;
public class LibraryCatalogue {
    private String[] titles;
    private String[] authors;
    private String[] genres;
    private boolean[] availability;

    public LibraryCatalogue(int size) {
        titles = new String[size];
        authors = new String[size];
        genres = new String[size];
        availability = new boolean[size];
    }

    public void addBook(String title, String author, String genre) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] == null) {
                titles[i] = title;
                authors[i] = author;
                genres[i] = genre;
                availability[i] = true;
                System.out.println("Book added successfully.");
                return;
            }
        }
        System.out.println("Library is full. Cannot add more books.");
    }

    public void searchByTitle(String title) {
        System.out.println("Search Results:");
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null && titles[i].equalsIgnoreCase(title)) {
                System.out.println("Title: " + titles[i] + ", Author: " + authors[i] + ", Genre: " + genres[i] + ", Availability: " + (availability[i] ? "Available" : "Not Available"));
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        System.out.println("Search Results:");
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null && authors[i].equalsIgnoreCase(author)) {
                System.out.println("Title: " + titles[i] + ", Author: " + authors[i] + ", Genre: " + genres[i] + ", Availability: " + (availability[i] ? "Available" : "Not Available"));
            }
        }
    }

    public void checkOut(String title) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null && titles[i].equalsIgnoreCase(title)) {
                if (availability[i]) {
                    availability[i] = false;
                    System.out.println("Book checked out successfully.");
                    return;
                } else {
                    System.out.println("Book is not available for checkout.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null && titles[i].equalsIgnoreCase(title)) {
                availability[i] = true;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < titles.length; i++) {
            if (titles[i] != null && availability[i]) {
                System.out.println("Title: " + titles[i] + ", Author: " + authors[i] + ", Genre: " + genres[i]);
            }
        }
    }

    public static void main(String[] args) {
        LibraryCatalogue catalogue = new LibraryCatalogue(100);
        // Sample usage
        catalogue.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        catalogue.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction");
        catalogue.addBook("1984", "George Orwell", "Dystopian");
        catalogue.checkOut("To Kill a Mockingbird");
        catalogue.displayAvailableBooks();
    }
}

