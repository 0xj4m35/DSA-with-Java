
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class MyList {
   
    ArrayList<Employee> t;

    public MyList() {
        t = new ArrayList<>();
    }
    
    void clear() {
        t.clear();
      
    }
    
    boolean isEmpty() {
        return(t.isEmpty());
    }
    
    void add (Employee x) {
        t.add(x);
    }
    
    void display() {
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t.get(i));
        }
        System.out.println();
    }
    
    void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s; String[] a;
        String name;
        int age;
        double salary;
        Employee x;
        while(true) {
            s= f.readLine();
            if (s == null || s.trim().equals(""))
                break;
            a = s.split("[|]");
            name = a[0].trim();
            age = Integer.parseInt(a[1].trim());
            salary = Double.parseDouble(a[2].trim());
            x = new Employee(name, age, salary);
            t.add(x);
        }
        f.close();
        
    }
}
