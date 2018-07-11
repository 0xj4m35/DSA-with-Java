
import java.io.Serializable;


public class Fruit implements Serializable {
    
    String name;
    double price;

    public Fruit() {
        this.name = "";
        this.price = 0;
    }

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "\t" + price;
    }
    
        
}
