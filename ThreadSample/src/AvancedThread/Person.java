/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvancedThread;

/**
 *
 * @author Nguyen Thai Bao
 */
public class Person implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Person: Wow, big Dog, run run run ... ");
            for (int i = 10; i <= 100; i += 10) {
                System.out.println("Person: Run " + i + " so far.");
                if (i == 100) {
                    System.out.println("Person: Safe. STOP");
                }
                Thread.sleep(1000);
            }
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
