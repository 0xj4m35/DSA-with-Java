
public class MyList {
    
    Node head, tail;

    public MyList() {
        head = tail = null;
    }
    
    void clear() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        return head==null;
    }
    
    void addLast(Person x) {
        Node q = new Node(x);
        if(isEmpty()) {
            head = tail = q;
            return;
        }
        else {
            tail.next = q;
            tail = q;
        }
    }
    
    void display(Node p) {
        if(p!= null) 
            System.out.println(p.info);
    }
    
    void traverse() {
        Node p = head;
        while (p!=null){
            display(p);
            p = p.next;
        }
        System.out.println();
    }
    
    void addMany(String [] a, int [] b) {
        int n;
        n = a.length;
        for (int j = 0; j < n; j++) {
            addLast(new Person(a[j], b[j]));
        }   
    }
    
    void addToHead(Person x) {
        Node p = new Node(x);
        if(isEmpty()) {  
            head = p;
            tail = p;
            return;
        }
        p.next = head;
        head = p;
    }
    
    void addAfter(Node p, Person x) {
        if (p == null)
            return;
        Node p1 = p.next;
        Node p2 = new Node(x);
        if(p1!=null) {   
            p2.next = p1;
        }
        else {
            tail = p2;
        }
        p.next = p2;
    }
    
    void deleteFromHead() {
        if(isEmpty())
            return;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;
    }
    
    void deleteFromTail() {
        if (isEmpty())
            return;
        if (head.next == null) {
            tail = head = null;
            return;
        }
        Node p = head;
        while (p.next != tail)
            p = p.next;
        p.next = null;
        tail = p;
    }
    
    void deleteAfter(Node p) {
        if (p == null)
            return;
        if (isEmpty())
            return;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        Node q = p.next;
        if (q == null) {
            tail = p;
            tail.next = null;
            return;
        }  
        q = q.next;
        p.next = q;
    }
    
    
    // void dele(person x) - delele the first node whose info is equal to  x
    void dele(Person x) {
        Node p = head;
        while (p != null) {
            if((p.info.name.equals(x.name)) && (p.info.age == x.age)) {
                if (p == head) {
                    head = head.next;
                    return;
                }
                Node q = head;
                while (q.next != p)
                    q = q.next;
                if (p == tail) {
                    tail = q;
                    tail.next = null;
                    return;
                }
                p = p.next;
                q.next = p;
            }
            p = p.next;
        }
    }
    
    Node search(Person x) {
        Node p = head;
        while (p != null) {
            if((p.info.name.equals(x.name)) && (p.info.age == x.age)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    
    int count() {
        int cnt = 0;
        if (isEmpty())
            return 0;
        Node p = head;
        while (p!=null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }
    
    // void dele(int i) - delete an i-th node on the list. Besure that such a node exists. 
    void dele(int i) {
        if (i<0 || i >= count())
            return;
        if(i==0){
            if (count() > 1) {
                head = head.next;
                return;
            }
            else {
                head = tail = null;
                return;
            }
        }
        
        Node p = head;
        
        for(int j=0; j<i-1; j++)
            p = p.next;
        
        if (p.next.next == null) {
            tail = p;
            tail.next = null;
            return;
        }
        Node q = p.next.next;
        p.next = q;
    }
    
    void sort() {
        Node i = head;
        while(i.next != null ){
            Node j = i.next;
            while (j != null) {
                if (i.info.age > j.info.age){
                    Person x = i.info;
                    i.info = j.info;
                    j.info = x;
                }
                j = j.next;
            }
            i = i.next;
        }
    }
    
    
}
