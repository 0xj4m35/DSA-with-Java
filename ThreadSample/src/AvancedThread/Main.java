/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AvancedThread;

/**
 *
 * @author Nguyen Thai Bao
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Clock cl = new Clock();
        Person ps = new Person();
        Dog dog = new Dog();
        Thread clT = new Thread(cl);
        Thread psT = new Thread(ps);
        Thread dogT = new Thread(dog);
        boolean ok = false;
        clT.start();
        dogT.start();
        dogT.join();
        psT.start();
    }
}
