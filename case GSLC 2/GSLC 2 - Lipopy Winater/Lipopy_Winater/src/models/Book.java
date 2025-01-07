package models;

import interfaces.Reservable;

public class Book extends LibraryItem implements Reservable {
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        super(title);
        this.id = "BO-THE-1731719876390";
        this.author = author;
        setGenre(genre);
    }

    // getter methods
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        this.genre = genre;     
    }

    @Override
    public void borrowItem() {
        System.out.println("Book borrowed: " + title);
        status = "BORROWED";
    }

    @Override
    public void returnItem() {
        System.out.println("Book returned: " + title);
        status = "AVAILABLE";
    }

    @Override
    public void checkAvailability() {
        System.out.println("["+id+"] Book " + title + " reserve status: " + status);
    }

    @Override
    public void displayItem() {
        System.out.println("ID : " + id);
        System.out.println("==========================================");
        System.out.println("Title   : " + title);
        System.out.println("Type    : " + this.getClass().getName().substring(7, this.getClass().getName().length()));
        System.out.println("Author  : " + author);
        System.out.println("Genre   : " + genre);
        System.out.println("Status  : " + status);
        System.out.println();
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + title);
        status = "RESERVED";
    }

    @Override
    public void cancelReservation() {
        System.out.println("Book reservation canceled: " + title);
        status = "AVAILABLE";
    }
}