
public class Node {

    Person info;
    Node next;

    Node() {
        info = null;
        next = null;
    }

    Node(Person x, Node q) {
        info = x;
        next = q;
    }

    Node(Person x) {
        this(x, null);
    }
}
