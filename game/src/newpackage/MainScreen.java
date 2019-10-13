/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Matas
 */
public class MainScreen{
    
    private final int mainWidth = 350, mainHeight = 150;
    private final int difficultyEasy = 100, difficultyHard = 20;
    private final int buttonY=60,buttonWidth=130,buttonHeight=30,buttonNormalX=25,buttonHardX=185;
    private final int textX=120,textY=20,textWidth=100,textHeight=20;

    public void Screen(){
        
        Gameboard gb = new Gameboard();
        
        JFrame mainScrn = new JFrame();
        
        mainScrn.setTitle("Arkanoid game");
        mainScrn.setVisible(true);       
        mainScrn.setSize(mainWidth, mainHeight);
        mainScrn.setLocationRelativeTo(null);
        mainScrn.setResizable(false);
        mainScrn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JButton easy = new JButton("Easy difficulty");
        JButton hard = new JButton("Hard difficulty");
        
        
        easy.setBounds(buttonNormalX, buttonY, buttonWidth, buttonHeight);
        hard.setBounds(buttonHardX, buttonY, buttonWidth, buttonHeight);
        
        
        mainScrn.setLayout(null);

        
        JLabel text = new JLabel("Choose difficulty");
        text.setBounds(textX,textY, textWidth, textHeight);
        
        mainScrn.add(text);
        mainScrn.add(easy);
        mainScrn.add(hard);
        
        
        easy.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            mainScrn.setVisible(false);
            gb.setDifficulty(difficultyEasy);
            gb.gameBoard();
        }
        });
        
        hard.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            mainScrn.setVisible(false);
            gb.setDifficulty(difficultyHard);
            gb.gameBoard();
        }
        });
    }
}
