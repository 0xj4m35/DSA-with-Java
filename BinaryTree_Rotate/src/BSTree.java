
public class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }
    
    void clear() {
        root = null;
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    Node search(Node p, int value) {
        if (p == null) {
            return null;
        }
        if (p.value == value)
            return p;
        if (p.value < value) {
            return search(p.left, value);
        }
        else 
            return search(p.right, value);
    }
    
    void insert(int value) {
        if (isEmpty()) {
            root = new Node(value);
            return;
        }
        Node f,p;
        f = null;
        p = root;
        while (p != null) {
            if(p.value == value) {
                System.out.println("The Value " + value + " is already exist."); 
                return;
            }
            f = p;
            if (value < p.value)
                p = p.left;
            else
                p = p.right;
        }
        Node q = new Node(value);
        if (value < f.value)
            f.left = q;
        else
            f.right = q;
    }
    
    void insertMany(int [] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
    
    void visit(Node p) {
        if (p != null) {
            System.out.print(p.value + " ");
        }
    }
    
    void breadth(Node p) {
        if (p == null) {
            return;
        }
        BQueue q = new BQueue();
        q.enQueue(p);
        Node r;
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
    
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void depth(Node p) {
        if (p == null) {
            return;
        }
        Node x;
        BStack st = new BStack();
        st.enStack(p);
        while (!st.isEmpty()) {
            x = st.deStack();
            visit(x);
            if (x.right != null) {
                st.enStack(x.right);
            }
            if (x.left != null) {
                st.enStack(x.left);
            }
        }
    }
    
    void deleByCopying(int x) {
        Node f,p;
        f = null;
        p = root;
        while ( p!= null ) {
            if (p.value == x) {
                break;
            }
            f = p;
            if (x < p.value) {
                p = p.left;
            }
            else {
                p = p.right;
            }
        }
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
            Node q = p.left;
            Node frp = null, rp = q;
            while (rp != null && rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right most-node...
            // Replace data in P and rp
            p.value = rp.value;
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
    
    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return  p;
         
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
    
    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return  p;
         
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }
}
