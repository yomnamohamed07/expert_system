/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mahmoud
 */
class books {
        private String author;
    private double price;
    private int yearPublished;
    private String housePublished;
    private String title;
    public books(String title, String author, double price, int yearPublished, String housePublished) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearPublished = yearPublished;
        this.housePublished = housePublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getHousePublished() {
        return housePublished;
    }
}
