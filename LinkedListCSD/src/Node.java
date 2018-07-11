
public class Node {
    Person info;
    Node next;

    public Node(Person x, Node p) {
        info = x;
        next = p;
    }
    
    Node(Person x) {
        info = x;
        next = null;
    }
    
    
}
