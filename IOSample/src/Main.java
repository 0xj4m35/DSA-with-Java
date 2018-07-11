
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class Main {
    
    static void textStream() {
        try{
            String path = "build.xml";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int c;
            while((c = br.read()) != -1){
                System.out.print((char)c);
            }
            br.close();
            fr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
   
        textStream();
        String path = "D:/data/img/1.bmp"; // good style
        path = "data.xml";
        
        File f = new File(path);
        if (f.exists()) {
            System.out.println("Name = " + f.getName());
            System.out.println("Parent = " + f.getParent());
            System.out.println("Full Path = " + f.getAbsolutePath());
            System.out.println("Size (in byte) = " + f.length());
            System.out.println("Last Modified  = " + new Date(f.lastModified()));
        }
        else {
            try {
                f.createNewFile();
                System.out.println("Press Enter to remove create one ... ");
                new Scanner(System.in).nextLine();
                f.delete();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
