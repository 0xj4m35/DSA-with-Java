
public class Main {

    public static void main(String[] args) {
        
        int [] a = {7,5,8,3,6,2,4,1};
        BSTree t = new BSTree();
        t.insertMany(a);
        
        System.out.println("1. Test Breadth-first Traversal.");
        t.breadth(t.root);
        System.out.println();
        
        System.out.println("2. Test Rotate Right.");
        Node p = t.rotateRight(t.root);
        t.breadth(p);
        System.out.println();
        
        System.out.println("3. Test Rotate Left.");
        t.clear();
        t.insertMany(a);
        Node q = t.rotateLeft(t.root);
        t.breadth(q);
        System.out.println();
    }
    
}
