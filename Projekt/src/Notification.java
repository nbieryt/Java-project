import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Notification extends ArrayList<Memo> implements Runnable {


    @Override
    public void run() {
        while(true) {
            try {
                for (Memo temp : this) {

                    long duration = Duration.between(temp.getEventDate(), LocalDateTime.now()).getSeconds();

                    if (duration > -10 && duration <= 0)
                        temp.sendNotification();
                    else if ((duration + 900) > -10 && (duration + 900) <= 0)
                        temp.sendNotification();
                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
