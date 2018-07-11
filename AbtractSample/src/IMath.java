/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public interface IMath {
    
    public final String BYZERO = "Divided by 0";           
    public int add(int x, int y);
    public int div(int x, int y);
}



class MyMath implements IMath {

    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public int div(int x, int y) {
        if (y==0){
            System.out.println(BYZERO);
            return 0;
        }
        return x/y;
    }
    
    
}
