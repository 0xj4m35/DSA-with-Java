/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] b = {
            {0,7,9,99,99,14},
            {7,0,10,15,99,99},
            {9,10,0,11,99,2},
            {99,15,11,0,6,99},
            {99,99,99,6,0,9},
            {14,99,2,99,9,0}
        };
        
        Grapth g = new Grapth();
        g.setData(b);
        g.display();
        System.out.println();
        System.out.println("1. Test Dijkstra.");
        g.dijkstra(0,4);
        System.out.println();
       
    }
    
}
