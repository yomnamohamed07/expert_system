/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.LibrarySystemGUI;

/**
 *
 * @author mahmoud
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.lang.model.SourceVersion;

public class LibrarySystemGUI extends JFrame implements ActionListener {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private JTextField titleField, authorField, yearField, searchField;
    private JTextArea outputArea;

    public LibrarySystemGUI() {
        setTitle("Library System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        books = new ArrayList<>();
        users = new ArrayList<>();

        // Create input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Year:"));
        yearField = new JTextField();
        inputPanel.add(yearField);
        inputPanel.add(new JLabel("Search:"));
        searchField = new JTextField();
        inputPanel.add(searchField);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        buttonPanel.add(searchButton);

        // Create output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add components to content pane
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add Book")) {
            String title = titleField.getText();
            String author = authorField.getText();
            int year = Integer.parseInt(yearField.getText());

            Book newBook = new Book(title, author, year);
            books.add(newBook);

            displayBooks();
        }
        else if (command.equals("Search")) {
            String searchText = searchField.getText().toLowerCase();
            searchBooks(searchText);
        }
    }

    private void displayBooks() {
        outputArea.setText("");
        for (Book book : books) {
            outputArea.append(book.toString() + "\n");
        }
    }

    private void searchBooks(String searchText) {
        outputArea.setText("");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchText) ||
                book.getAuthor().toLowerCase().contains(searchText) ||
                Integer.toString(book.getYear()).contains(searchText)) {
                outputArea.append(book.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibrarySystemGUI();
            }
        });
    }
}

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
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





