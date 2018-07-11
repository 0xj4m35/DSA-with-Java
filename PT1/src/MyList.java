/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadDataToLast(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

  void loadDataToFirst(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addFirst(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if (xName.charAt(0) == 'B') {
           return;
       }
        Node x = new Node(new Person(xName, xAge)) ;
       if (isEmpty()) {
           head = tail = x;
           return;
       }
       tail.next = x;
       tail = x;
   }

  void addFirst(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if (xName.charAt(0) == 'B') {
           return;
       }
       Node x = new Node(new Person(xName, xAge)) ;
       if (isEmpty()) {
           head = tail = x;
           return;
       }
       x.next = head;
       head = x;
   }
  
  void deleteFromHead() {
        if(isEmpty())
            return;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;
    }
    
    void deleteFromTail() {
        if (isEmpty())
            return;
        if (head.next == null) {
            tail = head = null;
            return;
        }
        Node p = head;
        while (p.next != tail)
            p = p.next;
        p.next = null;
        tail = p;
    }
  
  void deleteFirstNodeAge6() {
      if (isEmpty()) {
          return;
      }
      Node p = head;
      while (p != null){
          if (p.info.age < 6) {
              break;
          }
          p = p.next;
      }
      if (p != null) {
          if (p == head) {
              deleteFromHead();
              return;
          }
          if (p == tail) {
              deleteFromTail();
              return;
          }
          Node i = head;
          while (i.next != p) {
              i = i.next;
          }
          i.next = p.next;
      }
  }
  
  void sortAscByName() {
      if (isEmpty()) {
          return;
      }
      Node i = head;
      while (i.next != null) {
          Node j = i.next;
          while (j != null) {
              if (i.info.name.compareToIgnoreCase(j.info.name) > 0) {
                  Person x = i.info;
                  i.info = j.info;
                  j.info = x;
              }
              j = j.next;
          }
          i = i.next;
      }
  }

  void reverseList() {
      if (isEmpty()) {
          return;
      }
      Node pre = null, next = null, curr = head;
      while (curr != null) {
          next = curr.next;
          curr.next = pre;
          pre = curr;
          curr = next;
      }
      tail = head;
      head = pre;
      
  }
  
  int size() {
      if (isEmpty()) {
          return 0;
      }
      int k = 0;
      Node i = head;
      while (i!= null) {
          i = i.next;
          k++;
      }
      return k;
  }
  
  void removeAtPos3() {
      if (size() < 4) {
          return;
      }
      if (size() == 4) {
          deleteFromTail();
          return;
      }
      Node p = head, q = null;
      for (int i = 0; i < 3; i++) {
          q = p;
          p = p.next;
      }
      q.next = p.next;
  }
  
//=================================================================
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadDataToLast(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f2() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
     */
     clear();
     loadDataToFirst(1);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f3() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);

    MyList  h = new MyList();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       if (!isEmpty()) {
            Node p = head;
            while(p != null) {
                if (p.info.age > 4) {
                    h.addLast(p.info.name, p.info.age);
                }
                p = p.next;
            }
       }

    //-------------------------------------------------------------------------------------
    h.ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f4() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     deleteFirstNodeAge6();

    //-------------------------------------------------------------------------------------
     ftraverse(f123);
     f123.close();
   }

//=================================================================
  void f5() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     sortAscByName();

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }


//=================================================================
  void f6() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     reverseList();
    //--------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f7() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f7.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    MyList h = new MyList();
    h.loadDataToLast(7);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       if (!h.isEmpty()) {
            tail.next = h.head;
            tail = h.tail;
       }
     
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f8() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f8.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    int k = 3;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     removeAtPos3();
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f9() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f9.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    String xName = "C6";
    String yName = "CX";
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    
       if (!isEmpty()) {
           Node p =head;
           while(p!= null) {
               if (p.info.name.equalsIgnoreCase("C6")) {
                   p.info.name = "CX";
                   break;
               }
               p = p.next;
           }
       }
    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

 }
