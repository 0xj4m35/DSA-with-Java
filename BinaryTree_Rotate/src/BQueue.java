
import java.util.LinkedList;


public class BQueue {
    LinkedList<Node> t;

    public BQueue() {
        t = new LinkedList<>();
    }
    
    void clear() {
        t.clear();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void enQueue(Node p) {
        t.add(p);
    }
    
    Node deQueue() {
        if (isEmpty()) {
            return null;
        }
        return t.removeFirst();
    }
    
    Node front() {
        if (isEmpty()) {
            return null;
        }
        return t.getFirst();
    }
}
