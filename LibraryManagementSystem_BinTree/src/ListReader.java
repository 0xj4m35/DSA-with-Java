
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class ListReader {
    
    NodeReader head, tail;

    public ListReader() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }
    
    void addLast(Reader x) {
        NodeReader p = new NodeReader(x);
        if(isEmpty()){
            head = p;
            tail = p;
        }
        else {
            tail.next = p;
            tail = p;
        }
    }
    
    void clear() {
        head = tail = null;
    }
    
    boolean isSuit(String s) {
        if (isEmpty()) {
            return true;
        }
        NodeReader p = head;
        while(p != null) {
            if (p.info.rcode.equalsIgnoreCase(s))
                return false;
            p= p.next;
        }
        return true;
    }
    
    boolean isSuit(int x) {
        if (x < 1900 || x > 2010) {
            return false;
        }
        return true;
    }
    
    void loadFile(String fName) throws IOException {
        clear();
        RandomAccessFile f = new RandomAccessFile(fName, "r");
        String s;
        String [] a;
        String rcode, name;
        int byear;
        Reader x;
        while(true) {
            s = f.readLine();
            if (s == null || s.trim().equals(""))
                break;
            a = s.split("[|]");
            rcode = a[0].trim();
            name = a[1].trim();
            byear = Integer.parseInt(a[2].trim());
            x = new Reader(rcode, name, byear);
            addLast(x);
        }
        f.close();
    }
    
    void writeFile(String fName) throws IOException {
        if (isEmpty()) {
            return;
        }
        File g = new File(fName);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fName, "rw");
        NodeReader p = head;
        while (p != null) {
            f.writeBytes(p.info.writeF() + "\r\n");
            p = p.next;
        }
        f.close();
    }
    
    void inputAndAddToEnd() {
        Scanner sc = new Scanner(System.in);
        String rcode, name;
        int byear;
        while(true) {
            System.out.print("Enter Reader Code: ");
            rcode = sc.nextLine();
            System.out.print("Enter Reader Name: ");
            name = sc.nextLine();
            System.out.print("Enter Reader Birth Year: ");
            byear = Integer.parseInt(sc.nextLine());
            if (isSuit(rcode) && isSuit(byear)) {
                addLast(new Reader(rcode, name, byear));
                break;
            }
            else {
                System.out.println("Invalid Reader Code or Birth Year.");
            }
        }
        System.out.println();
    }
    
    void display() {
        if(isEmpty()) {
            System.out.println("THERE IS NO DATA OF READER.");
            return;
        }
        NodeReader p = head;
        System.out.printf("%-10s | %-20s | %-10s\n", "Code", "Name", "BirthYear");
        System.out.println("----------------------------------------");
        while (p!= null) {
            System.out.printf("%-10s | %-20s | %-10d\n", p.info.rcode, p.info.name, p.info.byear);
            p = p.next;
        }
        System.out.println();
    }
    

    
    NodeReader searchCode(String xCode) {
        if (isEmpty())
            return null;
        NodeReader p = head;
        while (p != null){
            if (p.info.rcode.equalsIgnoreCase(xCode))
                return p;
            p = p.next;
        }
        return null;
    }
    
    void deleNode(NodeReader p) {
        if (p == head) {
            head = head.next;
            return;
        }
        NodeReader i = head;
        while (i.next != p)
            i = i.next;
        if (p == tail) {
            i.next = null;
            tail = i;
        }
        else {
            i.next = p.next;
        }
    }
    
//    void deleteByCode(String xCode) {
//        NodeReader p = searchCode(xCode);
//        if (p == null){
//            System.out.println("Reader Code : '" + xCode + "' not found.");
//            return;
//        }
//        deleNode(p);
//    }
}
