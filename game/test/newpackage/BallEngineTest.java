/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matas
 */
public class BallEngineTest {
    
    public BallEngineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkIfBallIsInGame method, of class BallEngine.
     */
    @Test
    public void testCheckIfBallIsInGame() {
        System.out.println("checkIfBallIsInGame - true");
        int ballX = 0;
        int ballY = 0;
        int scrnWidth = 700;
        int scrnHeight = 700;
        int ballWidth = 15;
        BallEngine instance = new BallEngine();
        boolean expResult = true;
        boolean result = instance.checkIfBallIsInGame(ballX, ballY, scrnWidth, scrnHeight, ballWidth);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckIfBallIsInGame2() {
        System.out.println("checkIfBallIsInGame - false");
        int ballX = 100;
        int ballY = 710;
        int scrnWidth = 700;
        int scrnHeight = 700;
        int ballWidth = 15;
        BallEngine instance = new BallEngine();
        boolean expResult = false;
        boolean result = instance.checkIfBallIsInGame(ballX, ballY, scrnWidth, scrnHeight, ballWidth);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckIfBallIsInGame3() {
        System.out.println("checkIfBallIsInGame - true");
        int ballX = 250;
        int ballY = 250;
        int scrnWidth = 700;
        int scrnHeight = 700;
        int ballWidth = 15;
        BallEngine instance = new BallEngine();
        boolean expResult = true;
        boolean result = instance.checkIfBallIsInGame(ballX, ballY, scrnWidth, scrnHeight, ballWidth);
        assertEquals(expResult, result);
    }
    
}
