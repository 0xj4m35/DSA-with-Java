/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class NodeBook {
    
    Book info;
    NodeBook next;
    
    public NodeBook(Book info) {
        this.info = info;
        this.next = null;
    }

    public NodeBook(Book info, NodeBook p) {
        this.info = info;
        this.next = p;
    }
    
    
}
