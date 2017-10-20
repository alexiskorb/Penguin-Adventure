package clicktoplay;

import java.awt.Color;
import java.awt.Graphics2D;

public class MovingText {
    String text;
    int speed;
    int x;
    int y;
    public MovingText (String hi, int a, int b, int sp){
        text = hi;
        x = a;
        y = b;
        speed = sp;
    }
    public void moveAndDraw (Graphics2D win){
        x += speed;
        win.setColor (Color.BLUE);
        win.drawString (text,x,y);
    }
    
}
