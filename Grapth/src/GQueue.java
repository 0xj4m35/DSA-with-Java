
import java.util.LinkedList;


public class GQueue {
    LinkedList<Integer> t;

    public GQueue() {
        t = new LinkedList<>();
    }
    
    void clear() {
        t.clear();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void enQueue(Integer x) {
        t.add(x);
    }
    
    Integer deQueue() {
        if (isEmpty()) {
            return null;
        }
        return t.removeFirst();
    }
    
    Integer front() {
        if (isEmpty()) {
            return null;
        }
        return t.getFirst();
    }
    
    
}
