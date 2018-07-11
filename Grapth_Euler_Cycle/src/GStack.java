
import java.util.LinkedList;


public class GStack {
    LinkedList<Integer> t;

    public GStack() {
        t = new LinkedList<>();
    }
    
    void clear() {
        t.clear();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void push(Integer x) {
        t.add(x);
    }
    
    Integer pop() {
        if (isEmpty()) {
            return null;
        }
        return t.removeLast();
    }
    
    Integer top() {
        if (isEmpty()) {
            return null;
        }
        return t.getLast();
    }
    
    
}
