/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktoplay;

import java.awt.Graphics2D;

/**
 *
 * @author Alexis
 */
public class MovingBlock extends Block{
    int topLimit;
    int botLimit;
    int rightLimit;
    int leftLimit;
    int speed = 1;
    boolean upDown;
    Danger dang;
    public MovingBlock (int x, int y, int width, int height, int a, int b,boolean direction, int up, int down){
        super(x,y,width,height,a,b); 
        upDown = direction;
        if (upDown){
            setDy(-speed);
            topLimit = up;
            botLimit = down;
        }else{
            setDx(-2);
            leftLimit = up;
            rightLimit = down;
        }
    }
    public MovingBlock (int x, int y, int width, int height, int a, int b, 
      boolean direction, int left, int right, Danger d){
        super(x,y,width,height,a,b);
        upDown = direction;
        if (upDown){
            setDy(-speed);
            topLimit = left;
            botLimit = right;
        }else{
            setDx(-2);
            leftLimit = left;
            rightLimit = right;
        }
        dang = d;        
    }
    public void moveAndDraw(Graphics2D win){  
        if (upDown){
            if (myY() < topLimit){
                setDy(speed);
            }
            if (myY() > botLimit){
                setDy(-speed);
            }
        }else{
            if (myX() > rightLimit + dang.myX()){
                setDx(-2);
            }
            if (myX() < leftLimit + dang.myX()){
                setDx(0);
            }
        }
        super.moveAndDraw(win);
    }
    public boolean getUpDown(){
        return upDown;
    }
}
