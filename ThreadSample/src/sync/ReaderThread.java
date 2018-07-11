
package sync;

public class ReaderThread implements Runnable {
    
    Inbox ib;

    public ReaderThread(Inbox ib) {
        this.ib = ib;
    }

    @Override
    public void run() {
        try {
            while(true) {
                ib.read();
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
