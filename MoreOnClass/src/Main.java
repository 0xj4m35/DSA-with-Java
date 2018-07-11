
public class Main {
    
     public static void main(String[] args) {
        MyClass m = new MyClass();
        MyClass m1= new MyClass();
        
        MyClass.y = 10;
       // MyClass.x = 20; : error because x is non-static 
    }
}
