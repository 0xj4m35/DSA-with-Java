
import java.util.Scanner;

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
    
    public static void main(String[] args) {
        
        boolean keepGoing = true;
        double mark = 0;
        Scanner sc = new Scanner(System.in);
        
        while(keepGoing){
            System.out.println("Enter student score: ");
            String s = sc.nextLine();
            try {
                mark = Double.parseDouble(s);
                if (mark < 0 || mark >10)
                    throw new Exception("Mark must be in range [0,10].");
                keepGoing = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Student score must be numeric.");
            } 
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you, your score is: " + mark);
    }
}
