/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Thai Bao
 */
public abstract class Shape {
    
    //data
    private String bgColor;
    
    //method

    public Shape() {
    }

    public Shape(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
    
    public abstract double getArea();
}
