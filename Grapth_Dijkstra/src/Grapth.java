/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class Grapth {
    
    int [][] a;
    int n;
    char [] v;

    public Grapth() {
        v = "ABCDEFGHIJKMN".toCharArray();
    }
    
    void setData(int [][] b) {
        n = b.length;
        int i, j;
        a = new int [n][n];
        for (i = 0; i < n; i++) {
            for ( j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
        
       
    }
    
    void display() {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
            System.out.println();
        }
    }
    
    void visit(int i) {
        System.out.print(v[i] + " ");
    }
    
    void dijkstra(int fro, int to) {
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
                System.out.println("No solution.");
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
        System.out.println("The shortest distance from " + fro + " to " + to + " is " + d[to]);
        
        GStack st = new GStack();
        int i = to;
        while(true) {
            st.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
        System.out.println();
        i = st.pop();
        System.out.print(i);
        while(!st.isEmpty()){
            i = st.pop();
            System.out.print(" -> " + i);
        }
        System.out.println();
    }
    
    
}
