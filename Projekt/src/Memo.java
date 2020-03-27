import java.awt.*;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memo {

    private String event;
    private LocalDateTime eventDate;
    private TrayIconDemo demo;
    private String message;

    public Memo(String event, LocalDateTime eventDate)  {
        this.event = event;
        this.eventDate = eventDate;
        message = "You have " + event + " at " + eventDate.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
        this.demo = new TrayIconDemo(message);
    }




    void sendNotification(){
        try {
            demo.displayTray();
        } catch (AWTException e) {
            e.printStackTrace();
            System.out.println("Exception: " + e.getClass().toString());
        }
    }


    //Gettery
    public LocalDateTime getEventDate() {
        return eventDate;
    }
    public String getMessage() {
        return message;
    }

}
