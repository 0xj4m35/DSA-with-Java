
import java.util.Calendar;


public class TimeThread implements Runnable {

    // thread's schedule
    @Override
    public void run() {
        
        try {
            while(true) {
                // get current system time
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);
                int sec = c.get(Calendar.SECOND);
                String time = hour + ":" + min + ":" + sec;
                System.out.println(time);
                Thread.sleep(1000); // stop in a second
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
