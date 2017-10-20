/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktoplay;

/**
 *
 * @author Alexis
 */
public class Upgrade extends Element{
    int number;
    boolean used = false;
    public static int speed;
    public Upgrade (int x){
        super (1000,450,70,70,0,0);
        setDx(speed);
        number = x;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int i){
        number = i;
    }
    public static void setSpeed(int i){
        speed = i;
    }
    public void use (){
        used = true;
    }
    public boolean getUsed(){
        return used;
    }
}
