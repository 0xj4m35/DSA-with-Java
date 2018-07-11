
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    
    public static void main(String[] args) {
   
        
        Map<String,String> m = new TreeMap();
        m.put("txt", "Text");
        m.put("doc", "Document");
        m.put("exe", "Executable");
        m.put("exe", "Excel");
        
        //output m
        Iterator<String> keys = m.keySet().iterator();
        while(keys.hasNext()) {
            String nextKey = keys.next();
            System.out.println(nextKey + ": " + m.get(nextKey));
        }
        
        //check if key "doc" exists
        if (m.containsKey("doc")) {
            System.out.println("doc.value = " + m.get("doc"));
        }
        else
            System.out.println("Key 'doc' does not exists.");
}
}
