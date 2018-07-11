
public class Main {
    
    public static void main(String[] args) {
        MyList t = new MyList();
        String [] a = {"Hoa","La","Canh","Cay","Goc","Re"};
        int [] b = {22,21,19,18,23,25};
        t.addMany(a,b);
        t.traverse(); 
        
//        t.addToHead(new Person("Bao", 20));
//        t.traverse(); 

//        Node test = t.head;
//        t.addAfter(test, new Person("Add After", 50));
//        t.traverse();

//        t.deleteFromHead();
//        t.traverse();

//        t.deleteFromTail();
//        t.traverse();

//        Node test2 = t.head;
//        t.deleteAfter(test2);
//        t.traverse();

//        t.dele(new Person("Re", 25));
//        t.traverse();

//        System.out.println(t.search(new Person("Goc", 23)).info);

//        System.out.println(t.count());

//        t.dele(t.count()-2);
//        t.traverse();

        t.sort();
        t.traverse();
        
    }
    
}
