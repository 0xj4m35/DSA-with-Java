
package sync;

public class MyPrinter {
    
    public /*synchronized*/ void print(String user, int pages) {
        try {
            System.out.println("Now start printing for " + user);
            for (int i = 1; i <= pages; i++) {
                System.out.printf("User = %-10s, Page = %-5d\n", user, i);
                Thread.sleep(500);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
