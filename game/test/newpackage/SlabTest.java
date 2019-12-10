/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Graphics;
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
public class SlabTest {
    
    public SlabTest() {
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
     * Test of checkIfSlabsLeft method, of class Slabs.
     */
    @Test
    public void testCheckIfSlabsLeft() {
        System.out.println("checkSlabAmount - ==0");
        int slabAmount = 0;
        Slabs instance = new Slabs();
        boolean expResult = false;
        boolean result = instance.checkIfSlabsLeft(slabAmount);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckIfSlabsLeft2() {
        System.out.println("checkSlabAmount - >0");
        int slabAmount = 10;
        Slabs instance = new Slabs();
        boolean expResult = true;
        boolean result = instance.checkIfSlabsLeft(slabAmount);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of intersects method, of class Slabs.
     */
    @Test
    public void testIntersects() {
        System.out.println("intersects - false");
        int ballX = 100;
        int ballY = 100;
        int ballWidth = 15;
        int ballHeight = 15;
        Slabs instance = new Slabs();
        boolean expResult = false;
        boolean result = instance.intersects(ballX, ballY, ballWidth, ballHeight);
        assertEquals(expResult, result);
    }


}
