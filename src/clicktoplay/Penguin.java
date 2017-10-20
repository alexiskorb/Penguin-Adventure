package clicktoplay;

import java.util.ArrayList;

public class Penguin extends Element{ 
    int state = 0;
    int speed = 2;
    boolean pressed = false;
    int jumpDelay = 12;
    int timer2 = 0;
    public static final int HEIGHT = 90;
    public static final int WIDTH = 60;
    public Penguin() {
        super(340,430 , WIDTH, HEIGHT, 0, 0);
    }
      public void setState (int i){
        state = i;
    }
    public int getState (){
        return state;
    }  
       
}
