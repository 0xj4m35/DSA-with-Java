
//import com.sun.javafx.binding.StringFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class Book {
    String bcode, title;
    int quantity, lended;
    double price;

    public Book() {
        bcode = "";
        title = "";
        quantity = 0;
        lended = 0;
        price = 0;
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public void show() {
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n", "Code", "Title", "Quantity", "Lended", "Price");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10d | %-10d | %-10.2f\n", bcode, title, quantity, lended, price);
    }


    public String writeF() {
        String s = String.format("%-10s | %-20s | %-10d | %-10d | %-10.2f", bcode, title, quantity, lended, price);
        return s;
    }

    
    
    
    
}
