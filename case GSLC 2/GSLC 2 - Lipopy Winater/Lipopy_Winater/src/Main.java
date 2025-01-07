import java.util.ArrayList;
import java.util.Scanner;

import interfaces.Reservable;
import models.Book;
import models.DVD;
import models.LibraryItem;
import models.Magazine;
// polymorph, interface dan abstract class

public class Main {
    Scanner sc;
    ArrayList<LibraryItem> aItems;
    ArrayList<String> BookGenre;
    ArrayList<String> PublicationFrequency;
    String logo = 
    " __       __  .______     ______   .______     ____    ____ \n" +
   "|  |     |  | |   _  \\   /  __  \\  |   _  \\    \\   \\  /   / \n" +
   "|  |     |  | |  |_)  | |  |  |  | |  |_)  |    \\   \\/   /  \n" +
   "|  |     |  | |   ___/  |  |  |  | |   ___/      \\_    _/   \n" +
   "|  `----.|  | |  |      |  `--'  | |  |           |  |      \n" +
   "|_______||__| | _|       \\______/  | _|           |__|      \n" +
   "                                                             \n" +
   " ____    __    ____  __  .__   __.      ___   .___________. _______ .______      \n" +
   " \\   \\  /  \\  /   / |  | |  \\ |  |     /   \\  |           ||   ____||   _  \\     \n" +
   "  \\   \\/    \\/   /  |  | |   \\|  |    /  ^  \\ `---|  |----`|  |__   |  |_)  |    \n" +
   "   \\            /   |  | |  . `  |   /  /_\\  \\    |  |     |   __|  |      /     \n" +
   "    \\    /\\    /    |  | |  |\\   |  /  _____  \\   |  |     |  |____ |  |\\  \\----.\n" +
   "     \\__/  \\__/     |__| |__| \\__| /__/     \\__\\  |__|     |_______|| _| `._____|\n";


    public Main() {
        sc = new Scanner(System.in);
        aItems = new ArrayList<>();
        BookGenre = new ArrayList<>();
        PublicationFrequency = new ArrayList<>();
        seeder();
        int choice;
        while (true) {
            printMenu();
            choice = getInt();
            if (choice == 6)
                break;
            switch (choice) {
                case 1:
                    cls();
                    addItem();
                    break;
                case 2:
                    cls();
                    viewLibraryItems();
                    sc.nextLine();
                    break;
                case 3:
                    cls();
                    reserveItems();
                    break;
                case 4:
                    cls();
                    borrowItems();
                    break;
                case 5:
                    cls();
                    returnItems();
                    break;
            }
        }
    }

    private void seeder() {
        aItems.add(new DVD("Narnia: The Forbidden Forest", 150, "Fren Ricardy", 8.9f));
        aItems.add(new Book("The adventure of Spongebob", "Mr. Marvino", "Fiction"));
        aItems.add(new Magazine("The Cooking Adventure", "2011-12-04", "Daily", "Edward Sugianto"));
        
        BookGenre.add("Fiction");
        BookGenre.add("NonFiction");
        BookGenre.add("ScienceFiction");
        BookGenre.add("Biography");
        BookGenre.add("History");
        BookGenre.add("Poetry");
        
        PublicationFrequency.add("Weekly");
        PublicationFrequency.add("Monthly");
        PublicationFrequency.add("Quarterly");
        PublicationFrequency.add("Annually");
        PublicationFrequency.add("Daily");
    }

    private void returnItems() {
        String id = "";
        boolean isExist = false;
        for (LibraryItem libraryItem : aItems) {
        	if(libraryItem.getStatus() == "BORROWED" ||libraryItem.getStatus() == "RESERVED"){
        		libraryItem.checkAvailability();
        		isExist = true;
        	}        	
        }
        
        if(!isExist){
            System.out.println("No Borrowed or Reserved items");
            sc.nextLine();
            return;
        }
        
        LibraryItem libraryItem = null;
        do {
            System.out.print("Input Item ID [exit]: " );
            id = sc.nextLine();
        } while ((libraryItem = Validator.isIDReturnValid(id, aItems)) == null && !id.equalsIgnoreCase("exit"));
        if(libraryItem.getStatus() == "BORROWED") {
        	if(libraryItem instanceof DVD)
        		((DVD) libraryItem).returnItem();
        	else
        		((Magazine) libraryItem).returnItem();
        }
        else if(libraryItem.getStatus() == "RESERVED")
            ((Reservable) libraryItem).cancelReservation();
        sc.nextLine();
    }

    private void borrowItems() {
        String id = "";
        boolean isExist = false;
        for (LibraryItem libraryItem : aItems) 
        if(libraryItem.getStatus() == "AVAILABLE" || libraryItem.getStatus() == "RESERVED"){
            libraryItem.checkAvailability();
            isExist = true;
        }
        
        if(!isExist){
            System.out.println("No Available or Reserved items");
            sc.nextLine();
            return;
        }
        
        LibraryItem libraryItem = null;
        do {
            System.out.print("Input Item ID [exit]: " );
            id = sc.nextLine();
        } while ((libraryItem = Validator.isIDBorrowValid(id, aItems)) == null && !id.equalsIgnoreCase("exit"));
        
        libraryItem.borrowItem();
        sc.nextLine();
    }

