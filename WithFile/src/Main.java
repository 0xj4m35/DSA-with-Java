
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        String fname = "emp.txt";
        MyList t = new MyList();
        t.loadFile(fname);
        t.display();
    }
}
