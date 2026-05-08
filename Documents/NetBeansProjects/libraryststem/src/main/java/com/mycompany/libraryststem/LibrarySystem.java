/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.libraryststem;

import java.util.Scanner;

/**
 *
 * @author mahmoud
 */

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library System!");

        while (true) {
            System.out.println("Enter '1' to login as user, '2' to login as admin, or '0' to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (library.login(username, password, false)) {
                    System.out.println("Login successful!");
                    System.out.print("Enter keyword to search for books: ");
                    String keyword = scanner.nextLine();
                    library.searchBooks(keyword);
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (library.login(username, password, true)) {
                    System.out.println("Login successful!");
                    System.out.println("Enter '1' to add a book, '2' to delete a book, or '0' to logout:");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (adminChoice == 1) {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        library.addBook(title, author);
                        System.out.println("Book added successfully!");
                    } else if (adminChoice == 2) {
                        System.out.print("Enter book title to delete: ");
                        String title = scanner.nextLine();
                        library.deleteBook(title);
                        System.out.println("Book deleted successfully!");
                    } else {
                        // Log out
                        continue;
                    }
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the Library System. Goodbye!");
        scanner.close();
    }
}
    

