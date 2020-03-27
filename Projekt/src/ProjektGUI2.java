
import java.awt.event.*;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class ProjektGUI2 extends JFrame {

    private JPanel GUI2panel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JFormattedTextField memoText;
    private JLabel dateLabel;
    private JTable table1;
    private JButton Set;
    private JTextField hourText;
    private JTextField minuteText;
    Memo memo1;
    ProjektGUI parentProjektGUI;//osobne gui maja swoje tablice

    private void refresh(){
        parentProjektGUI.eventsArea.setText(String.valueOf(memo1.getMessage()));
    }


    public ProjektGUI getParentProjektGUI() {
        return parentProjektGUI;
    }
    public void setParentProjektGUI(ProjektGUI parentProjektGUI) {
        this.parentProjektGUI = parentProjektGUI;
    }



    public ProjektGUI2() {

        setContentPane(GUI2panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000,400);
        Date d1 = new Date();
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(d1);



        Set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateLabel.getText());
                    LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

                    int hour = Integer.parseInt(hourText.getText());
                    int minute = Integer.parseInt(minuteText.getText());
                    localDateTime = localDateTime.withHour(hour).withMinute(minute);

                    String event = memoText.getText();
                    memo1 = new Memo(event, localDateTime);
                    parentProjektGUI.getNotification().add(memo1);

                    refresh();


                }catch(NullPointerException | ParseException e1){
                    e1.printStackTrace();
                    System.out.println("Exception: " + e1.getClass().toString());
                }


            }});


    }




    public static void main (String[]args){
        new ProjektGUI2().setVisible(true);

        JFrame.setDefaultLookAndFeelDecorated(true); //?

    }
    // ustawianie pola dateTextFiled
    public JLabel getDateLabel() {return dateLabel; }
    public JFormattedTextField getMemoText() { return memoText; }

}
