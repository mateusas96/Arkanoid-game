/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Matas
 */
public class Slabs extends Gameboard{
    
    private int rows = 8,slabs=64;
    private final int Xcord=25, Ycord=60,SpaceMultiplier=2;
    private int screen=700;
    private static int slabsLeft=64;
    private final int slabsLeftPositionX = 15, slabsLeftPositionY = 630;
    private int slabWidth=screen/(rows*2),slabHeight=screen/(rows*4);
    
    
    private int[][] slabArray = new int[rows][rows];


    public void makeSlabsRow(Graphics g){
        for(int i=0;i<rows;i++){  
            drawSlabs(i,g);
        }
    }
    
    public void drawSlabs(int i, Graphics g){
        for(int j=0;j<(slabs/rows);j++){
            if(slabArray[i][j]>0){
                g.setColor(Color.green);
                g.drawRect((slabWidth*(j*SpaceMultiplier)+Xcord), (slabHeight*(i*SpaceMultiplier)+Ycord), slabWidth, slabHeight);
            }
        }
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.drawString("Slabs left: "+slabsLeft, slabsLeftPositionX, slabsLeftPositionY);
    }
    
    public void addSlabs(){
        for(int i=0;i<(slabs/rows);i++){  
            makeSlabsRow(i);
        }
    }
    

    public void makeSlabsRow(int i){
        for(int j=0;j<(slabs/rows);j++){
            slabArray[i][j]=rows;
        }
    }

    public int setSlabDestroyed(int row, int col, int boom) {
        return slabArray[row][col]=boom;
    }
    
    public boolean intersects(int ballX,int ballY,int ballWidth,int ballHeight){
        Rectangle ball = new Rectangle(ballX, ballY, ballWidth, ballHeight);
        
        for(int i=0;i<rows;i++){  
            for(int j=0;j<(slabs/rows);j++){
                Rectangle slab = new Rectangle((slabWidth*(j*SpaceMultiplier)+Xcord), (slabHeight*(i*SpaceMultiplier)+Ycord), slabWidth, slabHeight);
                if(slabArray[i][j]>0 && ball.getBounds().intersects(slab.getBounds())){
                    setSlabDestroyed(i,j,0);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkIfSlabsLeft(int slabsAmount){
        if(slabsAmount==0){
            return false;
        }
        return true;
    }
    
    public void setSlabsLeft(int slabsLeft) {
        this.slabsLeft = slabsLeft;
    }

    public int getSlabsLeft() {
        return slabsLeft;
    }
    
    public int restartSlabsAmount(){
        return this.slabs = 64;
    }
}
