
package sync;

public class PrinterThread implements Runnable {
    
    MyPrinter mp;
    String user;
    int pages;

    public PrinterThread(MyPrinter mp, String user, int pages) {
        this.mp = mp;
        this.user = user;
        this.pages = pages;
    }

    @Override
    public void run() {
        synchronized(mp) {
            mp.print(user, pages);
        }
        // the code goes here is not synchronized
    }
}
