
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
public class ListLending {
    
    NodeLend head, tail;
    ListBook lb = new ListBook();
    ListReader lr = new ListReader();
    
    void loadBook(String fName) throws IOException {
        lb.loadFile(fName);
    }
    
    void loadReader(String fName) throws IOException {
        lr.loadFile(fName);
    }
    
    void traverseBook() {
        if (lb.isEmpty()) {
            return;
        }
        lb.display();
        System.out.println();
    }
    
    void traverseReader() {
        if (lr.isEmpty()) {
            return;
        }
        lr.display();
        System.out.println();
    }
    
    void lend(String bCode, String rCode) {
        NodeBook nb = lb.searchCode(bCode);
        NodeReader nr = lr.searchCode(rCode);
        if (nb == null || nr == null) {
            System.out.println("Not OK");
            return;
        }
        if (nb.info.quantity <= nb.info.lended) {
            System.out.println("Not OK");
            return;
        }
        System.out.println("OK");
        nb.info.lended ++;
        addLast(new Lending(bCode, rCode, 1));
    }
    
    // ========================================================
    public ListLending() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }
    
    void addLast(Lending x) {
        NodeLend p = new NodeLend(x);
        if(isEmpty()){
            head = p;
            tail = p;
        }
        else {
            tail.next = p;
            tail = p;
        }
    }
    
    void display() {
        if(isEmpty()) {
            System.out.println("THERE IS NO DATA OF LENDING.");
            return;
        }
        NodeLend p = head;
        System.out.printf("%-10s | %-15s | %-10s\n", "Book Code", "Reader Code", "State");
        System.out.println("----------------------------------------------------");
        while (p!= null) {
            System.out.printf("%-10s | %-15s | %-10d\n", p.info.bcode, p.info.rcode, p.info.state);
            p = p.next;
        }
        System.out.println();
    }
    
    NodeLend searchByCode(String bCode, String rCode) {
        if (isEmpty()) {
            return null;
        }
        NodeLend p = head;
        while (p != null) {
            if (p.info.rcode.equalsIgnoreCase(rCode) && p.info.bcode.equalsIgnoreCase(bCode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    
    void deleNode(NodeLend p) {
        if (p == head) {
            head = head.next;
            return;
        }
        NodeLend i = head;
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
    
    void sortByCode() {
        if (isEmpty()) {
            return;
        }
        NodeLend i = head;
        NodeLend j;
        while (i.next != null) {
            j = i.next;
            while (j != null) {
                if (i.info.bcode.compareToIgnoreCase(j.info.bcode) > 0) {
                    Lending l = i.info;
                    i.info = j.info;
                    j.info = l;
                }
                j = j.next;
            }
            i = i.next;
        }
        i = head;
        while (i.next != null) {
            j = i.next;
            while (j != null) {
                if (i.info.bcode.equalsIgnoreCase(j.info.bcode)) {
                    if (i.info.rcode.compareToIgnoreCase(j.info.rcode) > 0) {
                        Lending l = i.info;
                        i.info = j.info;
                        j.info = l;
                    }
                }
                
                j = j.next;
            }
            i = i.next;
        }
    }
}
