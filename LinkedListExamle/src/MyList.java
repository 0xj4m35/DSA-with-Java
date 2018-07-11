
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1) 
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3)
    void addFirst(Person x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    // (4)
    void insertAfter(Node q, Person x) {
        if (q == null)
            return;
        if (q == tail) {
            addLast(x);
            return;
        }
        Node p = new Node(x);
        p.next = q.next;
        q.next = p;
    }

    // (5)
    void insertBefore(Node q, Person x) {
        if (q == null)
            return;
        if (q == head){
            addFirst(x);
            return;
        }
        Node p = new Node(x);
        Node i = head;
        while (i.next != q)
            i = i.next;
        i.next = p;
        p.next = q;
    }

    // (6)
    void dele(Node q) {
        if (q == null)
            return;
        if (q == head && q == tail) {
            head = tail = null;
            return;
        }
        if (q == head) {
            head = head.next;
            return;
        }
        Node i = head;
        while (i.next != q) {
            i = i.next;
        }
        if (q == tail) {
            tail = i;
            tail.next = null;
            return;
        }
        i.next = q.next;
    }

    // (7)
    void dele(String xName) {
        if (isEmpty())
            return;
        Node i = head;
        while (i != null) {
            if (i.info.name.equals(xName))
                break;
            i = i.next;
        }
        if (i != null)
            dele(i);
    }

    // (8)
    void dele(int xAge) {
        if (isEmpty())
            return;
        Node i = head;
        while (i != null) {
            if (i.info.age == xAge)
                break;
            i = i.next;
        }
        if (i != null)
            dele(i);
    }
    
    boolean checkAge(int xAge) {
        if(isEmpty())
            return false;
        Node i = head;
        while (i != null) {
            if (i.info.age == xAge)
                return true;
            i = i.next;
        }
        return false;
    }
    
    // (9)
    void deleAll(int xAge) {
        if (isEmpty())
            return;
        Node i = head;
        while (checkAge(xAge)) {
            dele(xAge);
        }
    }

    // (10)
    Node pos(int k) {
        if (k < 0 || k >= size())
            return null;
        int i = 0;
        Node p = head;
        while (i < k) {
            p = p.next;
            i++;
        }
        return p;
    }

    // (11)
    void delePos(int k) {
        if (k < 0 || k >= size())
            return;
        Node p = pos(k);
        dele(p);
    }

    // (12)
    void sortByName() {
        if (isEmpty())
            return;
        Node i = head;
        while (i.next != null) {
            Node j = i.next;
            while (j != null) {
                if(i.info.name.compareTo(j.info.name) > 0) {
                    Person x = i.info;
                    i.info = j.info;
                    j.info = x;
                }
                j = j.next;
            }
            i = i.next;
        }
    }

    // (13)
    void sortByAge() {
        if (isEmpty())
            return;
        Node i = head;
        while(i.next != null) {
            Node j = i.next;
            while (j != null) {
                if (i.info.age > j.info.age) {
                    Person x = i.info;
                    i.info = j.info;
                    j.info = x;
                }
                j = j.next;
            }
            i = i.next;
        }
    }

    // (14)
    int size() {
        int k = 0;
        if (isEmpty())
            return k;
        Node i = head;
        while(i != null) {
            k++;
            i = i.next;
        }
        return k;
    }

    // (15)
    Person[] toArray() {
        Person [] arr = new Person[size()];
        if (isEmpty())
            return null;
        int i = 0;
        Node p = head;
        while (p != null) {
            arr[i++] = new Person(p.info.name, p.info.age);
            p = p.next;
        }
        return arr;
    }

    // (16)
    void reverse() {
//        if (isEmpty()) {
//            return;
//        }
//        Node xhead = new Node(), xtail = new Node();
//        Node p = head;
//        xhead.info = p.info;
//        xtail.info = p.info;
//        p = p.next;
//        while (p != null) {
//            Node temp = new Node();
//            temp.info = p.info;
//            temp.next = xhead;
//            xhead = temp;
//            p = p.next;
//        }
//        head = xhead;
//        tail = xtail;


        Node pre = null, next = null, cur = head;
        while (cur != null) {            
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        tail = head;
        head = pre;
    
    }

    // (17) 
    Node findMaxAge() {
        if (isEmpty())
            return null;
        Node p = head;
        Node maxAge = p;
        while(p != null) {
            if (maxAge.info.age < p.info.age)
                maxAge = p;
            p = p.next;
        }
        return maxAge;
    }

    // (18) 
    Node findMinAge() {
        if(isEmpty())
            return null;
        Node p = head;
        Node minAge = p;
        while (p != null) {
            if (minAge.info.age > p.info.age)
                minAge = p;
            p = p.next;
        }
        return minAge;
    }

    // (19) 
    void setData(Node p, Person x) {
        p.info = x;
    }

    // (20) 
    void sortByAge(int k, int h) {
        if (isEmpty() || k >= h || k >= size() || h < 0)
            return;
        Node p = head, left, right;
        for (int i=0; i < k; i++)
            p = p.next;
        left = p;
        for (int i=k ; i <= h; i++)
            p = p.next;
        right = p;
        Node u = left;
        while (u.next != right) {
            Node v = u.next;
            while (v != right){
                if (u.info.age > v.info.age){
                    Person x = u.info;
                    u.info = v.info;
                    v.info = x;
                }
                v= v.next;
            }
            u = u.next;
        }
        
    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
        if (isEmpty() || k >= h || k >= size() || h < 0)
            return;
        Node p = head, left, right;
        for (int i = 0; i< k; i++)
            p = p.next;
        left = p;
        for (int i = k; i < h; i++) {
            p = p.next;
        }
        right = p;
        p = head;
        if (left == head) {
            p = null;
        }
        else
            while (p.next != left)
                p = p.next;
        Node pre = null, next = null, cur = left;
        if (right.next != null)
            pre = right.next;
        else
            tail = cur;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        if (p != null) {
            p.next = cur;
        }
        else {
            head = cur;
        }
       
    }
}
