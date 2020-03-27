import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Timer;


public class ProjektGUI extends JFrame{
    private JPanel Calendar;
    private JPanel datePanel;
    private JLabel dateLabel;
    private JButton planAnEvent;
    protected JTextArea eventsArea;
    private JLabel mainLabel;

    private String dt;
    Notification notification;
    private ProjektGUI thisProjektGUI;
    Calendar actualTime = java.util.Calendar.getInstance();
    JDateChooser dateChos = new JDateChooser(actualTime.getTime());



    public java.util.Calendar getActualTime() {
        return actualTime;
    }

    public Notification getNotification() {
        return notification;
    }


    public ProjektGUI() {
        thisProjektGUI = this;
        setContentPane(Calendar);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,350);

        notification = new Notification();

        Thread notificationThread = new Thread(notification);
        notificationThread.start();

        dateChos.setDateFormatString("dd/MM/yyyy");
        datePanel.add(dateChos);


        planAnEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjektGUI2 second = new ProjektGUI2();
                SimpleDateFormat sdfm= new SimpleDateFormat("dd/MM/yyyy");
                dt = sdfm.format((dateChos.getDate()));
                second.getDateLabel().setText(dt);
                second.setParentProjektGUI(thisProjektGUI);
                second.setVisible(true);
                Calendar.setVisible(true);
                second.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



            }
        });

    }


    public static void main(String[] args) {
        new ProjektGUI().setVisible(true);




    }
}
