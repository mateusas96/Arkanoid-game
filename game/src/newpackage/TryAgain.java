/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Matas
 */
public class TryAgain extends Slab{
    
    private final int againWidth = 350, againHeight = 150;
    private final int textX=130,textY=5,textWidth=100,textHeight=20;
    private final int text2X=125,text2Y=25,text2Width=120,text2Height=20;
    private final int buttonY=60,buttonWidth=130,buttonHeight=30,againX=25,exitX=185;
    private final int rrSlabs = 64;
    
    public void again(int score){
        JFrame againScrn = new JFrame();
        MainScreen scrn = new MainScreen();
        TryAgain agn = new TryAgain();
        
        agn.setSlabsLeft(rrSlabs);
        
        againScrn.setTitle("Arkanoid game");
        againScrn.setVisible(true);       
        againScrn.setSize(againWidth,againHeight);
        againScrn.setLocationRelativeTo(null);
        againScrn.setResizable(false);
        againScrn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JButton again = new JButton("Try again");
        JButton exit = new JButton("Exit");
        JLabel text = new JLabel("Game Over!");
        JLabel text2 = new JLabel("Your score: "+score);
        
        again.setBounds(againX, buttonY, buttonWidth, buttonHeight);
        exit.setBounds(exitX, buttonY, buttonWidth, buttonHeight);
        text.setBounds(textX,textY, textWidth, textHeight);
        text2.setBounds(text2X,text2Y, text2Width, text2Height);
        
        againScrn.setLayout(null);
        
        againScrn.add(again);
        againScrn.add(exit);
        againScrn.add(text);
        againScrn.add(text2);
        
        again.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            againScrn.setVisible(false);
            scrn.Screen();
        }
        });
        
        exit.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            System.exit(0);
        }
        });
    }
}
