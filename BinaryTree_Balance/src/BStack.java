
import java.util.LinkedList;


public class BStack {
    
    LinkedList<Node> t;

    public BStack() {
        t = new LinkedList<>();
    }
    
    void clear() {
        t.clear();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void enStack(Node p) {
        t.add(p);
    }
    
    Node deStack() {
        if (isEmpty()) {
            return null;
        }
        return t.removeLast();
    }
    
    Node front() {
        if (isEmpty()) {
            return null;
        }
        return t.getLast();
    }
}
