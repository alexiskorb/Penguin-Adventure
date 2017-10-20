package clicktoplay;

import java.awt.Graphics2D;

public class Monster extends Element{
    public static int gSpeed = -1;
    public static final int HEIGHT = 50;
    public static final int WIDTH = 50;
    public Monster (int x, int y){
        super(x,y,WIDTH,HEIGHT);
    }
    public Monster (int x, int y, int spX, int spY){
        super(x,y,WIDTH,HEIGHT,spX,spY);
    }
    public Monster (int x, Block b){ 
        super(x,b.myY()-HEIGHT,WIDTH,HEIGHT);
    }
    public Monster (int x, Block b, int spX, int spY){
        super(x,b.myY()-HEIGHT,WIDTH,HEIGHT,spX,spY);
    }
    public static int getSpeed (){
        return gSpeed;
    }
    public static void setSpeed (int i){
        gSpeed = i;
    }
    public void moveAndDraw(Graphics2D win, boolean noLeft, boolean noRight){
        if (noLeft && getDx() < gSpeed){
            setDx(gSpeed + 1);
        }
        if (noRight && getDx() > gSpeed){
            setDx(gSpeed - 1);
        }
        super.moveAndDraw(win);
    }
    public void move (Graphics2D win, boolean noLeft, boolean noRight){
        if (noLeft && getDx() < gSpeed){
            setDx(gSpeed + 1);
        }
        if (noRight && getDx() > gSpeed){
            setDx(gSpeed - 1);
        }
        super.move(win);
    }
}
