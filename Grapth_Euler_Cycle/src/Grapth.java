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
    
    int deg (int i) {
        int s = 0;
        for (int j = 0; j < n; j++) {
            s += a[i][j];
        }
        if (a[i][i] > 0) {
            s += a[i][i];
        }
        return s;
    }
    
    boolean hasIsolated() {
        for (int i = 0; i < n; i++) {
            if (deg(i) == 0) {
                return true;
            }
        }
        return false;
    }
    
    boolean isConnected() {
        GStack s = new GStack();
        boolean [] p = new boolean[n];
        for (int i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(0);
        int r;
        while(!s.isEmpty()) {
            r = s.pop();
            for (int i = 0; i < n; i++) {
                if (!p[i] && a[r][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!p[i]) {
                return false;
            }
        }
        return true;
    }
    
    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i)%2 == 1) {
                return false;
            }
        }
        return true;
    }
    
    boolean isUnDirected() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean hasEulerCycle() {
        assert(!hasIsolated());
        if (isConnected() && isUnDirected() && allDegEven()) {
            return true;
        }
        return false;
    }
    
    void eulerCycle(int k) {
        if (!hasEulerCycle()) {
            System.out.println("The conditions are not satisfied.");
            return;
        }
        int [] eu = new int[100];
        int m = 0;
        GStack s = new GStack();
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
        System.out.println("The Euler Cycle is : ");
        System.out.print(v[eu[0]]);
        for (int j = 1; j < m; j++) {
            System.out.print(" -> " + v[eu[j]]);
        }
    }
}
