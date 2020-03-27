import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

public class TrayIconDemo  {

   private String message;

    public TrayIconDemo(String message) {
        this.message = message;
    }
   

    public void displayTray() throws AWTException{
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);


        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Reminder", message, MessageType.INFO);
    }

    public void setMessage(String message) {
        this.message = message;
    }


}