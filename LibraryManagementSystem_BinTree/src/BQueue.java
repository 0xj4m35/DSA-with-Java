
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class BQueue {
    LinkedList<NodeBook> t;

    public BQueue() {
        t = new LinkedList<>();
    }
    
    void clear() {
        t.clear();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void enQueue(NodeBook p) {
        t.add(p);
    }
    
    NodeBook deQueue() {
        if (isEmpty()) {
            return null;
        }
        return t.removeFirst();
    }
    
    NodeBook front() {
        if (isEmpty()) {
            return null;
        }
        return t.getFirst();
    }
}
