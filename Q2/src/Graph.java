/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph
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
     f = new RandomAccessFile("data.txt","r");
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

  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
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

  void breadth(boolean [] visited, int k, RandomAccessFile f) throws Exception
   {GQueue q = new GQueue();
    int r,i;
    boolean [] enqueued = new boolean[20];
    for(i=0;i<n;i++) enqueued[i]=false;
    q.enqueue(k); enqueued[k]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      if(!visited[r]) {fvisit(r,f);visited[r] = true;}
      for(i=0;i<n;i++)
       {if(!visited[i] && !enqueued[i] && a[r][i]>0) {q.enqueue(i);enqueued[i]=true;}
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    breadth(visited,k,f);
    for(i=0;i<n;i++) if(!visited[i]) breadth(visited,i,f);
   }

  void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth(visited,i,f);
      }
   }
  void depth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);

   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  int count = 0;
  
  void depth2(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {visited[k]=true;
   count++;
       if (count <= 4) {
           fvisit(k,f);
       }
       
        for(int i=0;i<n;i++)
             {if(!visited[i] && a[k][i]>0) depth2(visited,i,f);
             }
       
   }
  void depth2(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
       
    for(i=0;i<n;i++) visited[i]=false;
    depth2(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth2(visited,i,f);

   }
  
  void f5() throws Exception
   {loadData(10);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    depth(0,f);
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       depth2(0, f);
    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

//=================================================================
  void dijkstra(int fro, int to, RandomAccessFile f) throws Exception
    {int i,j,k,t,INF;
      INF=999;
      boolean [] S = new boolean[n];
      int [] d = new int[n];
      int [] p = new int[n];
      for(i=0;i<n;i++)
        {S[i] = false;
          d[i] = a[fro][i];
          p[i] = fro;
        }

      int [] ss = new int[n]; // ss[0], ss[1], ss[2],... are vertices sequentially selected to S
      int [] pp = new int[n]; // ss[0] -> ss[1] -> ss[2],... is the shortest path
      int m, r; // m is number of vertices in S,
                    // r is the number of vertices in shortest path 
      j = 0;

      // select fro into the set S
      S[fro] = true; ss[0] = fro;
      while(true)
        {// find min d[i] in the set of those vertices not selected into S
          k = -1; t = INF;
          for(i=0;i<n;i++)
            {if(S[i]==true) continue;
              if(d[i] < t) {k = i; t = d[i];}
            }
           if(k==-1) return; // no solution
           // select k into the set S
           S[k] = true;
           j++;
           ss[j] = k;
           if(k==to) break;
           // Recalculate d[i]
           for(i=0;i<n;i++)
             {if(S[i] == true) continue;
               if(d[i] > d[k] + a[k][i])
                {d[i] = d[k] + a[k][i];
                  p[i] = k;
                }
             }
        }
       m = j;
      GStack s = new GStack();
      i = to;
      while(true)
        {s.push(i);
          if(i==fro) break;
          i = p[i];
        }
      j = 0;
      while(!s.isEmpty())
        {i = s.pop();
          pp[j++] = i;
         }
      r = j;
   f.writeBytes("" + d[pp[r-1]] + "\r\n");
   f.writeBytes(""+v[pp[0]]);
   for(i = 1;i<3;i++) 
       f.writeBytes("   " +v[pp[i]]);
   f.writeBytes("\r\n");
   f.writeBytes(""+d[pp[0]]);
   for(i = 1;i<3;i++) 
       f.writeBytes("   " +d[pp[i]]);
   f.writeBytes("\r\n");
 }
  
  void f6() throws Exception
   {loadData(21);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    int k123 = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

       dijkstra(1, 5, f);
    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

}
//=================================================================
