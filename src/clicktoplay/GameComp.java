package clicktoplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameComp extends GameDriver{
    final int GAME_SPEED = -1;
    int gameState = 1; //Important for testing = should be 1
    int pengState = 0;
    int pengSpeed = 3;
    int life = 5;
    int nextD = -1;
    int level = 2;
    int modLevel = 2;
    int difficultyMod = 0;
    int jumpDelay = 12;
    int deathDelay = 120;
    int deathTimer = 0;
    int timer = 0;
    int climbDelay = 10;
    int gameSp;   
    int score = 0;
    int totalScore = 0;
    int stage = 0; //important for testing = should be 0
    int lev1 = 1;
    int lev2 = 4;
    int lev3 = 8;
    int lev4 = 11;
    int lastDanger = 0;     //important for testing = should be 0
    int almostLastDanger = 0;
    int currentMonsterSize = 0;
    int sceneNumber = 0;
    boolean hitByMonster = false;
    boolean hasPower = false;
    boolean upgradeUsed = false;
    boolean isUpgrading = false;
    boolean startDanger = false;
    Danger currentDanger = new Danger();
    Danger futureDanger = new Danger();
    boolean needDanger = true;
    boolean facedRight = true;
    boolean pressed = false;
    boolean isExpanded = true;
    boolean climbing = false;
    boolean gameOngoing = false;
    Rectangle background = new Rectangle(0,0,800,600);
    Penguin hero = new Penguin();
    ArrayList<Block> blocks = new ArrayList<Block>();
    ArrayList<Element> weapons = new ArrayList<Element>();
    ArrayList<Monster> creeps = new ArrayList<Monster>();
    ArrayList<Upgrade> powers = new ArrayList<Upgrade>();
    ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
    BufferedImage scene = addImage ("src\\clicktoplay\\CS Cool Background.jpg");
    BufferedImage heart = addImage("src\\clicktoplay\\CS Heart Transparent.gif");
    BufferedImage monster = addImage("src\\clicktoplay\\CS Monster Transparent2.png");
    BufferedImage loseHeart = addImage ("src\\clicktoplay\\CS Heart -1Life Transparent.png");
    BufferedImage trophy = addImage ("src\\clicktoplay\\CS Trophy2.png");
    BufferedImage trophy2 = addImage ("src\\clicktoplay\\CS TrophyUntouched.png");
    BufferedImage introScreen = addImage ("src\\clicktoplay\\CS Intro Screen.gif");
    BufferedImage tipsScreen = addImage("src\\clicktoplay\\CS TipsScreen2.gif");
    BufferedImage instructPic = addImage ("src\\clicktoplay\\CS Instructions.gif");
    BufferedImage fireRight = addImage ("src\\clicktoplay\\CS Firebreath2.png");
    BufferedImage fireLeft = addImage ("src\\clicktoplay\\CS Firebreath2 Left.png");
    BufferedImage fireUpgrade = addImage("src\\clicktoplay\\CompSci FireUpgradeRules.jpg");
    BufferedImage jumpUpgrade = addImage("src\\clicktoplay\\CompSci JumpUpgradeRules.jpg");
    BufferedImage glideUpgrade = addImage("src\\clicktoplay\\CompSci GlideUpgradeRules.jpg");
    BufferedImage ninjaUpgrade = addImage("src\\clicktoplay\\CompSci NinjaUpgradeRules.jpg");
    BufferedImage deathScreen = addImage ("src\\clicktoplay\\CS Death Screen.jpg");
    BufferedImage pikachuBackground = addImage ("src\\clicktoplay\\CS Pikachu background.jpg");
    String[] str = {"src\\clicktoplay\\Indiana_Jones_Theme_Song_[HD_ (2).wav"};
    SoundDriver sound = new SoundDriver(str);
    Font gameFont = new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 30);
    Font scoreFont = new Font (Font.SANS_SERIF, Font.BOLD, 25);
    Font instructions = new Font (Font.SANS_SERIF, Font.ROMAN_BASELINE,15);
    int coins = 0;
    int pikachuCount = 0;
    boolean coinsAdded = false;
    boolean allSkillsUnlocked = false;
    boolean flightMode = false;
    boolean flightModeUnlocked = false;
    int unlockTimer = 60;
    BufferedImage pengR = addImage("src\\clicktoplay\\CS PengR.gif");
    BufferedImage currentSprite = pengR;
    BufferedImage pengL = addImage("src\\clicktoplay\\CS PengL.gif");
    BufferedImage pengRC = addImage("src\\clicktoplay\\CS PengRC.gif");
    BufferedImage pengLC = addImage("src\\clicktoplay\\CS PengLC.gif");
    BufferedImage pengJumpR = addImage("src\\clicktoplay\\CS PengJumpR.gif");
    BufferedImage pengJumpRC = addImage("src\\clicktoplay\\CS PengJumpRC.gif");
    BufferedImage pengJumpL = addImage("src\\clicktoplay\\CS PengJumpL.gif");
    BufferedImage pengJumpLC = addImage("src\\clicktoplay\\CS PengJumpLC.gif");
    BufferedImage pengFireR = addImage("src\\clicktoplay\\CS PengFireR.gif");
    BufferedImage pengFireL = addImage("src\\clicktoplay\\CS PengFireL.gif");
    BufferedImage pengFireRC = addImage("src\\clicktoplay\\CS PengFireRC.gif");
    BufferedImage pengFireLC = addImage("src\\clicktoplay\\CS PengFireLC.gif");
    BufferedImage pengNinjR = addImage("src\\clicktoplay\\CS PengNinjR.gif");
    BufferedImage pengNinjL = addImage("src\\clicktoplay\\CS PengNinjL.gif");
    BufferedImage pengNinjRC = addImage("src\\clicktoplay\\CS PengNinjRC.gif");
    BufferedImage pengNinjLC = addImage("src\\clicktoplay\\CS PengNinjLC.gif");
    BufferedImage pengNinjRU = addImage ("src\\clicktoplay\\CS PengNinjRU.gif");
    BufferedImage pengNinjLU = addImage ("src\\clicktoplay\\CS PengNinjLU.gif");
    BufferedImage pengNinjRCU = addImage ("src\\clicktoplay\\CS PengNinjRCU.gif");
    BufferedImage pengNinjLCU = addImage ("src\\clicktoplay\\CS PengNinjLCU.gif");
    BufferedImage pengFlyR = addImage("src\\clicktoplay\\CS PenguinFlyRt.gif");
    BufferedImage pengFlyL = addImage("src\\clicktoplay\\CS PenguinFlyL.gif");
    BufferedImage pengFlyRC = addImage("src\\clicktoplay\\CS PenguinFlyRtC.gif");
    BufferedImage pengFlyLC = addImage("src\\clicktoplay\\CS PenguinFlyLC.gif");
    int currentSpriteNum;
    int spriteDelay = 25;
    int tempSpriteNum = 0;
    int spriteWd = 60;
    int spriteHt = 90;
    public GameComp(){
        setGameSpeed(GAME_SPEED);
        sound.loop(0);        
    }
    public void setGameSpeed(int i){
        gameSp = i;
        Danger.setStaticSpeed(gameSp);
        Monster.setSpeed (gameSp);
        Upgrade.setSpeed(gameSp);
        currentDanger.setSpeed(gameSp);
        futureDanger.setSpeed(gameSp);
    }
    public void draw(Graphics2D win) {
        if(gameState == 1){
            splashScreen(win, keys);
        }else if (gameState == 2){
            gamePlay(win, keys);
        }else if (gameState == 3){
            gameOver(win, keys);
        }else if (gameState == 4) {
            instructPlay(win,keys);
        }else if (gameState == 5){
            tipsScreen (win,keys);
        }
    }    
    public void gamePlay(Graphics2D win, boolean[] keys){
        // paint the window white
        timer++;
        win.setColor(Color.WHITE);
        win.fill(background);
        if (!startDanger){
            currentDanger = new Danger();
            futureDanger = new Danger();
            currentDanger.createScene(win,-1);
            futureDanger.createScene(win,lastDanger);
            currentDanger.setRect(0,0,800,600);
            startDanger = true;
            updateDanger(win,currentDanger);
            updateDanger(win,futureDanger);
        }
        inputBackgroundImages(win);
        //create stage and monsters
        win.setColor (Color.BLACK);
        if (needDanger()){
            nextD = (int)(Math.random()*modLevel + difficultyMod);
            lastDanger = almostLastDanger;
            almostLastDanger = nextD;
            currentDanger = futureDanger;
            currentMonsterSize = currentDanger.getMonsters().size();
            if (upgradeTime()){
                if (stage == 0){
                    futureDanger = nextDanger(win, -2);
                    setLevel (10);
                }else if (stage == 1){
                    futureDanger = nextDanger (win, -3);
                    setLevel(11);
                }else if (stage == 2){
                    futureDanger = nextDanger (win, -4);
                    setLevel(14);
                }else if (stage >= 3){
                    futureDanger = nextDanger (win, -5);
                    setLevel(15);
                }
                isUpgrading = true;
            }else{
                futureDanger = nextDanger(win,nextD);
                score++;
                totalScore += 10;
                isUpgrading = false;
            }
            updateDanger(win,futureDanger);
        }
        if (!upgradeUsed && upgradeCentered()){
            setGameSpeed(0);
        }else{
            setGameSpeed(GAME_SPEED);
        }       
        getUpgrade();
        //moves and draws stage and elements
        currentDanger.moveAndDraw(win);
        futureDanger.moveAndDraw(win);
        for (int k = 0; k < blocks.size(); k++){
            win.setColor(Color.BLACK);
            blocks.get(k).moveAndDraw(win);
        }
        for (int k = 0; k < creeps.size(); k++){
            win.setColor(Color.GREEN);
            creeps.get(k).move(win,!canMoveLt(creeps.get(k)),!canMoveRt(creeps.get(k)));
            win.drawImage (monster,null,creeps.get(k).myX(), creeps.get(k).myY());
        }
        for (int k = 0; k < powers.size(); k++){
            win.setColor (Color.YELLOW);
            powers.get(k).move(win);
            if (powers.get(k).getUsed()){
                win.drawImage(trophy,null,powers.get(k).myX(),powers.get(k).myY()-25);
            }else{
                win.drawImage(trophy2,null,powers.get(k).myX(),powers.get(k).myY()-25);
            }
        }
        //update special powers
        updatePengState();
        win.setColor(Color.BLACK);
        win.setFont (scoreFont);
        drawHearts(win);
        win.drawString("Score = " + totalScore,10,80);
        //win.drawString("State = " + pengState, 100,140);        
        //win.drawString("Stage = " + stage, 100,160);
        //Basic movement and special actions
        action (keys,win, hero);            
        //climb action
        if (canMoveLt(hero) && canMoveRt(hero)){
            climbing = false;
        }
        if (climbing){
            if (keys[12]){
                 hero.setDy (-pengSpeed);
            }else if (keys[13]){
                 hero.setDy (pengSpeed);
            }else{
                 hero.setDy(0);
            }
        }
        //Makes blocks impassable
        if (!canMoveDown(hero) && hero.getDy() > 0){
            hero.setDy(0);
        }
        movingBlockUpDown();
        if (!canMoveUp(hero) && hero.getDy() < 0){
            hero.setDy(0);
        }
        if (!canMoveRt(hero) && hero.getDx() > gameSp){
            hero.setDx(gameSp);
        }
        if (!canMoveLt(hero) && hero.getDx() < gameSp){
            hero.setDx(gameSp);
        }
        //gravity
        if (timer%jumpDelay == 0 && gravityApplies()){
            hero.setDy(hero.getDy()+1);
        }    
        for (int i = 0; i < creeps.size(); i++){
            Monster m1 = creeps.get(i);
            if (timer%jumpDelay == 0 && gravityAppliesMonster(m1)){
                m1.setDy(m1.getDy()+1);
            }
        }
        //draw and move hero
        win.setColor(Color.BLUE);
        hero.move(win);
        inputHeroImages(win);
        flying(flightMode);
        //kill monsters and extras
        for (int i = 0; i < weapons.size(); i++){
            for (int k = 0; k < creeps.size(); k++){
                if(weapons.get(i).intersects(creeps.get(k))){
                    creeps.remove(k);
                    k--;
                    totalScore += 5;
                }
            }
        }
        for (int i = 0; i < creeps.size(); i++){
            if(creeps.get(i).myY() > 600){
                creeps.remove(i);
                i--;

            }
        }
        deleteExtras();       
        //hits monsters      
        for (int i = 0; i < creeps.size() && deathTimer == 0; i++){
            if (hero.intersects(creeps.get(i))){
                life--;
                hitByMonster = true;
            }
        }
        if (hitByMonster){
            if (deathTimer > deathDelay){
                deathTimer = 0;
                hitByMonster = false;
            }else{
                deathTimer++;
                win.drawImage (loseHeart,null,hero.myX()-5,hero.myY()-60);
            }
        }
        //pikachu background
        if (keys[20]){ 
            pikachuCount++;
            if (pikachuCount < 100){
                win.drawImage(pikachuBackground,null,0,0);
            }
        }        
        if (pikachuCount > 150){
            pikachuCount = 0;
        }
        //game over
        if(hero.myY() > 800){
            life--;
            redoLevel();
        }
        if((hero.myX()) < 0){
            life--;
            redoLevel();
        }
        if (life <= 0 ){
            gameState = 3;
        }        
    }
    public void updatePengState (){
        if(keys[16]){//q
            setPengState(0); //squeeze
        }else if(keys[0] && stage > 0){//w 
            setPengState(1); //jump
        }else if (keys[17] && stage > 1){//e
            setPengState(2); //fire
        }else if (keys[1] && stage > 2){ //s
            setPengState(4); //ninja wall climb
        }else if (keys[2] && stage > 3){//a
            setPengState(3);//glide
        }
    } 
    public void drawHearts(Graphics2D win){
        if (life > 0)
            win.drawImage(heart,null,0,0);
        if (life > 1)
            win.drawImage(heart,null,50,0);
        if (life > 2)
            win.drawImage (heart,null,100,0);
        if (life > 3)
            win.drawImage (heart,null,150,0);
        if (life > 4)
            win.drawImage (heart,null,200,0);     
    }    
    public void action(boolean[] keys, Graphics2D win, Penguin p) {
        //slower jump speed
        if (gravityApplies()){
            pengSpeed = 2;
        }else{
            pengSpeed = 3; 
        }
        //Movement left/right
        if(keys[14]) { //move left
            p.setDx(-pengSpeed);
            facedRight = false;
        }else if (keys[15]) { //move right
            p.setDx(pengSpeed);
            facedRight = true;
        }else {
            p.setDx(0);
        }        
        //space bar
        if (keys[11]){
            if (pengState == 0){ //squeeze
                if (!pressed && isExpanded){
                    p.setRect(p.myX(),p.myY() + Penguin.HEIGHT/2,Penguin.WIDTH,Penguin.HEIGHT/2);
                    isExpanded = false;
                }
            }else if (pengState == 1) { //jump
                if (!pressed && canJump()){
                    p.setDy(-4);
                    
                }
            }else if (pengState == 2){ //fire
               weapons.clear();
               Element fire; 
               if (facedRight){
                   if (isExpanded){
                        fire = new Element(p.myX() + p.getWd(), p.myY() + 10, 80,75);
                        win.drawImage(fireRight,null,p.myX() + p.getWd(), p.myY()+10);
                   }else{
                       fire = new Element (p.myX() + p.getWd(), p.myY()-25,80,75);
                       win.drawImage (fireRight,null,p.myX()+p.getWd(),p.myY()-25);
                   }
               }else{
                   if (isExpanded){
                       fire = new Element (p.myX() - 80, p.myY() + 10, 80, 75);
                       win.drawImage (fireLeft,null,p.myX()-80,p.myY()+10);
                   }else{
                       fire = new Element (p.myX()-80,p.myY()-25,80,75);
                       win.drawImage (fireLeft,null,p.myX()-80,p.myY()-25);
                   }
               }    
               weapons.add(fire);
               win.setColor(Color.RED);
               fire.move(win);    
            }else if (pengState == 3 && canGlide()){ //gliding
                if (timer%4 == 0){
                    p.setDy(0);
                }else{                    
                    p.setDy(1);
                }
            }else if (pengState == 4){ //climbing
                climbing = true;
            }
            pressed = true;
        //no space bar    
        }else{
           if (canExpand() && !isExpanded){ //return to original height
                p.setRect(p.myX(),p.myY() - p.getHt(),Penguin.WIDTH,Penguin.HEIGHT); 
                isExpanded = true;
            }
           climbing = false;
           pressed = false;
           weapons.clear();
        }        
        //Start again after getting power
        if (hasPower && keys[10]){
            upgradeUsed = true;
            hasPower = false;
        }
    }
    public void inputHeroImages (Graphics2D win){
        if (pengState == 0){
            currentSpriteNum = 15;
            spriteWd = 60;
            spriteHt = 90;
            if (isExpanded){
                if (facedRight){
                     currentSprite = pengR;
                }else{   
                     currentSprite = pengL;
                }
            }else {
                if (facedRight){   
                     currentSprite = pengRC;
                }else{
                     currentSprite = pengLC;
                }
            }
        }else if (pengState == 1){
            currentSpriteNum = 15;
            spriteWd = 60;
            spriteHt = 110;
            if (isExpanded){
                if (facedRight){
                     currentSprite = pengJumpR;
                }else{   
                     currentSprite = pengJumpL;
                }
            }else {
                if (facedRight){   
                     currentSprite = pengJumpRC;
                }else{
                     currentSprite = pengJumpLC;
                }
            }
        }else if (pengState == 2){
            currentSpriteNum = 15;
            spriteWd = 60;
            spriteHt = 90;
            if (isExpanded){
                if (facedRight){
                     currentSprite = pengFireR;
                }else{   
                     currentSprite = pengFireL;
                }
            }else {
                if (facedRight){   
                     currentSprite = pengFireRC;
                }else{
                     currentSprite = pengFireLC;
                }
            }
        }else if (pengState == 4){ //climb
            currentSpriteNum = 15;
            spriteWd = 60;
            spriteHt = 90;
            if (isExpanded){
                if (facedRight){
                     currentSprite = pengNinjR;
                }else{   
                     currentSprite = pengNinjL;
                }
            }else {
                if (facedRight){   
                     currentSprite = pengNinjRC;
                }else{
                     currentSprite = pengNinjLC;
                }
            }
        }else if (pengState == 3){ //glide
            currentSpriteNum = 15;
            spriteWd = 96;
            spriteHt = 90;
            if (isExpanded){
                if (facedRight){
                     currentSprite = pengFlyR;
                }else{   
                     currentSprite = pengFlyL;
                }
            }else {
                if (facedRight){   
                     currentSprite = pengFlyRC;
                }else{
                     currentSprite = pengFlyLC;
                }
            }
        }
        if (climbing){
            currentSpriteNum = 15;
            spriteWd = 60;
            spriteHt = 90;
            if (isExpanded){
                if (facedRight){
                     currentSprite = pengNinjRU;
                }else{   
                     currentSprite = pengNinjLU;
                }
            }else {
                if (facedRight){   
                     currentSprite = pengNinjRCU;
                }else{
                     currentSprite = pengNinjLCU;
                }
            } 
        }
        if (timer%spriteDelay == 0){
            tempSpriteNum++;
        }    
        if (tempSpriteNum > currentSpriteNum){
            tempSpriteNum = 0;
        }
        drawSpriteSheet(win,currentSprite,tempSpriteNum,spriteWd,spriteHt);
    }
    public void drawSpriteSheet (Graphics2D win, BufferedImage img, int num, int width,int height){
        int over = (width - 60)/2;
        int tall = height - 90;
        BufferedImage temp = img.getSubimage(width*num,0,width,img.getHeight());
        win.drawImage (temp,null,hero.myX()-over, hero.myY()-tall);
    }
    public void inputBackgroundImages (Graphics2D win){
        BufferedImage back = scene.getSubimage(sceneNumber,0,800,600);
        win.drawImage (back,null,0,0);
        if (sceneNumber >= 4600){
            sceneNumber = 0;
        }else{
            sceneNumber++;
        }
        if (pikachuCount >= 100 && pikachuCount <= 150){
            win.drawImage (pikachuBackground,null,0,0);
        }
        int temp = futureDanger.getType();
        int temp2 = currentDanger.getType();
        if (temp == -2){
            win.drawImage(jumpUpgrade,null,futureDanger.myX(), futureDanger.myY());
        }else if (temp == -3){
            win.drawImage (fireUpgrade,null,futureDanger.myX(), futureDanger.myY());
        }else if (temp == -4){
            win.drawImage (ninjaUpgrade, null, futureDanger.myX(), futureDanger.myY());
        }else if (temp == - 5){
            win.drawImage (glideUpgrade, null, futureDanger.myX(), futureDanger.myY());
        }
        if (temp2 == -2){
            win.drawImage(jumpUpgrade,null,currentDanger.myX(), currentDanger.myY());
        }else if (temp2 == -3){
            win.drawImage (fireUpgrade,null,currentDanger.myX(), currentDanger.myY());
        }else if (temp2 == -4){
            win.drawImage (ninjaUpgrade, null, currentDanger.myX(), currentDanger.myY());
        }else if (temp2 == - 5){
            win.drawImage (glideUpgrade, null, currentDanger.myX(), currentDanger.myY());
        }
        if (stage >= 1){
            win.setFont(instructions);
            win.setColor (Color.BLACK);
            win.drawString ("Q - Squeeze", 10, 100);
            win.drawString ("W - Jump", 10,120);
        }
        if (stage >= 2)
            win.drawString ("E - Fire",10,140);
        if (stage >= 3)
            win.drawString ("S - Ninja",10,160);
        if (stage >= 4)
            win.drawString ("A - Glide",10,180);
    }
    public void deleteExtras (){ 
        for (int i = 0; i < blocks.size(); i++){
            Block temp = blocks.get(i);
            if (temp.myX() + temp.getWd() < 0){
                blocks.remove(i);
                i--;
            }
        }
        for (int i = 0; i < creeps.size(); i++){
            Monster temp = creeps.get(i);
            if ((temp.myX() + 50) < 0){
                creeps.remove(i);
                i--;
            }
        }
        for (int i = 0; i < powers.size(); i++){
            Upgrade temp = powers.get(i);
            if (temp.myX() + temp.getWd() < 0){
                powers.remove(i);
                i--;
                upgradeUsed = false;
            }
        }
    }
    public void updateDanger(Graphics2D win, Danger d){
        ArrayList<Block> dBlock = d.getBlocks();
        ArrayList<Monster> dMonster = d.getMonsters();
        ArrayList<Upgrade> dPowers = d.getPowers();
        for (int i = 0; i < dBlock.size(); i++){
            blocks.add(dBlock.get(i));
        }
        for (int i = 0; i < dMonster.size(); i++){
            creeps.add(dMonster.get(i));
        }
        for (int i = 0; i < dPowers.size(); i++){
            powers.add(dPowers.get(i));
            upgradeUsed = false;
        }
    }
    public Danger nextDanger(Graphics2D win,int x){
        Danger d = new Danger();
        d.createScene(win,x);
        return d;
    }  
    public boolean needDanger(){
        if (futureDanger.myX() == 0){
            return true;            
        }else{
            return false;
        }
    }   
    public boolean upgradeTime (){
        if (score == lev1 || score == lev2 || score == lev3 || score == lev4){
            if (!isUpgrading){
                return true;
            }
        }
        return false;
    }
    public void splashScreen(Graphics2D win, boolean[] keys){
        win.drawImage (introScreen, null, 0,0);
        if (keys[10]){ //enter
            gameState = 2;
            gameOngoing = true;
        }
        if (keys[23]){ //I
            gameState = 4;
        }
    }
    public void instructPlay (Graphics2D win, boolean[] keys){
        win.drawImage (instructPic,null,0,0);
        if (keys[11]){ //space
            gameState = 1;
        }
        if (keys[10]){ //enter
            gameState = 2;
            gameOngoing = true;
        }
        if (keys[22]){ //K
            gameState = 5;
        }
    }
    public void tipsScreen (Graphics2D win, boolean[] keys){
        win.drawImage (tipsScreen,null,0,0);
        if (!gameOngoing && keys[23]){ //I
            gameState = 4;
        }
        if (gameOngoing && keys[23]){ //I
            gameState = 3;
        }
        if (keys[10]){ //enter
            if (gameOngoing){
                restartGame();
            }
            gameState = 2;
            gameOngoing = true;
        }
    }
    public void gameOver(Graphics2D win, boolean[] keys){
        if (!coinsAdded){
            coins += totalScore;
            coinsAdded = true;
        }
        if (unlockTimer >= 60){
            unlockTimer = 60;
        }else{
            unlockTimer++;
        }
        win.setColor(Color.BLACK);
       // win.fill(background);
        win.drawImage (deathScreen, null,0,0);
        win.setColor(Color.WHITE);
        win.setFont(gameFont);
        win.drawString("Game Over", 330, 150); 
        win.drawString("Score = " + totalScore,330,190);
        win.drawString ("Press R to play again", 280,230);
        win.setFont (scoreFont);
        win.drawString ("Coins = " + coins + " (These add up for every game you play.)",120,270);
        win.drawString ("Press K to view tips", 300,550);
        if (!allSkillsUnlocked){
            win.drawString ("Press T to buy All-Skills-Unlocked Mode for 500 coins.",80,350);
            win.drawString ("(You'll start the game with all five skills available.)",120,380);
            if (coins >= 500 && keys[19]){
                coins -= 500;
                allSkillsUnlocked = true; 
                unlockTimer = 0;
            }
        }
        if (!flightModeUnlocked){
            win.drawString("Press Y to buy Flight Mode for 1000 coins.",140,440);
            if (coins >= 1000 && keys[21]){
                coins -= 1000;
                flightModeUnlocked = true;
                unlockTimer = 0;
            }
        }
        if (flightModeUnlocked){
            win.drawString ("Press Y to play in Flight Mode",150,440);
            win.drawString ("(Press the up arrow key to move up",150,470);
            win.drawString ("and the down arrow key to move downward.)",150,500);
        }
        if (keys[21] && flightModeUnlocked && unlockTimer == 60){
            restartGame();
            flightMode = true;
        }
        if (allSkillsUnlocked){
             win.drawString ("Press T to play in All-Skills-Unlocked Mode",140,350);
             win.drawString ("(You'll start the game with all five skills available.)",120,380);
        }
        if (keys[19] && allSkillsUnlocked && unlockTimer == 60){
            restartGame();
            stage = 4;
            score = lev4 + 1;
            setLevel(15);
        }
        //reset game
        if (keys[18]){
            restartGame();
        }
        if (keys[22]){
            gameState = 5;
        }
    }
    public void restartGame (){
        gameState = 2;
        life = 5;
        pengState = 0; 
        level = 0;
        modLevel = 0;
        difficultyMod = 0;
        score = 0;
        totalScore = 0;
        timer = 0;
        stage = 0;
        nextD = -1;
        lastDanger = 0;
        hasPower = false;
        upgradeUsed = false;
        isUpgrading = false;
        facedRight = true;
        pressed = false;
        isExpanded = true;
        climbing = false;
        hero = new Penguin();
        startDanger = false;
        coinsAdded = false;
        flightMode = false;
        blocks.clear();
        creeps.clear();
        powers.clear();
    }
    public void redoLevel (){
        hasPower = false;
        upgradeUsed = false;
        isUpgrading = false;
        facedRight = true;
        pressed = false;
        isExpanded = true;
        climbing = false;
        hero = new Penguin();
        startDanger = false;
        blocks.clear();
        creeps.clear();
        powers.clear();     
    }
    public void speedModifier () {
        if (hero.myX() > 650){
            setGameSpeed(-3);
        }else if (hero.myX() > 500){    
            setGameSpeed(-2);
        }else{
            setGameSpeed(GAME_SPEED);
        }
    }
    public boolean gravityApplies(){
        if (pengState == 3 && pressed){
            return false;
        }
        if (pengState == 4 && climbing){
            return false;
        }
        for (int i = 0; i < blocks.size();i++){
            if (hero.intersects(getBufferRect(blocks.get(i)))){
                return false;
            }
        }
        if (flightMode){
            return false;
        }
        return true;
    }
    public boolean gravityAppliesMonster(Monster m){
        for (int i = 0; i < blocks.size(); i++){
            if (m.intersects(getBufferRect(blocks.get(i)))){
                return false;
            }
        }
        return true;
    }  
    public Rectangle getBufferRect(Block b){
        Rectangle top = b.getTop();
        return new Rectangle ((int)top.getX(),(int)top.getY()-2,(int)top.getWidth(),2);
    }
    public boolean canJump (){
        for (int i = 0; i < blocks.size(); i++){
            Block temp = blocks.get(i);
            Rectangle buffer = getBufferRect(temp);
            if (hero.intersects(buffer)){
                return true;
            }
        }
        return false;
    }
    public boolean canGlide(){
        for (int i = 0; i < blocks.size();i++){
            if (hero.intersects(getBufferRect(blocks.get(i)))){
                return false;
            }
        }
        return true;
    }
    public boolean canExpand (){
        for (int i = 0; i < blocks.size(); i ++){
            Rectangle temp = new Rectangle (hero.myX(), hero.myY() - Penguin.HEIGHT/2, hero.getWd(), hero.getHt());
            if (temp.intersects (blocks.get(i).getBot())){
                return false;
            }
        }
        return true;
    }
    public boolean canMoveRt(Element e){
       for (int i = 0; i < blocks.size(); i++){
            if (e.intersects(blocks.get(i).getLt())){
                return false;
            }
           Block temp = blocks.get(i);
            if (e instanceof Monster){
                if (e.intersects(getBufferRect(temp))){
                    if ((e.myX()+50) > (temp.myX() + temp.getWd())){
                        return false;
                    }
                }
            }
        }
       if (hero.myX() + Penguin.WIDTH >= 800){
           return false;
       }
       return true;
    }
    public boolean canMoveLt(Element e){
       for (int i = 0; i < blocks.size(); i++){
            if (e.intersects(blocks.get(i).getRt())){
                return false;
            }
            Block temp = blocks.get(i);
            if (e instanceof Monster){
                if (e.intersects(getBufferRect(temp))){
                    if (e.myX() < temp.myX()){
                        return false;
                    }
                }
            }
        }
       return true;
    }
    public boolean canMoveUp(Element e){
        for (int i = 0; i < blocks.size(); i++){
            if (e.intersects(blocks.get(i).getBot())){
                return false;
            }
        }
        return true;
    }
    public boolean canMoveDown(Element e){
        for (int i = 0; i < blocks.size(); i++){
            if (e.intersects(blocks.get(i).getTop())){
                return false;
            }
        }
        return true;
    }
    public void setLevel (int i){
        level = i;
        modLevel = i - difficultyMod;
    }
    public void setDifficultyMod (int i){
        difficultyMod = i;
        modLevel = level - difficultyMod;
    }
    public void setPengState (int i){
        pengState = i;
        hero.setState(i);
    } 
    public void getUpgrade(){
        for (int i = 0; i < powers.size(); i++){
            Upgrade temp = powers.get(i);
            if (hero.intersects(temp)){
                stage = temp.getNumber(); 
                if (!temp.getUsed()){
                    hasPower = true;
                    temp.use();
                }
            }
        }
    }
    public boolean upgradeCentered(){
        for (int i = 0; i < powers.size(); i++){
            if (powers.get(i).myX() == 200){
                return true;
            }
        }
        return false;
    }
    public void movingBlockUpDown (){
        for (int i = 0; i < blocks.size(); i++){
            Block temp = blocks.get(i);
            if (temp instanceof MovingBlock){
                if (hero.intersects(getBufferRect(temp))&& temp.getDy() < 0){
                    hero.setDy(temp.getDy());
                }
            }
        }
    }
    public void flying (boolean hi){
        if (hi){
            if (keys[12]){
                hero.setDy(-pengSpeed);
            }else if (keys[13]){
                hero.setDy(pengSpeed);
            }else{
                hero.setDy(0);
            }
            if (hero.myY() < 0 && keys[12]){
                hero.setDy(0);
            }
        }
    }
}
