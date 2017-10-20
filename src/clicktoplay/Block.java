/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktoplay;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author bhsjava
 */
public class Block extends Element{
    Element top, bot, rt, lt;
    int buffer = 4;
    public Block(){
        super(0,520,800,60,-1,0);
        top = new Element (buffer,520,800-2*buffer,1);
        bot = new Element (buffer,579,800-2*buffer,1);
        rt = new Element (799,520 + buffer,1,60-buffer*2);
        lt = new Element (0,520 + buffer,1,60-buffer*2);
    }
    public Block (int x, int y, int width, int height){
        super (x,y,width,height);
        top = new Element (x+buffer,y,width-buffer*2,1);
        bot = new Element (x+buffer,y+height-1 ,width-buffer*2,1);
        rt = new Element (x+width-1,y+buffer,1,height-buffer*2);
        lt = new Element (x,y+buffer,1,height-buffer*2);              
    }
    public Block (int x, int y, int width, int height, int a, int b){
        super (x,y,width,height,a,b);
        top = new Element (x+buffer,y,width-buffer*2,1);
        bot = new Element (x+buffer,y+height-1 ,width-buffer*2,1);
        rt = new Element (x+width-1,y+buffer,1,height-buffer*2);
        lt = new Element (x,y+buffer,1,height-buffer*2);              
    }
    public void translate (int i, int i1){
       super.translate(i,i1);
       top.translate(i,i1);
       bot.translate(i,i1);
       rt.translate(i,i1);
       lt.translate(i,i1);
    }
    public Element getTop(){
        return top;
    }
    public Element getBot (){
        return bot;
    }
    public Element getRt(){
        return rt;
    }
    public Element getLt(){
        return lt;
    }
}
