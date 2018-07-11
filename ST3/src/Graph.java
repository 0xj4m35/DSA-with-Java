/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
class Graph
 {int [][] a; int n;
  char v[];
  int deg[];
  Graph()
    {v = "ABCDEFGHIJKLMNOP".toCharArray();
     deg = new int[20];
     a = new int[20][20];
     n = 0;
    }

  void loadData(int k)  //do not edit this function
   {RandomAccessFile f;int i,j,x;
    String s;StringTokenizer t;
    a = new int[20][20];
    try {
     f = new RandomAccessFile("graph.txt","r");
     for(i=0;i<k;i++) f.readLine();
     s = f.readLine();s = s.trim();
     n = Integer.parseInt(s);
     for(i=0;i<n;i++)
       {s = f.readLine();s = s.trim();
        t = new StringTokenizer(s);
        for(j=0;j<n;j++) 
          {x = Integer.parseInt(t.nextToken().trim());
           a[i][j] = x;
          }
       }
     f.close();
     }
    catch(Exception e) {}

   }

  void fvisit(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]);
   }

  void fvisitDeg(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]+"("+deg[i]+")");
   }

 void fdispAdj(RandomAccessFile f) throws Exception 
   {int i,j;
    f.writeBytes("n = "+n+"\r\n");
    for(i=0;i<n;i++)
     {f.writeBytes("\r\n");
      for(j=0;j<n;j++)  f.writeBytes("  " + a[i][j]);
     }
    f.writeBytes("\r\n");
   }

  void fbreadth(boolean [] en, int i, RandomAccessFile f) throws Exception
   {MyQueue q = new MyQueue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisit(r,f);
      for(j=0;j<n;j++)
       {if(!en[j] && a[r][j]>0) {q.enqueue(j);en[j]=true;}
       }
     }
   }

  void fbreadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    fbreadth(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) fbreadth(en,i,f);
   }

  void fdepth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) fdepth(visited,i,f);
      }
   }
  void fdepth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    fdepth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) fdepth(visited,i,f);

   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//=================================================================
  void breadth(boolean [] en, int i, RandomAccessFile f) throws Exception {
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true;
        int r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitDeg(r, f);
            for (int j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }
    
    void breadth(int k, RandomAccessFile f) throws Exception  {
        boolean [] en = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    deg[i]++;
                }
            }
            if (a[i][i] > 0) {
                deg[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (int i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }
  
  void f1() throws Exception
   {loadData(10);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fbreadth(0,f123);// fbreadth first traverse from the vertex 0 (A)
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     
       breadth(0, f123);
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void depth(boolean [] vis, int i, RandomAccessFile f) throws Exception {
        fvisitDeg(i, f);
        vis[i] = true;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j, f);
            }
        }
    }
    
    
    void depth(int k, RandomAccessFile f) throws Exception {
        boolean [] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    deg[i]++;
                }
            }
            if (a[i][i] > 0) {
                deg[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k, f);
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                breadth(vis, i, f);
            }
        }
    }
  
  void f2() throws Exception
   {loadData(10);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdepth(0,f123);// fdepth first traverse from the vertex 0 (A)
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       depth(0, f123);
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void connectBF(boolean [] en, int i) {
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true;
        int r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            for (int j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }
    
    int connecBF(int k) {
        int count = 1;
        boolean [] en = new boolean[n];
        for (int i = 0; i < n; i++) {
            en[i] = false;
        }
        connectBF(en, k);
        for (int i = 0; i < n; i++) {
            if (!en[i]) {
                connectBF(en, i);
                count ++;
            }
        }
        return count;
    }
  
  void f3() throws Exception
   {loadData(21);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdispAdj(f123);
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     f123.writeBytes(" k = " + connecBF(0) + "\r\n");
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void dijkstra(int fro, int to, RandomAccessFile f) throws IOException {
        boolean [] s = new boolean[n];
        int [] d = new int[n];
        int [] p = new int[n];
        int t, k;
        for (int i = 0; i < n; i++) {
            s[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        int INF = 99;
        while(true) {
            // find the minimum special distance in unselected vertices
            t  = INF;
            k = -1;
            for (int i = 0; i < n; i++) {
                if (s[i]) {
                    continue;
                }
                if (d[i] < t) {
                    t = d[i];
                    k = i;
                }
            }
            
            if (k == -1) {
                return; // No solution.
            }
            
            // d[k] = min;
            // select k to s
            
            s[k] = true;
            if (k == to) {
                break;
            }
            
            // Update special distances and path
            for (int i = 0; i < n; i++) {
                if (s[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    p[i] = k;
                    d[i] = d[k] + a[k][i];
                }
            }
            
        }
        
        MyStack st = new MyStack();
        int i = to;
        while(true) {
            st.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        
        i = st.pop();
        f.writeBytes("\r\n");
        f.writeBytes(v[i] + "");
        int pre = i;
        while(!st.isEmpty()){
            i = st.pop();
            f.writeBytes(" -> (" + a[pre][i] + ")" + v[i]);
            pre = i;
        }
        System.out.println();
    }
  
  void f4() throws Exception
   {loadData(33);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       dijkstra(0, 5, f123);
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
void checkEulerCycle(RandomAccessFile  f123)
 {
     
 }

  void f5() throws Exception
   {//You do not need to edit this file
    //Your task is to complete the checkEulerCycle(...) function above only
    loadData(42);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 

    checkEulerCycle(f123);
    loadData(49); 
    f123.writeBytes("\r\n");
    checkEulerCycle(f123);

    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void eulerCycle(int k, RandomAccessFile f) throws IOException {
        int [] eu = new int[100];
        int m = 0;
        MyStack s = new MyStack();
        s.push(k);
        int r, i;
        while(!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) {
                // r is isolated
                s.pop();
                eu[m++] = r;        
            }
            else {
                s.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        
        
        for (int j = 0; j < m; j++) {
            f.writeBytes(v[eu[j]] + " ");
        }
    }
  
  void f6() throws Exception
   {loadData(42);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       eulerCycle(0, f123);
    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

}
//=================================================================
