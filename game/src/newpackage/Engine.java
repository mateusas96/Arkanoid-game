/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 *
 * @author Matas
 */
public class Engine extends JPanel implements MouseMotionListener, Runnable{
    
    private final int rectangleY = 650, rectangleHeight=10;
    private int rectangleWidth;
    private final int screenX=0,screenY=screenX,screenWidth=700,screenHeight=screenWidth, screenRightSideX=680;
    
    private final int ballWidth=15, ballHeight=15;
    private int ballPosX=350, ballPosY=500;
    private int slabsAmount = 64;
    private int rectanglePlayerPosX = 300;
    private final int increaseScore = 10;
    private final int decreaseSlabs = 1;

    BallEngine ballEng = new BallEngine();
    TryAgain again = new TryAgain();
    Gameboard gb = new Gameboard();
    Gameboard gs = new Slab();
    Rectangle ball;
    Rectangle rectangle;
    Rectangle slabs;
    Slab slab = new Slab();
    boolean play=false;
    Thread newThread;
    

    
    public Engine(){
        addMouseMotionListener((MouseMotionListener)this);
        ballEng.ballSpeedX=1;
        ballEng.ballSpeedY=1;
        this.play = true;
        this.newThread = new Thread(this);
        this.newThread.start();
        slab.addSlabs();
    }
    
    public void setRectangleWidth(int rectangleWidth) {
        this.rectangleWidth = rectangleWidth;
    }

    @Override
    public void paint(Graphics ui){
        
        //screen
        ui.setColor(Color.darkGray);
        ui.fillRect(screenX,screenY,screenWidth,screenHeight);
        
        //rectangle
        ui.setColor(Color.red);
        ui.fillRect(rectanglePlayerPosX, rectangleY, rectangleWidth, rectangleHeight);
        
        //ball
        ui.setColor(Color.white);
        ui.fillOval(ballPosX, ballPosY, ballWidth, ballHeight);
        
        //score
        gb.draw(ui);
        
        //slabs left
        gs.draw(ui);
        
        //slab
        slab.drawSlabs(ui);;
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getX()>=(screenWidth-screenWidth) &&  e.getX()<=(screenWidth-rectangleWidth)){
            rectanglePlayerPosX = e.getX();
        }
    }

    @Override
    public void run() {
        while(play){
            ball = new Rectangle(ballPosX, ballPosY, ballWidth, ballHeight);
            rectangle = new Rectangle(rectanglePlayerPosX, rectangleY, rectangleWidth, rectangleHeight);
   
            try{
                if(ballPosX<=(screenWidth-screenWidth) || ballPosX>=screenRightSideX){
                    ballEng.ballSpeedX=-ballEng.ballSpeedX;
                }else if(ballPosY<=(screenHeight-screenHeight)){
                    ballEng.ballSpeedY=-ballEng.ballSpeedY;
                }else if(ballPosY>=(screenHeight-ballWidth)){
                    play=false;
                }

                if(ball.intersects(rectangle)){
                    ballEng.ballSpeedY=-ballEng.ballSpeedY;  
                }

                setBallPosY(ballEng.moveBallY(getBallPosY()));
                setBallPosX(ballEng.moveBallX(getBallPosX()));
                
                if(slab.ifIntersects(getBallPosX(), getBallPosY(), ballWidth, ballHeight)){
                    ballEng.ballSpeedY=-ballEng.ballSpeedY;
                    slabsAmount--;
                    slab.setSlabsLeft(slab.getSlabsLeft()-decreaseSlabs);
                    gb.setScore(gb.getScore()+increaseScore);
                    checkSlabAmount(slabsAmount);
                }
                
                
                Thread.sleep(3);
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            repaint();
        }
        again.again(gb.getScore()); 
    }

    public void checkSlabAmount(int slabAmount){
        if(slabAmount==0){
            play=false;
        }
    }
    
    public void setBallPosX(int ballPosX) {
        this.ballPosX = ballPosX;
    }

    public void setBallPosY(int ballPosY) {
        this.ballPosY = ballPosY;
    }

    public int getBallPosX() {
        return ballPosX;
    }

    public int getBallPosY() {
        return ballPosY;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}

