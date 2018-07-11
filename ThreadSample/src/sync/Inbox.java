
package sync;

public class Inbox {
    
    String message; // content of inbox
    boolean hasNew; // true if a new message has just arrived
    
    // save a message to inbox
    public synchronized void save(String message) throws Exception {
        // wait until the inbox is empty
        while(hasNew) {
            wait();
        }
        this.message = message;
        System.out.println("New message has just arrived. : " + message);
        hasNew = true;
        notify(); 
    }
    
    // Read message from inbox
    public synchronized void read() throws Exception {
        while (!hasNew) {
            wait();
        }
        System.out.println("Reading message : " + message);
        hasNew = false;
        notify();
    }
}
