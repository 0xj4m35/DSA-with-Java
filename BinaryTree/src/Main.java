
public class Main {

    public static void main(String[] args) {
        
        int [] a = {40,25,50,15,35,45,20,30};
        BSTree t = new BSTree();
        t.insertMany(a);
        
//        System.out.println("1. Test Breadth-first Traversal.");
//        t.breadth(t.root);
//        System.out.println();
//        
//        System.out.println("2. Test Pre-Order.");
//        t.preOrder(t.root);
//        System.out.println();
//        
//        System.out.println("3. Test In-Order.");
//        t.inOrder(t.root);
//        System.out.println();
//        
//        System.out.println("4. Test Post-Order.");
//        t.postOrder(t.root);
//        System.out.println();
//        
//        System.out.println("5. Test Depth-first Traversal.");
//        t.depth(t.root);
//        System.out.println();
        
        System.out.println("6. Test Delete By Copying.");
        t.deleByCopying(25);
        t.breadth(t.root);
        System.out.println();
    }
    
}
