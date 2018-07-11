/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

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
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(Car x)
   {Node q=new Node(x);
     if(isEmpty())
      {root=q;
        return;
       }
     Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.price == x.price)
          {
            return;
          }
         f=p;
         if(x.price < p.info.price) p=p.left; else p=p.right;
       } 
      if(x.price < f.info.price ) f.left=q; else f.right=q;
   }
   
   void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function
         if (xOwner.charAt(0) == 'B' || xPrice > 100) {
             return;
         }
         insert(new Car(xOwner, xPrice));
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
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
  void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
         if (p.info.price >= 3 && p.info.price <= 5) {
             fvisit(p,f);
         }
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }
  
  void f2() throws Exception
    {clear();
     loadData(4);
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

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
  void deleByCopy(int price)
   {Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.price == price) break;
         f=p;
         if(price < p.info.price) p=p.left; else p=p.right;
       }
      if(p==null) return; // not found
      
//      // p is leaf node
//      if(p.left==null && p.right==null)
//        {if(f==null) // p=root
//           {root=null;
//           }
//           else
//            {if(p==f.left) f.left=null; f.right=null;
//             }
//          return;
//        } 
//
//      // p has left child only
//      if(p.left!=null && p.right==null)
//        {if(f==null) // p=root
//           {root=p.left;
//           }
//           else
//            {if(p==f.left) f.left=p.left; f.right=p.left;
//             }
//          return;
//        } 
//
//      // p has right child only
//      if(p.left==null && p.right!=null)
//        {if(f==null) // p=root
//           {root=p.right;
//           }
//           else
//            {if(p==f.left) f.left=p.right; f.right=p.right;
//             }
//          return;
//        } 

      // p has both 2 children
      if(p.left!=null && p.right!=null)
        {// find the right most node
          Node q=p.left;
          Node frp, rp; frp=null;rp=q;
          while(rp.right!=null) {frp=rp;rp=rp.right;}
          // rp is the right most node on the left child
          p.info=rp.info;
          if(frp==null) // rp=q
           {p.left=q.left;
           }
           else
           {
            frp.right=rp.left; 
           }
        }

   }
  
  void f3() throws Exception
    {clear();
     loadData(7);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        BQueue queue = new BQueue();
        Node p = root;
        queue.enqueue(p);
        while(!queue.isEmpty()) {
            p = queue.dequeue();
            if (p.left != null && p.right != null && p.info.price < 7) {
                break;
            }
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
        }
            if (p.left != null && p.right != null && p.info.price < 7) {
                deleByCopy(p.info.price);
            }
    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  Node rotateToRight(Node p)
  {if(p==null || p.left==null) return(p);
    Node q=p.left;
    p.left=q.right;
    q.right=p;
    return(q);
  }
  
  Node father(Node p) {
      Node f = null, q = root;
      if (p == root) {
          return f;
      }
      while (true) {
          f = q;
          if (p.info.price < q.info.price) {
              q = q.left;
          }
          else 
              q = q.right;
          if (q == p) {
              return f;
          }
      }
      
  }
  
  void f4() throws Exception
    {clear();
     loadData(10);
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


BQueue queue = new BQueue();
        Node p = root;
        queue.enqueue(p);
        while(!queue.isEmpty()) {
            p = queue.dequeue();
            if (p.left != null && p.info.price < 7) {
                break;
            }
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
        }
        
        if (p.left != null && p.info.price < 7) {
            Node fath = father(p);
            Node r = rotateToRight(p);
            if (fath == null) {
                root = r;
            }
            else {
                if (fath.left == p) {
                    fath.left = r;
                }
                else
                    fath.right = r;
            }
        }
        
    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
