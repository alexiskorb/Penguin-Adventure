/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktoplay;

import javax.swing.JFrame;

public class Clicktoplay {
    public static void main(String[] args) {
        JFrame j1 = new JFrame();
        j1.setTitle("Penguin Adventure");
        j1.setSize(800, 600);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        j1.add(new GameComp());        
        j1.setVisible(true);
    
    }
}
