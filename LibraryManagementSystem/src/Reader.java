/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class Reader {
    String rcode, name;
    int byear;

    public Reader() {
        rcode = "";
        name = "";
        byear = 1900;
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }
    
    void show() {
        System.out.printf("%-10s | %-20s | %-10s\n", "Code", "Name", "BirthYear");
        System.out.println("----------------------------------------");
        System.out.printf("%-10s | %-20s | %-10d\n", rcode, name, byear); 
        System.out.println();
    }
    
    public String writeF() {
        String s = String.format("%-10s | %-20s | %-10d",rcode, name, byear);
        return s;
    }
}
