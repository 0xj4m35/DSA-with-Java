
import java.util.Calendar;


public class Main {
    
    public static void main(String[] args) {
        
        Calendar c = Calendar.getInstance();
        int m = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        
        AlarmThread at = new AlarmThread();
        at.setAlarm(6,m,s + 3); // Reng Reng ... 
        at.setInterval(5); // Bao lai sau moi 5s
        
        Thread t = new Thread(at);
        t.start();
        
//        System.out.println("This is a main Thread...");
//        TimeThread tt = new TimeThread();
//        Thread t = new Thread(tt);
//        System.out.println(t.getState()); // NEW - Vong doi cua Thread.
//        t.start();
//        System.out.println(t.getState()); // RUNNABLE -> RUNNING
//        t.setName("TimeThread");
//        System.out.println(t);
//        // wait until t finishes
//        while(t.isAlive())
//            System.out.println(t.getState()); // WAITED
//        System.out.println(t.getState()); // DEAD or TERMINATED
//        System.out.println("End of main Thread...");
    }
}
