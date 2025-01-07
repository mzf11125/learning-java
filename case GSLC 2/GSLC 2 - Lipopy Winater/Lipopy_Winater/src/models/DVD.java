package models;

import interfaces.Reservable;
public class DVD extends LibraryItem implements Reservable {
    private int duration;
    private String director;
    private float rating;

    public DVD(String title, int duration, String director, float rating) {
        super(title);
        this.id = "DV-NAR-1731719876375";
        this.duration = duration;
        this.director = director;
        this.rating = rating;
    }

    // getter methods
    public int getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public void borrowItem() {
        System.out.println("DVD borrowed: " + title);
        status = "BORROWED";
    }

    @Override
    public void returnItem() {
        System.out.println("DVD returned: " + title);
        status = "AVAILABLE";
    }

    @Override
    public void checkAvailability() {
        System.out.println("["+id+"] DVD " + title + " reserve status: " + status);
    }

    @Override
    public void displayItem() {
        System.out.println("ID : " + id);
        System.out.println("==========================================");
        System.out.println("Title     : " + title);
        System.out.println("Type      : " + this.getClass().getName().substring(7, this.getClass().getName().length()));
        System.out.println("Duration  : " + duration + " minutes");
        System.out.println("Director  : " + director);
        System.out.println("Rating    : " + rating + "/10");
        System.out.println("Status    : " + status);
        System.out.println();
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved: " + title);
        status = "RESERVED";
    }

    @Override
    public void cancelReservation() {
        System.out.println("DVD reservation canceled: " + title);
        status = "AVAILABLE";
    }
}