
import java.util.Calendar;


public class AlarmThread implements Runnable {

    private int h, m, s, in;

    public void setAlarm(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }
    
    public void setInterval(int in) {
        this.in = in;
    }
    
    @Override
    public void run() {
        try {
            boolean isAlarm = false;
            while(true) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);
                int sec = c.get(Calendar.SECOND);
                String time = hour + ":" + min + ":" + sec;
                System.out.println(time);
                if (hour == h && min == m && sec == s) {
                    
//                    h = (h + (m + (s + in) / 60 ) / 60) % 12;
//                    m = (m + (s + in) / 60 ) % 60;
//                    s = (s + in) % 60;
                    isAlarm = true;
                } 
                if (isAlarm && sec == s) {
                    System.out.println("Reng reng ... ");
                    s = (s + in) % 60;
                }
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
