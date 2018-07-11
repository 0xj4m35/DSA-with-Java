
import java.util.Scanner;


public class PasswordMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter user role: ");
        String role = in.nextLine();
        System.out.print("Enter user password: ");
        String value = in.nextLine();
        Password p = new Password(value, role);
        while(!p.isValid()) {
            System.out.print("Please enter a valid password: ");
            p.setValue(in.nextLine());
        }
        System.out.println("Thanks you, info of your account ");
        System.out.println("User role: " + p.getRole());
        System.out.println("User password: " + p.getValue());

    }

}
