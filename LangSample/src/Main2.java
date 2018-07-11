/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */




public class Main2 {
    
    public static void main(String[] args) {
        
        String s = "the";
        StringBuffer sb = new StringBuffer(s);      //String => String Buffer
        sb.append(" quick"); // the quick
        sb.append(" fox");      // the quick fox
        int i = sb.indexOf("fox"); // 10
        sb.insert(i, "brown "); //the quick brown fox
        sb.setCharAt(0, 'T');   // The quick brown fox
        s = sb.toString();      // String Buffer => String
        System.out.println(s);
        sb.delete(0, "the".length());   // quick brown fox
        System.out.println(sb);
    }
}
