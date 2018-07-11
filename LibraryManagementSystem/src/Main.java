
import java.io.IOException;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ListBook lb = new ListBook();
        ListReader lr = new ListReader();
        ListLending ll = new ListLending();
        Scanner sc = new Scanner(System.in);
        int choice; 
        boolean exit = false;
        System.out.println("\t\tLIBRARY MANAGEMENT SYSTEM\n");
        System.out.println("11.      Load data from file.");
        System.out.println("12.      Input & add to the end.");
        System.out.println("13.      Display data.");
        System.out.println("14.      Save book list to file.");
        System.out.println("15.      Search by bcode.");
        System.out.println("16.      Delete by bcode.");
        System.out.println("17.      Sort by bcode.");
        System.out.println("18.      Input & add to beginning.");
        System.out.println("19.      Add after position  k.");
        System.out.println("110.     Delete position k.");
        System.out.println("111.     Search and Edit.");
        System.out.println("112.     Sort by quantity.");
        System.out.println("113.     Sort by Price.");
        System.out.println("114.     Delete by Name.");
        System.out.println("21.      Load data from file.");
        System.out.println("22.      Input & add to the end.");
        System.out.println("23.      Display data.");
        System.out.println("24.      Save reader list to file.");
        System.out.println("25.      Search by rcode.");
        System.out.println("26.      Delete by rcode.");
        System.out.println("31.      Input Lending data.");
        System.out.println("32.      Display Lending data.");
        System.out.println("33.      Sort by bcode + rcode.");
        System.out.println("0.       Exit program.");
        System.out.println();
        while(!exit) {
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println("");
            switch(choice) {
                case 11: {
                    lb.loadFile("Book.txt");
                    System.out.println("Loaded Data.");
                    break;
                }
                case 12: {
                    lb.inputAndAddToEnd();
                    break;
                }
                case 13: {
                    lb.display();
                    break;
                }
                case 14: {
                    lb.writeFile("Book.txt");
                    System.out.println("Saved Data.");
                    break;
                }
                case 15: {
                    System.out.print("Enter Book Code: ");
                    String xCode = sc.nextLine();
                    NodeBook p = lb.searchCode(xCode);
                    if (p == null) {
                        System.out.println("Not Found.");
                    }
                    else {
                        p.info.show();
                    }
                    break;
                }
                case 16: {
                    System.out.print("Enter Book Code: ");
                    String xCode = sc.nextLine();
                    lb.deleteByCode(xCode);
                    break;
                }
                case 17: {
                    lb.sortByCode();
                    break;
                }
                case 18: {
                    lb.inputAndAddToBegin();
                    break;
                }
                case 19: {
                    String bcode, title;
                    int lended, quantity, k;
                    double price;
                    while(true) {
                        System.out.print("Enter Book Code: ");
                        bcode = sc.nextLine();
                        System.out.print("Enter the Title: ");
                        title = sc.nextLine();
                        System.out.print("Enter the Quantity: ");
                        quantity = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter the Lended: ");
                        lended = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter the Price: ");
                        price = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter the Position: ");
                        k = Integer.parseInt(sc.nextLine());
                        if (lb.isSuit(bcode) && lb.isSuit(quantity, lended)) {
                            lb.addAfter(new Book(bcode, title, quantity, lended, price), k);
                            break;
                        }
                        else {
                            System.out.println("Invalid Code or Quantity and Lended");
                        }
                    }
                    System.out.println();
                    break;
                }
                case 110: {
                    System.out.print("Enter the Position: ");
                    int k = Integer.parseInt(sc.nextLine());
                    lb.delePos(k);
                    break;
                }
                case 111: {
                    System.out.print("Enter Code: ");
                    String xCode = sc.nextLine();
                    NodeBook se = lb.searchCode(xCode);
                    if (se == null) {
                        System.out.println("Code not found.");
                        break;
                    }
                    else {
                        System.out.print("Enter Edit Name: ");
                        String xxName = sc.nextLine();
                        se.info.title = xxName;
                    }
                    lb.display();
                    break;
                }
                case 112: {
                    lb.sortByQuantity();
                    lb.display();
                    break;
                }
                case 113 : {
                    lb.sortByPrice();
                    lb.display();
                    break;
                }
                case 114: {
                    System.out.print("Enter name : ");
                    String xName = sc.nextLine();
                    lb.deleteByName(xName);
                    lb.display();
                    
                    break;
                }
                case 21: {
                    lr.loadFile("Reader.txt");
                    System.out.println("Loaded data.");
                    break;
                }
                case 22: {
                    lr.inputAndAddToEnd();
                    System.out.println("Added.");
                    break;
                }
                case 23: {
                    lr.display();
                    break;
                }
                case 24: {
                    lr.writeFile("Reader.txt");
                    System.out.println("Saved Data.");
                    break;
                }
                case 25: {
                    System.out.print("Enter Reader Code:");
                    String xCode = sc.nextLine();
                    NodeReader p = lr.searchCode(xCode);      
                    if (p == null) {
                        System.out.println("Not Found.");
                    }
                    else {
                        p.info.show();
                    }
                    break;
                }
                case 26: {
                    System.out.print("Enter Reader Code:");
                    String xCode = sc.nextLine();
                    NodeReader p = lr.searchCode(xCode); 
                    if (p == null) {
                        System.out.println("Error.");
                    }
                    else {
                        lr.deleNode(p);
                    }
                    break;
                }
                case 31: {
                    String bcode, rcode;
                    int state;
                    System.out.print("Enter Book Code: ");
                    bcode = sc.nextLine();
                    System.out.print("Enter Reader Code: ");
                    rcode = sc.nextLine();
                    System.out.print("Enter State: ");
                    state = Integer.parseInt(sc.nextLine());
                    NodeBook nb = lb.searchCode(bcode);
                    NodeReader nr = lr.searchCode(rcode);
                    NodeLend nl = ll.searchByCode(bcode, rcode);
                    if ((nb == null) || (nr == null)) {
                        System.out.println("Book Code or Reader Code not found.");
                        break;
                    }
                    else {
                        if (nl != null) {
                            if (state == 1) {
                                System.out.println("You are lending this one. ");
                                break;
                            }
                            if (state == 0) {
                                if (nb.info.quantity > nb.info.lended) {
                                    nb.info.lended++;
                                    nl.info.state = 1;
                                    System.out.println("Now you can lend Book.");
                                    break;
                                }
                                else {
                                    System.out.println("No more Book for Lending.");
                                    break;
                                }
                            }
                            if (state == 2) {
                                nb.info.lended--;
                                ll.deleNode(nl);
                                System.out.println("Not lend Book anymore.");
                                break;
                            }                      
                        }
                        else {
                            if (nb.info.lended == nb.info.quantity) {
                                System.out.println("Because lended is equals quantity. New Lending item is added.");
                                ll.addLast(new Lending(bcode, rcode, 0));
                                break;
                            }
                            if (nb.info.lended < nb.info.quantity) {
                                nb.info.lended++;
                                System.out.println("New Lending item is added.");
                                ll.addLast(new Lending(bcode, rcode, 1));
                                break;
                            }
                        }  
                    }
                    
                    break;
                }
                case 32: {
                    ll.display();
                    break;
                }
                case 33: {
                    ll.sortByCode();
                    break;
                }
                case 34: {
                    ListLending t = new ListLending();
                    t.loadBook("Book.txt");
                    t.loadReader("Reader.txt");
                    t.traverseBook();
                    t.traverseReader();
                    t.lend("B5", "C1");
                    t.lend("B1", "C1");
                    t.lend("B1", "C2");
                    t.lend("B2", "C2");
                    t.traverseBook();
                    t.display();
                    break;
                }
                case 0: {
                    exit = true;
                    break;
                }
                
                default: 
                    exit = true;
            }
            sc.nextLine();
        }
    }
    
}
