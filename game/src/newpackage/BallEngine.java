/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author matas
 */
public class BallEngine extends BallPositionBuilder implements Position {
    
    public boolean checkIfBallIsInGame(int ballX, int ballY, int scrnWidth, int scrnHeight, int ballWidth){
        if(ballX<=(scrnWidth-scrnWidth) || ballX>(scrnWidth-ballWidth)){
            ballSpeedAndDirectionX=-ballSpeedAndDirectionX;
            return true;
        }else if(ballY<=(scrnHeight-scrnHeight)){
            ballSpeedAndDirectionY=-ballSpeedAndDirectionY;
            return true;
        }else if(ballY>=(scrnHeight-ballWidth)){
            return false;
        }
        return true;
    }
    
    @Override
    public int getPositionX() {
        return ballPosX;
    }

    @Override
    public int getPositionY() {
        return ballPosY;
    }

    @Override
    public void setBallPosX(int ballX) {
        this.ballPosX=ballX-ballSpeedAndDirectionX;
    }

    @Override
    public void setBallPosY(int ballY) {
        this.ballPosY=ballY-ballSpeedAndDirectionY;
    }
}
