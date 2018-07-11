/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class NodeLend {
    Lending info;
    NodeLend next;

    public NodeLend(Lending info) {
        this.info = info;
        this.next = null;
    }

    public NodeLend(Lending info, NodeLend p) {
        this.info = info;
        this.next = p;
    }
    
    
}
