
public class Main {

    public static void main(String[] args) {
        
        int [] a = {7,5,8,2,6,1,4,3};
        BSTree t = new BSTree();
        t.insertMany(a);
        
        System.out.println("1. Test Breadth-first Traversal.");
        t.breadth(t.root);
        System.out.println();
        
        System.out.println("2. Test Simple balancing.");
        t.balance();
        t.breadth(t.root);
        System.out.println();
        
    }
    
}
