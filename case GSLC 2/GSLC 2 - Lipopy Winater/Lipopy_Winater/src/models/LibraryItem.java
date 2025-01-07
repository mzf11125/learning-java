package models;

public abstract class LibraryItem {
    protected String title;
    protected String id;
    protected String status;

    public LibraryItem(String title) {
        this.title = title;
        generateID();
        this.status = "AVAILABLE";
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    // Abstract methods for polymorphic behavior
    public abstract void borrowItem();

    public abstract void returnItem();

    public abstract void checkAvailability();

    public abstract void displayItem();

    private void generateID() {
        // Implement logic to generate unique ID for each item
        // Example:
        this.id = this.getClass().getName().substring(7, 9).toUpperCase() + "-" +
            title.substring(0, 3).toUpperCase() + "-" + 
            System.currentTimeMillis();
    }
}
