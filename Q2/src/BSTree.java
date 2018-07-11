/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

//-------------------------------------------------------------------------------
public class BSTree
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
     BQueue q = new BQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
   void insert(Bus x)
    {Node q = new Node(x);
     if(root==null)
        {root = q;
         return; 
        }
     Node f,p;
     p=root;f=null;
     while(p!=null)
       {if(p.info.rate == x.rate) 
           return;
        if(x.rate < p.info.rate)
          {f=p;p=p.left;}
           else
            {f=p;p=p.right;}
       }
     if(x.rate < f.info.rate)
        f.left=q;
         else
           f.right=q;
     }
   
  void insert(String xDriver, int xRate, int xPrice)
     {//You should insert here statements to complete this function
         if (xDriver.charAt(0) == 'B') {
             return;
         }
         Bus x = new Bus(xDriver, xRate, xPrice);
         insert(x);

     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(2);
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
  
//=============================================================
  
  void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
         if (p.info.rate < 7) {
            fvisit(p,f);
         }
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }
  
  void f2() throws Exception
    {clear();
     loadData(6);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


        preOrder2(root, f);
    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  
  int dem = 0;
  Node suit = null;
  
  void preOrder3(Node p) 
     {if(p==null) return;
        dem++;
         if (dem == 3) {
            suit = p;
         }
      preOrder3(p.left);
      preOrder3(p.right);
     }
  
  void deleByCopy(int xRate)
   {if(root==null)
       {
        return;
       }
    Node f,p; // f will be the father of p
    p=root;f=null;
    while(p!=null)
     {if(p.info.rate == xRate) break;//Found key x
      if(xRate < p.info.rate)
        {f=p;p=p.left;}
        else
        {f=p;p=p.right;}
     }
    if(p==null)
     {
      return;
     }
    if(p.left==null && p.right==null) // p is a leaf node
     {if(f==null) // The tree is one node
       root=null; 
        else
        {if(f.left==p)
          f.left=null;
           else
            f.right=null;
        }
      return;
     }

    if(p.left!=null && p.right==null) // p has only left child
     {if(f==null) // p is a root
       root=p.left; 
        else
        {if(f.left==p) // p is a left child
           f.left=p.left;
            else 
             f.right=p.left;
        }
      return;
     }

    if(p.left==null && p.right!=null) // p has only right child
     {if(f==null) // p is a root
       root=p.right; 
        else
        {if(f.left==p) // p is aleft child
           f.left=p.right;
            else 
             f.right=p.right;
        }
      return;
     }

    if(p.left!=null && p.right!=null) // p has both left and right children
     {Node q,fr,rp; // p's key will be replaced by rp's one
      fr=null;
      q = p.left;
      rp = q;
      while(rp.right!=null) 
       {fr=rp; rp = rp.right; // Find the right most node on the left sub-tree
       }
      p.info = rp.info;
      if(fr==null) // rp is just a left son of p 
      p.left=rp.left;
       else
        fr.right=rp.left;
     }
   
   }
  
  void f3() throws Exception
    {clear();
     loadData(6);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder3(root);
        if (suit != null) {
            deleByCopy(suit.info.rate);
        }

    //------------------------------------------------------------------------------------
     preOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  
  Node findMax(Node r) {
      Node i = r;
      while (i.right != null) {
          i = i.right;
      }
      return i;
  }
  
  Node findNode6() {
      Node i = root;
      while (i != null) {
          if (i.info.rate == 6) {
              return i;
          }
          if (6 < i.info.rate) {
              i = i.left;
          }
          else
              i = i.right;
          
      }
      return null;
      
  }
  
  void f4() throws Exception
    {clear();
     loadData(6);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node r = findNode6();
        if (r != null) {
            Node i = findMax(r);
            if (i != null) {
                i.info.price = 100;
            }
        }

    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
