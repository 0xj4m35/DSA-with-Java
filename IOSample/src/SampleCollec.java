
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SampleCollec {
    
    Map<String, String> m = new HashMap();
        
    void create(){
        try {
            RandomAccessFile raf = new RandomAccessFile("dictionary.txt", "rw");
            raf.writeBytes("house=Ngôi nhà");
            raf.writeBytes("\r\nstudent=Sinh viên");
            raf.writeBytes("\r\ncar=Ô tô");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null){
                String [] st = s.split("=");
                m.put(st[0], st[1]);
            }
            raf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void output() {
        Iterator<String> keys = m.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + " = " + m.get(key));
        }
    }
    
    public static void main(String[] args) {
        
        SampleCollec md = new SampleCollec();
        md.create();
        md.output();
    }
}
