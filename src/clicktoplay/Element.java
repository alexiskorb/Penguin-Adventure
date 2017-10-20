package clicktoplay;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Element extends Rectangle{
    public int dx, dy;
    public Element (int x, int y, int width, int height){
        super (x,y,width,height);
        dx = 0;
        dy = 0;
    }
    public Element(int x, int y, int width,int height, int dxX, int dyY) {
        super(x,y,width,height);
        dx = dxX;
        dy = dyY;
    }
    public void moveAndDraw(Graphics2D win) {
        this.translate(dx, dy);
        win.fill(this);     
    }
    public void move (Graphics2D win){
        this.translate (dx,dy);
    }
    public void moveAndDraw(Graphics2D win, boolean noLeft, boolean noRight){
        if (!(noRight && dx > 0) && !(noLeft && dx <0)){
            moveAndDraw(win);
        }
    }
    public void move (Graphics2D win, boolean noLeft, boolean noRight){
        if (!(noRight && dx > 0) && !(noLeft && dx <0)){
            move(win);
        }
    }
    public int myX() {
        return (int)this.getX();
    }
    public int myY(){
        return (int)this.getY();
    }
    public void setDy(int value) {
        dy = value;
    }
    public void setDx(int value) {
        dx = value;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }
    public int getHt (){
        return (int)getHeight();
    }
    public int getWd(){
        return (int)getWidth();
    }
    
}

