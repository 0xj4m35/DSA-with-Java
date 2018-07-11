/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvancedThread;

import java.util.Calendar;

/**
 *
 * @author Nguyen Thai Bao
 */
public class Clock implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Calendar now = Calendar.getInstance();
                int h = now.get(Calendar.HOUR);
                int m = now.get(Calendar.MINUTE);
                int s = now.get(Calendar.SECOND);
                System.out.println("Time: " + h + ":" + m + ":" + s );
                Thread.sleep(1000);
            } 
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
