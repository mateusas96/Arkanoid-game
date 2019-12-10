/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Matas
 */
public class Gameboard {
    
    private final int boardWidth = 700, boardHeight = boardWidth;
    private final int scoreX = 630, scoreY = 630;
    private int score=0;
    private int difficulty;
    private JFrame gameboard;
    
    public void makeGameboard(){
        gameboard = new JFrame();
        
        gameboard.setTitle("Arkanoid game");
        gameboard.setVisible(true);
        gameboard.setSize(boardWidth, boardHeight);
        gameboard.setResizable(false);
        gameboard.setLocationRelativeTo(null);
        gameboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Engine eng = new Engine();
        
        eng.setRectangleWidth(difficulty);
        
        
        gameboard.add(eng);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.drawString("Score: "+score, scoreX, scoreY);
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

}
