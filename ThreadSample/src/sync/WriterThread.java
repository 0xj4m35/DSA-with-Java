
package sync;

import java.util.Random;

public class WriterThread implements Runnable {
    
    Inbox ib;

    public WriterThread(Inbox ib) {
        this.ib = ib;
    }

    
    
    @Override
    public void run() {
        try {
            String[] msg = {"xin chao", "chao", "Xiao", "Hello", "Good bye", "Nice to meet you"};
            while(true) {
                Random r = new Random();
                String m = msg[r.nextInt(msg.length)];
                ib.save(m);
                Thread.sleep(500);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
