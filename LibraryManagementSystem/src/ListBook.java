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
public class ListBook {
    
    NodeBook head, tail;

    public ListBook() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }
    
    void addLast(Book x) {
        NodeBook p = new NodeBook(x);
        if(isEmpty()){
            head = p;
            tail = p;
        }
        else {
            tail.next = p;
            tail = p;
        }
    }
    
    void addFirst(Book x) {
        NodeBook p = new NodeBook(x);
        if (isEmpty()) {
            head = p;
            tail = p;
        } 
        else {
           p.next = head;
           head = p;
        }
    }
    
    void clear() {
        head = tail = null;
    }
    
    int size() {
        if(isEmpty())
            return 0;
        int k = 0;
        NodeBook p = head;
        while (p!= null){
            k++;
            p = p.next;
        }
        return k;
    }
    
    boolean isSuit(String s) {
        if (isEmpty()) {
            return true;
        }
        NodeBook p = head;
        while(p != null) {
            if (p.info.bcode.equalsIgnoreCase(s))
                return false;
            p= p.next;
        }
        return true;
    }
    
    boolean isSuit(int quantity, int lended) {
        if (!(lended > quantity || quantity < 0 || lended < 0)) {
            return true;
        }
        return false;
    }
    
    NodeBook pos(int k) {
        if(isEmpty())
            return null;
        if (k < 0 || k >= size())
            return null;
        NodeBook p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p;
    }
    
    void deleNode(NodeBook p) {
        if (p == head) {
            head = head.next;
            return;
        }
        NodeBook i = head;
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
    
    void loadFile(String fName) throws IOException {
        clear();
        RandomAccessFile f = new RandomAccessFile(fName, "r");
        String s;
        String [] a;
        String bcode, title;
        int quantity, lended;
        double price;
        Book x;
        while(true) {
            s = f.readLine();
            if (s == null || s.trim().equals(""))
                break;
            a = s.split("[|]");
            bcode = a[0].trim();
            title = a[1].trim();
            quantity = Integer.parseInt(a[2].trim());
            lended = Integer.parseInt(a[3].trim());
            price = Double.parseDouble(a[4].trim());
            x = new Book(bcode, title, quantity, lended, price);
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
        NodeBook p = head;
        while (p != null) {
            f.writeBytes(p.info.writeF() + "\r\n");
            p = p.next;
        }
        f.close();
    }
    
    void display() {
        if(isEmpty()) {
            System.out.println("THERE IS NO DATA OF BOOK.");
            return;
        }
        NodeBook p = head;
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s\n", "Code", "Title", "Quantity", "Lended", "Price", "Value");
        System.out.println("---------------------------------------------------------------------------------------");
        while (p!= null) {
            double value = p.info.quantity * p.info.price;
            System.out.printf("%-10s | %-20s | %-10d | %-10d | %-10.2f | %-10.2f\n", p.info.bcode, p.info.title, p.info.quantity, p.info.lended, p.info.price, value);
            p = p.next;
        }
        System.out.println();
    }
    
    void inputAndAddToEnd() {
        Scanner sc = new Scanner(System.in);
        String bcode, title;
        int lended, quantity;
        double price;
        while(true) {
            System.out.print("Enter Book Code: ");
            bcode = sc.nextLine();
            System.out.print("Enter the Title: ");
            title = sc.nextLine();
            System.out.print("Enter the Quantity: ");
            quantity = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Lended: ");
            lended = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Price: ");
            price = Double.parseDouble(sc.nextLine());
            if (isSuit(quantity, lended) && isSuit(bcode)) {
                addLast(new Book(bcode, title, quantity, lended, price));
                break;
            }
            else {
                System.out.println("Invalid Code or Quantity and Lended");
            }
        }
        System.out.println();
    }
    
    NodeBook searchCode(String xCode) {
        if (isEmpty())
            return null;
        NodeBook p = head;
        while (p != null){
            if (p.info.bcode.equalsIgnoreCase(xCode))
                return p;
            p = p.next;
        }
        return null;
    }
    
    void deleteByCode(String xCode) {
        NodeBook p = searchCode(xCode);
        if (p == null){
            System.out.println("Book Code : '" + xCode + "' not found.");
            return;
        }
        deleNode(p);
    }
    
    void sortByCode() {
        if (isEmpty()) {
            return;
        }
        NodeBook i = head;
        while(i.next != null) {
            NodeBook j = i.next;
            while(j != null) {
                if (i.info.bcode.compareToIgnoreCase(j.info.bcode) > 0) {
                    Book b = i.info;
                    i.info = j.info;
                    j.info = b;
                }
                j = j.next;
            }
            i = i.next;
        }
    }
    
    void inputAndAddToBegin() {
        Scanner sc = new Scanner(System.in);
        String bcode, title;
        int lended, quantity;
        double price;
        while(true) {
            System.out.print("Enter Book Code: ");
            bcode = sc.nextLine();
            System.out.print("Enter the Title: ");
            title = sc.nextLine();
            System.out.print("Enter the Quantity: ");
            quantity = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Lended: ");
            lended = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Price: ");
            price = Double.parseDouble(sc.nextLine());
            if (isSuit(quantity, lended) && isSuit(bcode)) {
                addFirst(new Book(bcode, title, quantity, lended, price));
                break;
            }
            else {
                System.out.println("Invalid Code or Quantity and Lended");
            }
        }
        System.out.println();
    }
    
    void addAfter(Book b, int k) {
        NodeBook p = pos(k);
        if (p == null) {
            System.out.println("Error!");
            return;
        }
        if(p == tail) {
            addLast(b);
            return;
        }
        NodeBook x = new NodeBook(b);
        x.next = p.next;
        p.next = x;
    }
    
    void delePos(int k) {
        NodeBook p = pos(k);
        if (p == null) {
            System.out.println("Error!");
            return;
        }
        deleNode(p);
    }
    
    void sortByQuantity() {
        if (isEmpty()) {
            return;
        }
        NodeBook p = head;
        while(p.next != null) {
            NodeBook q = p.next;
            while (q != null) {
                if (p.info.quantity > q.info.quantity) {
                    Book x = p.info;
                    p.info = q.info;
                    q.info = x;
                }
                q = q.next;
            }
            p = p.next;
        }
    }
    
    void sortByPrice() {
        if (isEmpty()) {
            return;
        }
        NodeBook p = head;
        while(p.next != null) {
            NodeBook q = p.next;
            while (q != null) {
                if (p.info.price > q.info.price) {
                    Book x = p.info;
                    p.info = q.info;
                    q.info = x;
                }
                q = q.next;
            }
            p = p.next;
        }
    }
    
    void deleteByName(String xName) {
        if (isEmpty()) {
            return;
        }
        NodeBook p = head;
        while (p != null) {
            if (p.info.title.equalsIgnoreCase(xName)) {
                break;
            }
            p = p.next;
        }
        if (p != null) {
                    deleNode(p);

        }
    }
}
