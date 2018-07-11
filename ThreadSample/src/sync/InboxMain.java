
package sync;

public class InboxMain {
    
    public static void main(String[] args) {
        
        Inbox ib = new Inbox();
        WriterThread wt = new WriterThread(ib);
        ReaderThread rt = new ReaderThread(ib);
        Thread wi = new Thread(wt);
        Thread re = new Thread(rt);
        wi.start();
        re.start();
    }
}
