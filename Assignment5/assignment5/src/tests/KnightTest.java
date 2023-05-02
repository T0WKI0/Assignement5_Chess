package assignment5.src.tests;

import assignment5.src.main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class KnightTest.
 *
 * @author  (Melvin Kuchefski)
 * @version (4.1.23)
 */
public class KnightTest
{
    Knight knight1; 
    Knight knight2;
    Knight knightMain;
    Knight knightCapUpLeft;
    Knight knightCapUpRight;
    Knight knightCapLeftUp;
    Knight knightCapRightUp;
    Knight knightCapLeftDown;
    Knight knightCapRightDown;
    Knight knightCapDownLeft;
    Knight knightCapDownRight;
    Knight knightFalseCap1;
    Knight knightFalseCap2;
    Knight knightFalseCap3;
    Knight knightCapUpLeftFriendly;
    Knight knightCapUpRightFriendly;
    Knight knightCapLeftUpFriendly;
    Knight knightCapRightUpFriendly;
    Knight knightCapLeftDownFriendly;
    Knight knightCapRightDownFriendly;
    Knight knightCapDownLeftFriendly;
    Knight knightCapDownRightFriendly;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Set up pieces
        knight1 = new Knight('a', 7, ChessPiece.Color.BLACK);
        knight2 = new Knight('h', 3, ChessPiece.Color.WHITE);  
        knightMain = new Knight('e', 4, ChessPiece.Color.WHITE);
        // Close capture
        knightCapUpLeft = new Knight('d', 6, ChessPiece.Color.BLACK);
        knightCapUpRight = new Knight('f', 6, ChessPiece.Color.BLACK);
        knightCapLeftUp = new Knight('c', 5, ChessPiece.Color.BLACK);
        knightCapRightUp = new Knight('g', 5, ChessPiece.Color.BLACK);
        knightCapLeftDown = new Knight('c', 3, ChessPiece.Color.BLACK);
        knightCapRightDown = new Knight('g', 3, ChessPiece.Color.BLACK);
        knightCapDownLeft = new Knight('d', 2, ChessPiece.Color.BLACK);
        knightCapDownRight = new Knight('f', 2, ChessPiece.Color.BLACK);
        // False capture enemy wrong location
        knightFalseCap1 = new Knight('b', 5, ChessPiece.Color.BLACK);
        knightFalseCap2 = new Knight('f', 1, ChessPiece.Color.BLACK);
        knightFalseCap3 = new Knight('f', 8, ChessPiece.Color.BLACK);
        // False capture friendly piece
        knightCapUpLeftFriendly = new Knight('d', 6, ChessPiece.Color.WHITE);
        knightCapUpRightFriendly = new Knight('f', 6, ChessPiece.Color.WHITE);
        knightCapLeftUpFriendly = new Knight('c', 5, ChessPiece.Color.WHITE);
        knightCapRightUpFriendly = new Knight('g', 5, ChessPiece.Color.WHITE);
        knightCapLeftDownFriendly = new Knight('c', 3, ChessPiece.Color.WHITE);
        knightCapRightDownFriendly = new Knight('g', 3, ChessPiece.Color.WHITE);
        knightCapDownLeftFriendly = new Knight('d', 2, ChessPiece.Color.WHITE);
        knightCapDownRightFriendly = new Knight('f', 2, ChessPiece.Color.WHITE);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * Called after all tests are done.
     */
    @AfterAll
    public static void done()
    {
        System.out.println("Testing complete!");
    }

    
    @Test
    public void testGetCol() {
        assertEquals('a', knight1.getColumn());
        assertEquals('h', knight2.getColumn());
    }
    
    @Test
    public void testGetRow() {
        assertEquals(7, knight1.getRow());
        assertEquals(3, knight2.getRow());
    }
    
    @Test
    public void testGetColor() {
        assertEquals(ChessPiece.Color.BLACK, knight1.getColor());
        assertEquals(ChessPiece.Color.WHITE, knight2.getColor());
    }

    @Test
    public void testCanMove() {
        // true movement
        assertTrue(knightMain.canMove('d', 6));
        assertTrue(knightMain.canMove('f', 6));
        assertTrue(knightMain.canMove('c', 5));
        assertTrue(knightMain.canMove('g', 5));
        assertTrue(knightMain.canMove('c', 3));
        assertTrue(knightMain.canMove('g', 3));
        assertTrue(knightMain.canMove('d', 2));
        assertTrue(knightMain.canMove('f', 2));
        // false movement
        assertFalse(knightMain.canMove('b', 3));
        assertFalse(knightMain.canMove('d', 8));
        assertFalse(knightMain.canMove('g', 2));
        // self false
        assertFalse(knightMain.canMove('e', 4));
        // illegal movement
        assertThrows(IllegalArgumentException.class, () -> {knightMain.canMove('z', 1);});
        assertThrows(IllegalArgumentException.class, () -> {knightMain.canMove('a', 9);});
        assertThrows(IllegalArgumentException.class, () -> {knightMain.canMove('z', 9);});
    }
    
    @Test
    public void testCanCapture() {
        assertFalse(knight1.canCapture(knight2));
        assertFalse(knight2.canCapture(knight1));
        // True captures
        assertTrue(knightMain.canCapture(knightCapUpLeft));
        assertTrue(knightMain.canCapture(knightCapUpRight));
        assertTrue(knightMain.canCapture(knightCapLeftUp));
        assertTrue(knightMain.canCapture(knightCapRightUp));
        assertTrue(knightMain.canCapture(knightCapLeftDown));
        assertTrue(knightMain.canCapture(knightCapRightDown));
        assertTrue(knightMain.canCapture(knightCapDownLeft));
        assertTrue(knightMain.canCapture(knightCapDownRight));
        
        // False captures
        // enemy wrong location
        assertFalse(knightMain.canCapture(knightFalseCap1));
        assertFalse(knightMain.canCapture(knightFalseCap2));
        assertFalse(knightMain.canCapture(knightFalseCap3));
        // friendly in capture-able location
        assertFalse(knightMain.canCapture(knightCapUpLeftFriendly));
        assertFalse(knightMain.canCapture(knightCapUpRightFriendly));
        assertFalse(knightMain.canCapture(knightCapLeftUpFriendly));
        assertFalse(knightMain.canCapture(knightCapRightUpFriendly));
        assertFalse(knightMain.canCapture(knightCapLeftDownFriendly));
        assertFalse(knightMain.canCapture(knightCapRightDownFriendly));
        assertFalse(knightMain.canCapture(knightCapDownLeftFriendly));
        assertFalse(knightMain.canCapture(knightCapDownRightFriendly));
    }
}
