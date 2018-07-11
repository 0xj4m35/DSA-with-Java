
public class MyClass {
    
    int x; // instance variable
    static int y; // class variable
    static {
        y += 2;
        System.out.println("y = "+ y);
    }
    public  MyClass() {
        y ++;
        System.out.println("y = " + y);
    }
    static {
        y += 3;
        System.out.println("y = "+ y);
    }
    
    // static: chay 1 lan, chay truoc ca Constructor
    
}
