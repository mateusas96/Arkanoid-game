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
public class BallEngine extends Ball {
    
    @Override
    public int moveBallY(int ballY) {
        return ballY-ballSpeedY;
    }

    @Override
    public int moveBallX(int ballX) {
        return ballX-ballSpeedX;
    }

}