    private void reserveItems() {
        String id = "";
        boolean isExist = false;
        for (LibraryItem libraryItem : aItems) 
        if(libraryItem instanceof Reservable && libraryItem.getStatus() == "AVAILABLE"){
            libraryItem.checkAvailability();
            isExist = true;
        }
        
        if(!isExist){
            System.out.println("No reserveable items");
            sc.nextLine();
            return;
        }
        
        LibraryItem libraryItem = null;
        do {
            System.out.print("Input Item ID [exit]: " );
            id = sc.nextLine();
        } while ((libraryItem = Validator.isIDReservedValid(id, aItems)) == null && !id.equalsIgnoreCase("exit"));
        
        ((Reservable) libraryItem).reserveItem();
        sc.nextLine();
    }

    private void viewLibraryItems() {
        if(aItems.isEmpty())
            System.out.println("No items");
        else
            for (LibraryItem libraryItem : aItems) {
                libraryItem.displayItem();
            }
    }

    public void addItem() {
        String title = "";
        String type = "";
        LibraryItem item;

        do {
            System.out.print("Enter title [min. 2 words]: ");
            title = sc.nextLine();
        } while (!Validator.isTitleValid(title));

        do {
            System.out.print("Enter type (Book|Magazine|DVD): ");
            type = sc.nextLine();
        } while (!Validator.isTypeValid(type));

        if (type.equals("Book")) {
            String author = "";
            String genreString = "";

            do {
                System.out.print("Enter Author [Start with 'Mr. '|'Mrs. ']: ");
                author = sc.nextLine();
            } while (!Validator.isAuthorValid(author));

            do {
                System.out.print("Enter Genre [" + getFullGenre() + "]: ");
                genreString = sc.nextLine();
            } while (!Validator.isGenreValid(genreString));

            item = new Book(title, author, genreString);
            aItems.add(item);

        } else if (type.equals("Magazine")) {
            String issueDateString;
            String frequencyString;
            String editor;

            do {
                System.out.print("Enter Issue Date [yyyy-MM-dd]: ");
                issueDateString = sc.nextLine();
            } while (!Validator.isIssueDateValid(issueDateString));

            do {
                System.out.print("Enter Frequency [" + getFullFrequency() + "]: ");
                frequencyString = sc.nextLine();
            } while (!Validator.isFrequencyValid(frequencyString));

            do {
                System.out.print("Enter Editor [at least 2 words]: ");
                editor = sc.nextLine();
            } while (!Validator.isEditorValid(editor));

            item = new Magazine(title, issueDateString, frequencyString, editor);
            aItems.add(item);

        } else if (type.equals("DVD")) {
            int duration;
            String director;
            float rating;

            do {
                System.out.print("Enter Duration [more than 0]: ");
                duration = getInt();
            } while (!Validator.isDurationValid(duration));

            do {
                System.out.print("Enter Director [at least 2 words]: ");
                director = sc.nextLine();
            } while (!Validator.isDirectorValid(director));

            do {
                System.out.print("Enter Rating [0-10]: ");
                rating = getFloat();
            } while (!Validator.isRatingValid(rating));

            item = new DVD(title, duration, director, rating);
            aItems.add(item);
        }
        System.out.println("Item added successfully...");
        sc.nextLine();
    }

    private String getFullGenre() {
        String x = "";
        for (String bookGenre : BookGenre) {
            x += bookGenre + "|";
        }
        x = x.substring(0, x.length() - 1);
        return x;
    }

    private String getFullFrequency() {
        String x = "";
        for (String frequency : PublicationFrequency) {
            x += frequency + "|";
        }
        x = x.substring(0, x.length() - 1);
        return x;
    }

    public void printMenu() {
        cls();
        System.out.println(logo);
        System.out.println("Choose an option:");
        System.out.println("1. Add item");
        System.out.println("2. View library items");
        System.out.println("3. Reserve items");
        System.out.println("4. Borrow items");
        System.out.println("5. Return / Cancel Reserve items");
        System.out.println("6. Exit");
        System.out.print(">> ");
    }

    public int getInt() {
        int x = 0;
        try {
            x = sc.nextInt(); 
        } catch (Exception e) {
            System.out.print("Invalid input. Please enter a number.");
            sc.nextLine();
        }
        sc.nextLine();
        return x;
    }

    public float getFloat() {
        float x = 0f;
        try {
            x = sc.nextFloat(); 
        } catch (Exception e) {
            System.out.print("Invalid input. Please enter a number.");
            sc.nextLine();
        }
        sc.nextLine();
        return x; 
    }

    public void cls(){
        for(int i=0; i<45; i++)
            System.out.println("");
    }

    public static void main(String[] args) {
        new Main();
    }
}