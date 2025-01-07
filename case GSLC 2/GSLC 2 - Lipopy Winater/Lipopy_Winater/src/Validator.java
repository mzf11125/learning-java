import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import interfaces.Reservable;
import models.LibraryItem;

public class Validator {
	
	ArrayList<String> BookGenre;
    ArrayList<String> ItemStatus;
    ArrayList<String> PublicationFrequency;
	
    public static boolean isTitleValid(String title) {
        return title.split(" ").length >= 2;
    }

    public static boolean isTypeValid(String type) {
        return type.equals("Book") || type.equals("DVD") || type.equals("Magazine");
    }

    public static boolean isAuthorValid(String author) {
        return author.startsWith("Mr. ") || author.startsWith("Mrs. ");
    }

    public static boolean isGenreValid(String genre) {
        boolean valid = false;
        
        if ("Fiction".equalsIgnoreCase(genre) ||
        		"NonFiction".equalsIgnoreCase(genre) ||
        		"ScienceFiction".equalsIgnoreCase(genre) ||
        		"Biography".equalsIgnoreCase(genre) ||
        		"History".equalsIgnoreCase(genre) ||
        		"Poetry".equalsIgnoreCase(genre)) 
        {
            valid = true;
        }
        

        return valid;
    }

    public static boolean isDurationValid(int duration) {
        return duration > 0;
    }

    public static boolean isDirectorValid(String director) {
        return director.split(" ").length >= 2;
    }

    public static boolean isRatingValid(float rating) {
        return rating >= 0 && rating <= 10;
    }

    public static boolean isIssueDateValid(String issueDate) {
        String dateFormat = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        try {
            LocalDate.parse(issueDate, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isFrequencyValid(String frequencyString) {
        boolean valid = false;
        
        if ("Weekly".equalsIgnoreCase(frequencyString) ||
        		"Monthly".equalsIgnoreCase(frequencyString) ||
        		"Quarterly".equalsIgnoreCase(frequencyString) ||
        		"Annually".equalsIgnoreCase(frequencyString) ||
        		"Daily".equalsIgnoreCase(frequencyString)) 
        {
            valid = true;
        }
        

        return valid;
    }

    public static boolean isEditorValid(String editor) {
        return editor.split(" ").length >= 2;
    }

    public static LibraryItem isIDReservedValid(String id, ArrayList<LibraryItem> aItems) {
        for (LibraryItem libraryItem : aItems) 
            if(libraryItem instanceof Reservable && libraryItem.getId().equals(id))
                return libraryItem;
            
        return null;
    }

    public static LibraryItem isIDBorrowValid(String id, ArrayList<LibraryItem> aItems) {
        for (LibraryItem libraryItem : aItems) 
            if((libraryItem.getStatus() == "AVAILABLE" || libraryItem.getStatus() == "RESERVED") && libraryItem.getId().equals(id))
                return libraryItem;
            
        return null;
    }

    public static LibraryItem isIDReturnValid(String id, ArrayList<LibraryItem> aItems) {
        for (LibraryItem libraryItem : aItems) 
            if((libraryItem.getStatus() == "BORROWED" || libraryItem.getStatus() == "RESERVED") && libraryItem.getId().equals(id))
                return libraryItem;
            
        return null;
    }
}
