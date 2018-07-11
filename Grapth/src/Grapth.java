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
    
    void breadth(boolean [] en, int i) {
        GQueue q = new GQueue();
        q.enQueue(i);
        en[i] = true;
        int r;
        while (!q.isEmpty()) {
            r = q.deQueue();
            visit(r);
            for (int j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enQueue(j);
                    en[j] = true;
                }
            }
        }
    }
    
    void breadth(int k) {
        boolean [] en = new boolean[n];
        for (int i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);
        for (int i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i);
            }
        }
    }
    
    void depth(boolean [] vis, int i) {
        visit(i);
        vis[i] = true;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j);
            }
        }
    }
    
    
    void depth(int k) {
        boolean [] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k);
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                breadth(vis, i);
            }
        }
    }
}
