/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class NodeReader {
    
    Reader info;
    NodeReader next;

    public NodeReader(Reader info) {
        this.info = info;
        this.next = null;
    }

    public NodeReader(Reader info, NodeReader p) {
        this.info = info;
        this.next = p;
    }
    
    
    
}
