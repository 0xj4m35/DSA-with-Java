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
            {0,2,0,0},
            {2,0,1,1},
            {0,1,0,1},
            {0,1,1,0}
        };
        
        Grapth g = new Grapth();
        g.setData(b);
        g.display();
        System.out.println();
        System.out.println("1. Test Euler Cycle.");
        g.eulerCycle(1);
        System.out.println();
       
    }
    
}
