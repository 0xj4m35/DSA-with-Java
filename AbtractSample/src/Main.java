
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public class Main {
    
    public static void main(String[] args) {
        
        Circle c = new Circle(1.2, "Red");   
        System.out.println("Color = " + c.getBgColor());
        System.out.println("Radius = " + c.getRadius());
        System.out.println("Area = " + c.getArea());
        
        // solution 1 
        double area = c.getArea();
        String pattern = "##.####";
        DecimalFormat df = new DecimalFormat(pattern);
        System.out.println("Area (##.####) = " + df.format(area));
        
        // solution 2
        pattern = "00.0000";
        df = new DecimalFormat(pattern);
        System.out.println("Area (00.0000) = " + df.format(area));
        
        //solution 3
        String rs = String.format("%.3f", area);
        System.out.println("Area = " + rs);
    }
}
