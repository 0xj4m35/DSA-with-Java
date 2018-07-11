


public class Main {
    
    public static void main(String[] args) {
        
        /*
        *   Output Filename
        */

        String s1 = "D:/data/picture/anhdep.png";
        int i = s1.lastIndexOf("/");
        String s2 = s1.substring(i + 1);
        System.out.println("count = " + s2);
        
        
        /*
        *   count number of string "is"
        */
        
        s1 = "this is a cat";
        s2 = "is";
        int d = 0;
        i=-1;
//        while(true){
//            i = s1.indexOf(s2, i+1);
//            if (i != -1) {
//                d++;
//            } else 
//                break;
//        }
        while((i  = s1.indexOf(s2, i+1)) != -1) 
            d++;
        System.out.println(d);
        
        
        /*
        *   Count Words
        */
        
        s1 = "this is the cat, innt it?";
        String [] st = s1.split("\\s+");
//        for (String s : st) {
//            System.out.println(s);
//        }
        for (int j = 0; j < st.length; j++) {
            System.out.println(st[j]);
        }
        System.out.println(st.length);
        
    } 
}
