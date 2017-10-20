/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clicktoplay;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Danger extends Element{
    public static int speed = 0;
    int type;
    ArrayList<Block> blocks = new ArrayList<Block> ();
    ArrayList<Monster> creeps = new ArrayList<Monster> ();
    ArrayList<Upgrade> powers = new ArrayList<Upgrade> ();
    Color dirColor = Color.BLUE;
    public Danger (){
        super(800,0,800,600,0,0);
        setDx(speed);
        type = -1;
    }
    public int getType (){
        return type;
    }
    public static void setStaticSpeed (int x){
        speed = x;
    }
    public void setSpeed(int x){
        for (int i = 0; i < blocks.size(); i++){
            if (!(blocks.get(i) instanceof MovingBlock && blocks.get(i).getDy() == 0 )){
                blocks.get(i).setDx(speed);
            }
        }
        for (int i = 0; i < powers.size(); i++){
            powers.get(i).setDx(speed);
        }
    }
    public static int getSpeed (){
        return speed;
    }
    public void moveAndDraw(Graphics2D win){
        translate(speed,0);
    }
    public void createScene(Graphics2D win, int x){
        type = x;
        blocks = new ArrayList<Block>();
        creeps = new ArrayList<Monster>();
        powers = new ArrayList<Upgrade>();
        //basic        
        if(x == -1){
            Block floor = newBlock(0,520,800,60,speed,0);
        //upgrade levels
        }else if (x == -2){
            Block floor = floor();
            Upgrade u = newUpgrade(1);
            Block j1 = newBlock (450+800,470,50,50,speed,0);
            Block j2 = newBlock (550+800,420,50,50,speed,0);
            Block u1 = newBlock (750+800,0,50,470,speed,0);
        }else if (x == -3){
            Block floor = floor();
            Upgrade u = newUpgrade(2);
            Block j1 = newBlock (400+800,500,80,20,speed,0);
            Block j2 = newBlock (600+800,500,80,20,speed,0);
            Monster m1 = newMonster(450+800,j1,speed-1,0);
            Monster m2 = newMonster (650+800,j2,speed-1,0);
        }else if (x == -4){
            Block floor = floor();
            Upgrade u = newUpgrade(3);
            Block w1 = newBlock (350+800,150,50,370,speed,0);
            Block w2 = newBlock (720+800,150,50,200,speed,0);
            Block w3 = newBlock (500+800,300,50,220,speed,0);
            Block j1 = newBlock (770+800,150,30,370,speed,0);
        }else if (x == -5){
            Block floor = floor();
            Upgrade u = newUpgrade(4);
            Block w1 = newBlock (330+800,150,50,370,speed,0);
            Block w2 = newBlock (750+800,200,50,370,speed,0);
            Block j1 = newBlock (730+800,300,30,40,speed,0);
        //tester levels
        }else if (x == -10){
            Block floor = newBlock (800,520,800,60,speed, 0);
            Block jump1 = newBlock (1000,450,50,50,speed,0);
            Block jump2 = newBlock (930,360,50,50,speed,0);
            Block under = newBlock (1300,400,50,50,speed,0);
            Monster m1 = newMonster(1400, floor, speed - 1, 0);
        }else if (x == -9){
            Block f1 = newBlock(30,520,170,60,speed,0);
            Block f2 = newBlock (300,520,200,60,speed,0);
            Monster m1 = newMonster (50,f1,1,0);
        }else if (x == -11){
            Block floor = newBlock (0,520,800,60,speed, 0);
            Block jump1 = newBlock (130,450,50,50,speed,0);
            Block jump2 = newBlock (200,360,50,50,speed,0);
            Block under = newBlock (500,400,50,50,speed,0);
        }
        //actual levels
        else if (x == 0){ //double under s
            Block floor = newBlock(800,520,800,60,speed,0);
            Block under = newBlock(1000,400,200,50,speed,0);
            Block under2 = newBlock(1400,400,200,50,speed,0);
        }else if (x==1){ //movingBlock up to platform s
            Block floor = floor();
            blocks.add(new MovingBlock (400+800,420,60,50,speed,0,true,200,525));
            blocks.add(new MovingBlock (200+800,300,60,50,speed,0,true,200,525));
            blocks.add(new MovingBlock (30+800,210,60,50,speed,0,true,200,525));
            blocks.add(new MovingBlock (700+800,540,60,50,speed,0,true,200,525));
            Block w1 = newBlock(460+800,200,100,600,speed,0);
        }else if (x == 2){ //2 pits j
            Block f1 = newBlock (800,520,300,60,speed,0);
            Block f2 = newBlock (1200,520,300,60,speed,0);
        }else if (x == 3){ //stairs, jump to monster j (m)
            Block f1 = newBlock (800,520,300,60,speed,0);
            Block f2 = newBlock (1300,520,300,60,speed,0);
            Block j1 = newBlock (1050,470,50,50,speed,0);
            Block j2 = newBlock (1100,420,50,50,speed,0);
            Monster m1 = newMonster (1400,f2,speed - 1,0);
        }else if (x ==4){ //jump jump under j
            Block floor = newBlock (800,520,800,60,speed, 0);
            Block jump1 = newBlock (930,450,50,50,speed,0);
            Block jump2 = newBlock (1000,360,50,50,speed,0);
            Block under = newBlock (1300,400,50,50,speed,0);
        }else if (x == 5){ //2 monsters j (m)
            Block floor = floor();
            Monster m1 = newMonster(300+800,floor,speed-1,0);
            Monster m2 = newMonster(500+800,floor,speed-1,0);
            Block u1 = newBlock (400+800,480,50,50,speed,0);
        }else if (x == 6){//pit of monsters j
            Block floor = floor();
            Block j1 = newBlock (100+800,460,50,60,speed,0);
            Block j2 = newBlock (150+800,400,50,130,speed,0);
            Block j3 = newBlock (200+800,340,50,180,speed,0);
            Block j4 = newBlock (250+800,280,50,240,speed,0);
            Block j5 = newBlock (550+800,280,50,240,speed,0);
            Block j6 = newBlock (600+800,340,50,180,speed,0);
            Block j7 = newBlock (650+800,400,50,130,speed,0);
            Block j8 = newBlock (700+800,460,50,60,speed,0);
            Monster m1 = newMonster (400+800,floor,speed-1,0);
            Monster m2 = newMonster (500+800,floor,speed-1,0);
            Monster m3 = newMonster (300+800,floor,speed-1,0);
         }else if (x==7){ //pillar hop j 
            Block f1 = newBlock (0+800,520,100,60,speed,0);
            Block w1 = newBlock (210+800,460,50,120,speed,0);
            Block w2 = newBlock (370+800,400,50,180,speed,0);
            Block w3 = newBlock (530+800,340,50,240,speed,0);
            Block f3 = newBlock (690+800,280,110,300,speed,0);
         }else if (x==8){//squeze land j
            Block f1 = floor();
            Block j1 = newBlock (100+800,460,180,60,speed,0);
            Block j2 = newBlock (280+800,400,180,120,speed,0);
            Block j3 = newBlock (460+800,340,180,180,speed,0);
            Block j4 = newBlock (620+800,400,180,120,speed,0);
            Block u1 = newBlock (160+800,360,60,50,speed,0);
            Block u2 = newBlock (340+800,300,60,50,speed,0);
            Block u3 = newBlock (520+800,240,280,50,speed,0);
            Block u4 = newBlock (710+800,0,90,350,speed,0);
            Block u5 = newBlock (100+800,200,620,50,speed,0);  
         }else if (x==9){ //j
            Block floor = floor();
            blocks.add(new MovingBlock (200+800,400,60,50,speed,0,true,200,525));
            Block w1 = newBlock (260+800,200,80,320,speed,0);
            blocks.add(new MovingBlock (640+800,200,60,50,speed,0,false,320,620,this));
            blocks.add(new MovingBlock (260+800,200,60,50,speed,0,false,320,620,this));
            Block w2 = newBlock(680+800,200,100,320,speed,0);
            Monster m1 = newMonster (300+800,floor,speed-1,0);
         }else if (x==10){ //monster land f
            Block floor = floor();
            Block j1 = newBlock (100+800,370,100,50,speed,0);
            Monster m1 = newMonster (100+800,floor,speed-1,0);
            Monster m2 = newMonster (120+800,floor,speed-1,0);
            Monster m3 = newMonster (200+800,floor,speed-1,0);
            Block j2 = newBlock (400+800,450,60,70,speed,0);
            Monster m4 = newMonster (500+800,floor,speed-1,0);
            Monster m5 = newMonster (600+800,floor,speed-1,0);
            Monster m6 = newMonster (700+800,floor,speed-1,0);
        }else if (x == 11){//twin towers c
            Block floor = floor();
            Block w1 = newBlock (200+800,140,50,380,speed,0);
            Block w2 = newBlock (400+800,140,50,380,speed,0);
        }else if (x==12){  //weird monster block jumpy c
            Block floor = floor();
            Block j1 = newBlock (400+800,470,120,50,speed,0);
            Block j2 = newBlock (640+800,400,80,50,speed,0);
            Block j3 = newBlock (100+800,400,220,100,speed,0);
            Monster m1 = newMonster (250+800,j3,speed-1,0);
            Block w2 = newBlock (680+800,290,50,230,speed,0);      
        }else if (x==13){ //extreme pillar hop c
            Block floor = floor();
            Block j1 = newBlock (100+800,470,50,50,speed,0);
            Block w1 = newBlock (300+800,330,50,200,speed,0);
            Block w2 = newBlock (500+800,210,50,310,speed,0);
            Block u1 = newBlock (550+800,0,70,170,speed,0);
            Monster m1 = newMonster (200+800,floor,speed-1,0);
            Monster m2 = newMonster (400+800,floor,speed-1,0);
            Monster m3 = newMonster (600+800,floor,speed-1,0);        
        }else if (x==14){ //jump to wall g
            Block j1 = newBlock (0+800,460,50,120,speed,0);
            Block j2 = newBlock (50+800,400,50,190,speed,0);
            Block j3 = newBlock (100+800,340,50,270,speed,0);
            Block j4 = newBlock (150+800,280,50,310,speed,0); 
            Block w1 = newBlock (700+800,300,100,320,speed,0);
        }
        else if (x==15){ //glide or die g
            Block f1 = newBlock (800,520,200,60,speed,0);
            Block w1 = newBlock (200+800,140,50,460,speed,0);
            Block p1 = newBlock (200+800,140,100,50,speed,0);
            Block w2 = newBlock (700+800,170,70,50,speed,0);  
        }    
    }
    public ArrayList<Block> getBlocks(){
        return blocks;
    }
    public ArrayList<Monster> getMonsters(){
        return creeps;
    }
    public ArrayList<Upgrade> getPowers(){
        return powers;
    }
    public Block floor (){
        return newBlock(800,520,800,60,speed,0);
    }
    public Block newBlock (int a, int b, int w, int h) {
        Block temp = new Block (a,b,w,h,speed,0);
        blocks.add(temp);
        return temp;
    }
    public Block newBlock (int a, int b, int w, int h, int xx, int yy) {
        Block temp = new Block (a,b,w,h,xx,yy);
        blocks.add(temp);
        return temp;
    }
    public Monster newMonster (int a, int b){
        Monster temp = new Monster (a,b);
        creeps.add(temp);
        return temp;
    }
    public Monster newMonster (int a, Block b){
        Monster temp = new Monster (a,b);
        creeps.add(temp);
        return temp;
    }
    public Monster newMonster (int a, int b, int y, int z){
        Monster temp = new Monster (a,b,y,z);
        creeps.add(temp);
        return temp;
    }
    public Monster newMonster (int a, Block b, int y, int z){
        Monster temp = new Monster (a,b,y,z);
        creeps.add(temp);
        return temp;
    }
    public Upgrade newUpgrade(int i){
        Upgrade temp = new Upgrade(i);
        powers.add(temp);
        return temp;
    }   
}
