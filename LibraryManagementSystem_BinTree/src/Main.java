
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
    public static void main(String[] args) throws IOException, Exception {
        
        BSTreeBook bstb = new BSTreeBook();
        ListReader lr = new ListReader();
        ListLending ll = new ListLending();
        Scanner sc = new Scanner(System.in);
        int choice; 
        boolean exit = false;
        System.out.println("\t\tLIBRARY MANAGEMENT SYSTEM\n");
        System.out.println("11.      Load data from file.");
        System.out.println("12.      Input & insert data.");
        System.out.println("13.      In-order traverse.");
        System.out.println("14.      Breadth-first traverse.");
        System.out.println("15.      In-order traverse to file.");
        System.out.println("16.      Search by bcode.");
        System.out.println("17.      Delete by bcode by copying.");
        System.out.println("18.      Simply balancing.");
        System.out.println("19.      Count number of books.");
        
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
                    bstb.loadFile("Book.txt");
                    System.out.println("Loaded Data.");
                    break;
                }
                case 12: {
                    bstb.inputAndAdd();
                    break;
                }
                case 13: {
                    bstb.root.info.column();
                    bstb.inOrder(bstb.root);
                    break;
                }
                case 14: {
                    bstb.breadth(bstb.root);
                    break;
                }
                case 15: {
                    bstb.writeFile("Book.txt");
                    break;
                }
                case 16: {
                    System.out.print("Enter Book Code: ");
                    String xCode = sc.nextLine();
                    NodeBook temp = bstb.searchBCode(xCode);
                    if (temp != null) {
                        temp.info.column();
                        System.out.println(temp.info.writeF());
                    }
                    else {
                        System.out.println("The Book Code is not exist.");
                    }
                    break;
                }
                case 17: {
                    System.out.print("Enter Book Code: ");
                    String xCode = sc.nextLine();
                    bstb.deleByCopying(xCode);
                    break;
                }
                case 18: {
                    bstb.balance();
                    break;
                }
                case 19: {
                    int k = bstb.numberOfNodeBook();
                    System.out.println("Book : " + k);
                    break;
                }
                case 110: {
                    bstb.loadFile("Book.txt");
                    bstb.root.info.column();
                    bstb.inOrder(bstb.root);
                    break;
                }
                case 111 : {
                    NodeBook temp = bstb.searchBCode("4");
                    if (temp != null) {
                        temp.info.title = "X";
                        
                    }
                    bstb.breadth(bstb.root);
                    break;
                }
                case 112: {
                    bstb.deleByCopying("3");
                    bstb.breadth(bstb.root);
                    break;
                }
                case 113: {
                    bstb.loadFile("Book.txt");
                    NodeBook cp = bstb.searchBCode("3");
                    bstb.balance(cp);
                    bstb.breadth(bstb.root);
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
                    NodeBook nb = bstb.searchBCode(bcode);
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
                    t.breadthBook();
                    System.out.println("");
                    System.out.println("");
                    t.inOrderBook();
                    t.traverseReader();
                    t.lend("B9", "C1");
                    t.lend("B2", "C1");
                    t.lend("B2", "C2");
                    t.lend("B4", "C2");
                    t.breadthBook();
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
