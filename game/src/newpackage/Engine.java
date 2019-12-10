/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


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
    private final int screenX=0,screenY=0,screenWidth=700,screenHeight=700;
    
    private final int ballWidth=15, ballHeight=15;
    private int rectanglePlayerPosX = 300;
    private final int increaseScore = 10;
    private final int decreaseSlabs = 1;
    private boolean play=false;

    BallEngine ballEng = new BallEngine();
    TryAgainScreen again = new TryAgainScreen();
    Gameboard gb = new Gameboard();
    Gameboard gs = new Slabs();
    Slabs slab = new Slabs();
    
    Rectangle ball;
    Rectangle rectangle;
    Rectangle slabs;
    
    Thread newThread;

    public Engine(){
        addMouseMotionListener(this);
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
        ui.fillOval(ballEng.getPositionX(), ballEng.getPositionY(), ballWidth, ballHeight);
        
        //score
        gb.draw(ui);
        
        //slabs left
        gs.draw(ui);
        
        //slab
        slab.makeSlabsRow(ui);
        
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
            ball = new Rectangle(ballEng.getPositionX(), ballEng.getPositionY(), ballWidth, ballHeight);
            rectangle = new Rectangle(rectanglePlayerPosX, rectangleY, rectangleWidth, rectangleHeight);
   
            try{
                play=ballEng.checkIfBallIsInGame(ballEng.getPositionX(),ballEng.getPositionY(),screenWidth, screenHeight,ballWidth);
                
                if(ball.intersects(rectangle)){
                    ballEng.ballSpeedAndDirectionY=-ballEng.ballSpeedAndDirectionY;  
                }
                
                ballEng.move(ballEng.getPositionX(),ballEng.getPositionY());
                
                if(slab.intersects(ballEng.getPositionX(), ballEng.getPositionY(), ballWidth, ballHeight)){
                    ballEng.ballSpeedAndDirectionY=-ballEng.ballSpeedAndDirectionY;
                    slab.setSlabsLeft(slab.getSlabsLeft()-decreaseSlabs);
                    gb.setScore(gb.getScore()+increaseScore);
                    play = slab.checkIfSlabsLeft(slab.getSlabsLeft());
                }
                
                
                Thread.sleep(3);
                
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            repaint();
        }
        again.playAgain(gb.getScore());
        int restartedSlabsAmount = slab.restartSlabsAmount();
        slab.setSlabsLeft(restartedSlabsAmount);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

}

