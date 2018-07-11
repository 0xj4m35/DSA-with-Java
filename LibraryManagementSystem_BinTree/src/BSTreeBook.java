
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;


public class BSTreeBook {
    
    NodeBook root;

    public BSTreeBook() {
        root = null;
    }
    
    void clear() {
        root = null;
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    boolean isSuit(String s) {
        if (isEmpty()) {
            return true;
        }
        NodeBook p = root;
        while(p != null) {
            if (p.info.bcode.equalsIgnoreCase(s))
                return false;
            if (p.info.bcode.compareToIgnoreCase(s) > 0) {
                p = p.left;
            }
            else 
                p = p.right;
        }
        return true;
    }
    
    boolean isSuit(int quantity, int lended) {
        if (!(lended > quantity || quantity < 0 || lended < 0)) {
            return true;
        }
        return false;
    }
    
    void insert(Book book) {
        if (isEmpty()) {
            root = new NodeBook(book);
            return;
        }
        NodeBook f,p;
        f = null;
        p = root;
        while (p != null) {
            if(p.info.bcode.equalsIgnoreCase(book.bcode)) {
                System.out.println("The Book is already exist."); 
                return;
            }
            f = p;
            if (book.bcode.compareToIgnoreCase(p.info.bcode) < 0)
                p = p.left;
            else
                p = p.right;
        }
        NodeBook q = new NodeBook(book);
        if (book.bcode.compareToIgnoreCase(f.info.bcode) < 0)
            f.left = q;
        else
            f.right = q;
    }
    
    
    
    void inputAndAdd() {
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
                insert(new Book(bcode, title, quantity, lended, price));
                break;
            }
            else {
                System.out.println("Invalid Code or Quantity and Lended");
            }
        }
        System.out.println();
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
            insert(x);
        }
        f.close();
    }
    
    void visit(NodeBook p) {
        if (p != null) {
            System.out.println(p.info.writeF());
        }
    }
     
    void inOrder(NodeBook p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void breadth(NodeBook p) {
        if (p == null) {
            return;
        }
        p.info.column();
        BQueue q = new BQueue();
        q.enQueue(p);
        NodeBook r;
        while (!q.isEmpty()) {
            r = q.deQueue();
            visit(r);
            if (r.left != null) {
                q.enQueue(r.left);
            }
            if (r.right != null) {
                q.enQueue(r.right);
            }
        }
    }
    
    void inOrder(NodeBook p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        f.writeBytes(p.info.writeF() + "\r\n");
        inOrder(p.right, f);
    }
    
    void writeFile(String fName) throws Exception {
        if (isEmpty()) {
            return;
        }
        File g = new File(fName);
        if (g.exists()) {
            g.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fName, "rw");
        inOrder(root, f);
        f.close();
    }
    
    NodeBook searchBCode(String xBCode) {
        if (isEmpty()) {
            return null;
        }
        NodeBook p = root;
        while (p != null) {
            if (xBCode.equalsIgnoreCase(p.info.bcode)) {
                return p;
            }
            if (xBCode.compareToIgnoreCase(p.info.bcode) < 0) {
                p = p.left;
            }
            else
                p = p.right;
        }
        return p;
    }
    
    void deleByCopying(String xBCode) {
        NodeBook f,p;
        f = null;
        p = root;
        p = searchBCode(xBCode);
        if (p == null) {
            return;
        }
        
        // p is a Leave-Node
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            }
            else {
                if (f.left == p) {
                    f.left = null;
                }
                else {
                    f.right = null;
                }
            }
            return;
        }
        
        // P has left son only
        if (p.left != null && p.right == null) {
            if (f==null) {
                // p == root
                root = root.left;
            }
            else {
                if (f.left == p) {
                    f.left = p.left;
                }
                else {
                    f.right = p.left;
                }
            }
            return;
        }
        
        // P has right son only
        if (p.left == null && p.right != null) {
            if (f==null) {
                // p == root
                root = root.right;
            }
            else {
                if (f.left == p) {
                    f.left = p.right;
                }
                else {
                    f.right = p.right;
                }
            }
            return;
        }
        
        // P has 2 child
        if (p.left != null && p.right != null) {
            // find the right-most node on the left sub-tree
            NodeBook q = p.left;
            NodeBook frp = null, rp = q;
            while (rp != null && rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right most-node...
            // Replace data in P and rp
            p.info = rp.info;
            // Dele rp;
            if (frp == null) {
                // rp  = q;
                p.left = q.left;
            }
            else {
                frp.right = rp.left;
            }
        }
    }
    
    void inOrder(ArrayList<Book> t, NodeBook p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }
    
    void balance(ArrayList<Book> t, int k, int h) {
        if (k > h) {
            return;
        }
        int i = (k + h) / 2;
        Book x = t.get(i);
        insert(x);
        balance(t, k, i-1);
        balance(t, i+1, h);
    }
    
    void balance() {
        ArrayList<Book> t = new ArrayList<>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n-1);
    }
    
    void balance(NodeBook xx) {
        ArrayList<Book> t = new ArrayList<>();
        inOrder(t, xx);
        NodeBook p = root;
        NodeBook f = null;
        
        while (p != null) {
            if(p.info.bcode.equalsIgnoreCase(xx.info.bcode)) {
               break;
            }
            f = p;
            if (xx.info.bcode.compareToIgnoreCase(p.info.bcode) < 0)
                p = p.left;
            else
                p = p.right;
        }
        if (f != null) {
            if (xx.info.bcode.compareToIgnoreCase(f.info.bcode) < 0) {
                f.left = null;
                
            }
            else 
                f.right = null;
        }
        int n = t.size();
        balance(t, 0, n-1);
    }
    
    int numberOfNodeBook() {
       if (isEmpty()) {
           return 0;
       }
       BQueue mq = new BQueue();
        NodeBook i;
        int k = 0;
        mq.enQueue(root);
        while(!mq.isEmpty()) {
            i = mq.deQueue();
            k++;
            if (i.left != null) {
                mq.enQueue(i.left);
            }
            if (i.right != null) {
                mq.enQueue(i.right);
            }
        }
        return k;
    }
    
    
}
    
