/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }

  void fvisitBal(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.bal+") ");
    }

  void fvisitLevel(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.level+") ");
    }

   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     MyQueue q = new MyQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }

  void breadthBal(Node  p, RandomAccessFile f) throws Exception
   {if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitBal(r,f);
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
   }

  void breadthLevel(Node  p, RandomAccessFile f) throws Exception
   {if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitLevel(r,f);
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
   }

   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("person.txt", k);
      int [] b = Lib.readLineToIntArray("person.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//===========================================================================
  Node search(Node p, Person ps) {
        if (p == null) {
            return null;
        }
        if (p.info == ps)
            return p;
        if (p.info.name.compareToIgnoreCase(ps.name) > 0) {
            return search(p.left, ps);
        }
        else 
            return search(p.right, ps);
    }
    
    void insert(Person ps) {
        if (isEmpty()) {
            root = new Node(ps);
            return;
        }
        Node f,p;
        f = null;
        p = root;
        while (p != null) {
            if(p.info.name.equalsIgnoreCase(ps.name)) {
                return;
            }
            f = p;
            if (p.info.name.compareToIgnoreCase(ps.name) > 0)
                p = p.left;
            else
                p = p.right;
        }
        Node q = new Node(ps);
        if (f.info.name.compareToIgnoreCase(ps.name) > 0)
            f.left = q;
        else
            f.right = q;
    }
   
   void insert(String xName, int xAge)
     {
         if (xName.charAt(0) == 'B') {
             return;
         }
         Person p = new Person(xName, xAge);
         insert(p);
     }

   int heightOfTree(Node p) {
       if (p == null)
            return 0;
	int hLeftSub = heightOfTree(p.left);
	int hRightSub = heightOfTree(p.right);
	return Math.max(hLeftSub, hRightSub) + 1;
   }
   
   int numberOfNode() {
       if (isEmpty()) {
           return 0;
       }
       MyQueue mq = new MyQueue();
        Node i;
        int k = 0;
        mq.enqueue(root);
        while(!mq.isEmpty()) {
            i = mq.dequeue();
            k++;
            if (i.left != null) {
                mq.enqueue(i.left);
            }
            if (i.right != null) {
                mq.enqueue(i.right);
            }
        }
        return k;
   }
   
   void deleByCopying() {
        Node f,p;
        f = null;
        p = root;
        
        
        // p is a Leave-Node
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            }
            else {
                if (f.left == p) {
                    f.left = null;
                }
                else {
                    f.right = null;
                }
            }
            return;
        }
        
        // P has left son only
        if (p.left != null && p.right == null) {
            if (f==null) {
                // p == root
                root = root.left;
            }
            else {
                if (f.left == p) {
                    f.left = p.left;
                }
                else {
                    f.right = p.left;
                }
            }
            return;
        }
        
        // P has right son only
        if (p.left == null && p.right != null) {
            if (f==null) {
                // p == root
                root = root.right;
            }
            else {
                if (f.left == p) {
                    f.left = p.right;
                }
                else {
                    f.right = p.right;
                }
            }
            return;
        }
        
        // P has 2 child
        if (p.left != null && p.right != null) {
            // find the right-most node on the left sub-tree
            Node q = p.left;
            Node frp = null, rp = q;
            while (rp != null && rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right most-node...
            // Replace data in P and rp
            p.info = rp.info;
            // Dele rp;
            if (frp == null) {
                // rp  = q;
                p.left = q.left;
            }
            else {
                frp.right = rp.left;
            }
        }
    }
   
   Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return  p;
         
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
   
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     inOrder(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  
  
//===============================================================
  void f2() throws Exception
    {clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     BSTree h = new BSTree();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if (!isEmpty()) {
            MyQueue mq = new MyQueue();
            Node i;
            mq.enqueue(root);
            while(!mq.isEmpty()) {
                i = mq.dequeue();
                if (i.info.age > 4) {
                    h.insert(i.info);
                }
                if (i.left != null) {
                    mq.enqueue(i.left);
                }
                if (i.right != null) {
                    mq.enqueue(i.right);
                }
            }
            
        }

    //-------------------------------------------------------------------------------------
     h.preOrder(h.root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f3() throws Exception
    {clear();
     loadData(5);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     int k = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     k = heightOfTree(root);
    //-------------------------------------------------------------------------------------
     f123.writeBytes(" k = " + k + "\r\n");
     f123.close();
    }  

//===============================================================
  void f4() throws Exception
    {clear();
     loadData(5);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     int k = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     
     k = numberOfNode();
    //-------------------------------------------------------------------------------------
     f123.writeBytes(" k = " + k + "\r\n");
     f123.close();
    }  

//===============================================================
  void f5() throws Exception
    {clear();
     loadData(5);
     String fname = "f5.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     deleByCopying();
    //-------------------------------------------------------------------------------------
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f6() throws Exception
    {clear();
     loadData(5);
     String fname = "f6.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        root = rotateRight(root);
    //-------------------------------------------------------------------------------------
     breadth(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f7() throws Exception
    {clear();
     loadData(5);
     String fname = "f7.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        if (!isEmpty()) {
            MyQueue mq = new MyQueue();
            Node p;
            int csRight, csLeft; 
            mq.enqueue(root);
            while(!mq.isEmpty()) {
                p = mq.dequeue();
                   
                if (p.left == null) {
                    csLeft = 0;
                }
                else {
                    csLeft = heightOfTree(p.left);
                    mq.enqueue(p.left);
                }
                
                if (p.right == null) {
                    csRight = 0;
                }
                else {
                    csRight = heightOfTree(p.right);
                    mq.enqueue(p.right);
                }
//                if (p.left != null) {
//                    mq.enqueue(p.left);
//                }
//                if (p.right !=  null)  {
//                    mq.enqueue(p.right);
//                }
                p.bal = csRight - csLeft;
                fvisitBal(p, f123);
                
            }
        }
    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f8() throws Exception
    {clear();
     loadData(5);
     String fname = "f8.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

if (!isEmpty()) {
            MyQueue mq = new MyQueue();
            Node p;
            root.level = 1;
            mq.enqueue(root);
            while(!mq.isEmpty()) {
                p = mq.dequeue();
                
                if (p.left != null) {
                    mq.enqueue(p.left);
                    p.left.level = p.level + 1;
                }
                if (p.right !=  null)  {
                    mq.enqueue(p.right);
                    p.right.level = p.level +1;
                }
                
                
                fvisitLevel(p, f123);
                
            }
        }
    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void inOrder(ArrayList<Person> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }
  
  void balance(ArrayList<Person> t, int k, int h) {
        if (k > h) {
            return;
        }
        int i = (k + h) / 2;
        Person x = t.get(i);
        insert(x);
        balance(t, k, i-1);
        balance(t, i+1, h);
    }
    
    void balance() {
        ArrayList<Person> t = new ArrayList<Person>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n-1);
    }
  
  void f9() throws Exception
    {clear();
     loadData(5);
     String fname = "f9.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     
     balance();
     breadth(root, f123);
    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

 }
