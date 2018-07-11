
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyCopy {
    
    void copy(String file, String folder) {
        File f1 = new File(file);
        File f2 = new File(folder);
        
        if (f1.isFile() && f1.exists() && f2.isDirectory() && f2.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(folder + "/" + f1.getName());
                int b;
                while(fis.available() != 0) {
                    b = fis.read();
                    fos.write(b);
                }
                fis.close();
                fos.close();
                System.out.println("One file copied to " + folder);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("Given file or folder is invalid... ");
        }
    }
    
    public static void main(String[] args) {
        new MyCopy().copy("C:/Users/dell/Pictures/Saved Pictures/1.jpeg", "C:/Users/dell/Pictures/Screenshots");
    }
}
