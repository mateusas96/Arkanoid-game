/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Matas
 */
//Template method
abstract class BallPositionBuilder{
    public int ballSpeedAndDirectionX=1,ballSpeedAndDirectionY=1;
    int ballPosX = 350;
    int ballPosY = 500;
    
    final public void move(int ballX,int ballY){
        this.setBallPosX(ballX);
        this.setBallPosY(ballY);
    }
    
    abstract public void setBallPosX(int ballX);
    abstract public void setBallPosY(int ballY);
}
