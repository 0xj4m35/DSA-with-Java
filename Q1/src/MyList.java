/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList
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

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(Car x)
   {//You should write here appropriate statements to complete this function.
    Node q = new Node(x);
    if(isEmpty())
     head=tail=q;
     else
     {tail.next=q;
      tail=q;
     }
   }
  void addLast(String xOwner, int xRate, int xPrice)
   {//You should write here appropriate statements to complete this function.
       if(xOwner.charAt(0)=='A') 
           return;
        Car x = new Car(xOwner, xRate, xPrice);
        addLast(x);
   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(2);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void addFirst(Car x)
   {//You should write here appropriate statements to complete this function.
    if(x.owner.charAt(0)=='A') 
            return;
    Node q = new Node(x,head);
    if(isEmpty())
     head=tail=q;
     else
      head = q;
   }

  
  
  void f2() throws Exception
    {clear();
     loadData(6);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Car x, y;
     x = new Car("X",1,2);
     y = new Car("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        addFirst(x);
        addFirst(y);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  int size() {
        int k = 0;
        if (isEmpty())
            return k;
        Node i = head;
        while(i != null) {
            k++;
            i = i.next;
        }
        return k;
    }
  
  Node pos(int k) {
        if (k < 0 || k >= size())
            return null;
        int i = 0;
        Node p = head;
        while (i < k) {
            p = p.next;
            i++;
        }
        return p;
    }
  
  void dele(Node q) {
        if (q == null)
            return;
        if (q == head && q == tail) {
            head = tail = null;
            return;
        }
        if (q == head) {
            head = head.next;
            return;
        }
        Node i = head;
        while (i.next != q) {
            i = i.next;
        }
        if (q == tail) {
            tail = i;
            tail.next = null;
            return;
        }
        i.next = q.next;
    }
  
  void f3() throws Exception
   {clear();
    loadData(6);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Node temp = pos(2);
       if (temp != null) {
           dele(temp);
       }
       temp = pos(2);
       if (temp != null) {
           dele(temp);
       }

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  
  
  
  void f4() throws Exception
   {clear();
    loadData(10);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       Node left = head;
       Node right = pos(3);
       
       if (left != null && right != null) {
           Node i = left;
            while (i != right) {
                Node j = i.next;
                while(j != right.next) {
                    if (i.info.price > j.info.price) {
                        Car x = i.info;
                        i.info = j.info;
                        j.info = x;
                    }
                    j = j.next;
                }
                i = i.next;
            }
       }
        
       


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
