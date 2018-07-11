
package sync;

public class Main {
    
    public static void main(String[] args) {
        
        MyPrinter mp = new MyPrinter();
        PrinterThread u1 = new PrinterThread(mp, "John Smith", 2);
        PrinterThread u2 = new PrinterThread(mp, "Yen Nguyen", 4);
        PrinterThread u3 = new PrinterThread(mp, "Alex Groot", 3);
        
        Thread t1 = new Thread(u1);
        Thread t2 = new Thread(u2);
        Thread t3 = new Thread(u3);
        
        t1.start();
        t2.start();
        t3.start();
        
    }
    
}
