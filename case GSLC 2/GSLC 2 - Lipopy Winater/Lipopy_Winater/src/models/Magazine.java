package models;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Magazine extends LibraryItem {
    private Date issueDate;
    private String frequency;
    private String editor;

    public Magazine(String title, String issueDate, String frequency, String editor) {
        super(title);
        this.id = "MA-THE-1731719876402";
        setIssueDate(issueDate);
        setFrequency(frequency);
        this.editor = editor;
    }

    // getter methods
    public Date getIssueDate() {
        return issueDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getEditor() {
        return editor;
    }

    private void setIssueDate(String issueDate) {
        String dateFormat = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        LocalDate localDate = LocalDate.parse(issueDate, formatter);
        this.issueDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public void borrowItem() {
        System.out.println("Magazine borrowed: " + title);
        status = "BORROWED";
    }

    @Override
    public void returnItem() {
        System.out.println("Magazine returned: " + title);
        status = "AVAILABLE";
    }

    @Override
    public void checkAvailability() {
        System.out.println("["+id+"] Magazine " + title + " reserve status: " + status);
    }

    @Override
    public void displayItem() {
        String dateFormat = "E, MMM dd yyyy";
        System.out.println("ID : " + id);
        System.out.println("==========================================");
        System.out.println("Title                  : " + title);
        System.out.println("Type                   : " + this.getClass().getName().substring(7, this.getClass().getName().length()));
        System.out.println("Issue Date             : " + new SimpleDateFormat(dateFormat).format(issueDate));
        System.out.println("Publication Frequency  : " + frequency);
        System.out.println("Editor                 : " + editor);
        System.out.println("Status                 : " + status);
        System.out.println();
    }
}
