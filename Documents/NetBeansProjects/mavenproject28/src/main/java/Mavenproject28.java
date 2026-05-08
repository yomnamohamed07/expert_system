/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.BookSystem;



 import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public static class Book {



  
}


public class BookSystem  extends book{

    private static final List<Book> books = new ArrayList<>();
    private static final int adminPassword = 1234; // Replace with a secure password storage mechanism
    private static final String adminEmail = "admin@library.com"; 
     
}
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the library!");
        System.out.println("1. Admin or 2. User");

        int choice = scanner.nextInt();

        if (choice == 1) {
            if (authenticateAdmin(scanner)) {
                adminMenu(scanner);
            } else {
                System.out.println("Invalid password or email.");
            }
        } else if (choice == 2) {
            userMenu(scanner);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static boolean authenticateAdmin(Scanner scanner) {
        System.out.println("Enter password:");
        int password = scanner.nextInt();
        System.out.println("Enter email:");
        String email = scanner.next();
         return true;
       
    }

    private static void adminMenu(Scanner scanner) {
        System.out.println("Admin Menu:");
        System.out.println("1. Add Book");
        // ... Other admin functionalities (e.g., edit, delete books, view reports)

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addBook(scanner);
                break;
            // ... Implement other admin options
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void userMenu(Scanner scanner) {
        System.out.println("User Menu:");
        System.out.println("1. Search Books");
        System.out.println("2. Display All Books");
        // ... Other user functionalities (e.g., borrow books, view recommendations)

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                searchBooks(scanner);
                break;
          
            // ... Implement other user options
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        scanner.nextLine(); // Consume extra newline character

        // Prompt for other book details (e.g., author, price, year published, house published)
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        System.out.println("Enter year published:");
        int yearPublished = scanner.nextInt();
        scanner.nextLine(); // Consume extra newline character
        System.out.println("Enter house published:");
        String housePublished = scanner.nextLine();

        Book books = new Book(title, author, price, yearPublished, housePublished);
        books.add();
        System.out.println("Book added successfully!");
    }

    private static void searchBooks(Scanner scanner) {
        System.out.println("Enter search keyword:");
        String keyword = scanner.nextLine();
        scanner.nextLine(); // Consume extra newline character



   
}

