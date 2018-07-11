
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class MyFruit {
    
    public static void main(String[] args) {
   
        try {
            Fruit f1 = new Fruit("Mango", 1.3);
            Fruit f2 = new Fruit("Banana", 0.7);
            //save f1, f2 to fruits.dat
            String fname = "fruits.dat";
            
            FileOutputStream fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(f1);
            oos.writeObject(f2);
            oos.writeDouble(Math.PI);
            
            oos.close();
            fos.close();
            
            //read data from fruits.dat
            
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            f1 = (Fruit) ois.readObject(); // casting - explicit (not implicit)
            System.out.println(f1);
            System.out.println(ois.readObject());
            System.out.println(ois.readDouble());
            ois.close();
            fis.close();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
