
import java.util.Scanner;


public class Main {
   
    public static void sum(Scanner in){ 
        // takes a sequence of integeres in input, and outputs their sum
	int s, nextInt;
	s = 0;
        boolean keepGoing = true;
	System.out.println("Please input the sequence of integers to sum, terminated by a 0");
        while (keepGoing){
            try {
                nextInt = Integer.parseInt(in.nextLine());
                s += nextInt;
                if(nextInt == 0){               
                    keepGoing = false;
                }    
            }
            catch (NumberFormatException e){
                System.out.println("Invalid number. Please reenter.");
            }
        }
        //Read next datum in input. An integer is expected
        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

        Scanner in = new Scanner(System.in);
       //"in" will receive data from the standard input stream
	String c; 
	System.out.println("Do you wish to calculate a sum? (y/n)");
	c = in.nextLine();
        //Read next datum in input. A string "y" or "n" is expected
	while (!c.equals("y") && !c.equals("n")) {
	    System.out.println("Please answer y or n");
	    c = in.nextLine();
	}
	while (c.equals("y")) {
	    sum(in);
	    System.out.println("Do you wish to calculate another sum? (y/n)");
	    c = in.nextLine();
	    while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		c = in.nextLine();
	    }
	}
	System.out.println("Goodbye");
    }
}
