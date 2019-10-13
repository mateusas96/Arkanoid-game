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
public abstract class Ball{
    public int ballSpeedX,ballSpeedY;
    public abstract int moveBallY(int ballY);
    public abstract int moveBallX(int ballX);
}
