package assignment5.src.tests;

import assignment5.src.main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class BishopTest.
 *
 * @author  (Melvin Kuchefski)
 * @version (4.1.23)
 */
public class BishopTest
{
    Bishop bishop1; 
    Bishop bishop2;
    Bishop bishopMain;
    Bishop bishopCapUp;
    Bishop bishopCapDwn;
    Bishop bishopCapLeft;
    Bishop bishopCapRight;
    Bishop bishopCapDiagUL;
    Bishop bishopCapDiagUR;
    Bishop bishopCapDiagDL;
    Bishop bishopCapDiagDR;
    Bishop bishopFarCapUp;
    Bishop bishopFarCapDwn;
    Bishop bishopFarCapLeft;
    Bishop bishopFarCapRight;
    Bishop bishopFarCapDiagUL;
    Bishop bishopFarCapDiagUR;
    Bishop bishopFarCapDiagDL;
    Bishop bishopFarCapDiagDR;
    Bishop bishopFalseCap1;
    Bishop bishopFalseCap2;
    Bishop bishopFalseCap3;
    Bishop bishopFalseFriendly1;
    Bishop bishopFalseFriendly2;
    Bishop bishopFalseFriendly3;
    Bishop bishopFalseFriendly4;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Set up pieces
        bishop1 = new Bishop('a', 7, ChessPiece.Color.BLACK);
        bishop2 = new Bishop('h', 3, ChessPiece.Color.WHITE);  
        bishopMain = new Bishop('e', 4, ChessPiece.Color.WHITE);
        // Close capture
        bishopCapUp = new Bishop('e', 5, ChessPiece.Color.BLACK);
        bishopCapDwn = new Bishop('e', 3, ChessPiece.Color.BLACK);
        bishopCapLeft = new Bishop('d', 4, ChessPiece.Color.BLACK);
        bishopCapRight = new Bishop('f', 4, ChessPiece.Color.BLACK);
        bishopCapDiagUL = new Bishop('d', 5, ChessPiece.Color.BLACK);
        bishopCapDiagUR = new Bishop('f', 5, ChessPiece.Color.BLACK);
        bishopCapDiagDL = new Bishop('d', 3, ChessPiece.Color.BLACK);
        bishopCapDiagDR = new Bishop('f', 3, ChessPiece.Color.BLACK);
        // Far capture
        bishopFarCapUp = new Bishop('e', 8, ChessPiece.Color.BLACK);
        bishopFarCapDwn = new Bishop('e', 1, ChessPiece.Color.BLACK);
        bishopFarCapLeft = new Bishop('a', 4, ChessPiece.Color.BLACK);
        bishopFarCapRight = new Bishop('h', 4, ChessPiece.Color.BLACK);
        bishopFarCapDiagUL = new Bishop('a', 8, ChessPiece.Color.BLACK);
        bishopFarCapDiagUR = new Bishop('h', 7, ChessPiece.Color.BLACK);
        bishopFarCapDiagDL = new Bishop('b', 1, ChessPiece.Color.BLACK);
        bishopFarCapDiagDR = new Bishop('h', 1, ChessPiece.Color.BLACK);
        // False capture enemy wrong location
        bishopFalseCap1 = new Bishop('b', 5, ChessPiece.Color.BLACK);
        bishopFalseCap2 = new Bishop('f', 1, ChessPiece.Color.BLACK);
        bishopFalseCap3 = new Bishop('f', 8, ChessPiece.Color.BLACK);
        // False capture friendly piece
        bishopFalseFriendly1 = new Bishop('d', 5, ChessPiece.Color.WHITE);
        bishopFalseFriendly2 = new Bishop('f', 3, ChessPiece.Color.WHITE);
        bishopFalseFriendly3 = new Bishop('h', 1, ChessPiece.Color.WHITE);
        bishopFalseFriendly4 = new Bishop('a', 8, ChessPiece.Color.WHITE);
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
        assertEquals('a', bishop1.getColumn());
        assertEquals('h', bishop2.getColumn());
    }
    
    @Test
    public void testGetRow() {
        assertEquals(7, bishop1.getRow());
        assertEquals(3, bishop2.getRow());
    }
    
    @Test
    public void testGetColor() {
        assertEquals(ChessPiece.Color.BLACK, bishop1.getColor());
        assertEquals(ChessPiece.Color.WHITE, bishop2.getColor());
    }

    @Test
    public void testCanMove() {
        assertFalse(bishop1.canMove('a', 3));
        // vertical movement
        assertFalse(bishopMain.canMove('e', 7));
        assertFalse(bishopMain.canMove('e', 2));
        // horizontal movement
        assertFalse(bishopMain.canMove('b', 4));
        assertFalse(bishopMain.canMove('g', 4));
        // diagonal movement
        assertTrue(bishopMain.canMove('b', 7));
        assertTrue(bishopMain.canMove('g', 6));
        assertTrue(bishopMain.canMove('c', 2));
        assertTrue(bishopMain.canMove('h', 1));
        // false movement
        assertFalse(bishopMain.canMove('b', 3));
        assertFalse(bishopMain.canMove('d', 8));
        assertFalse(bishopMain.canMove('g', 3));
        // self false
        assertFalse(bishopMain.canMove('e', 4));
        // illegal movement
        assertThrows(IllegalArgumentException.class, () -> {bishopMain.canMove('z', 1);});
        assertThrows(IllegalArgumentException.class, () -> {bishopMain.canMove('a', 9);});
        assertThrows(IllegalArgumentException.class, () -> {bishopMain.canMove('z', 9);});
    }
    
    @Test
    public void testCanCapture() {
        assertFalse(bishop1.canCapture(bishop2));
        assertFalse(bishop2.canCapture(bishop1));
        // False close captures
        assertFalse(bishopMain.canCapture(bishopCapUp));
        assertFalse(bishopMain.canCapture(bishopCapDwn));
        assertFalse(bishopMain.canCapture(bishopCapLeft));
        assertFalse(bishopMain.canCapture(bishopCapRight));
        // True close captures
        assertTrue(bishopMain.canCapture(bishopCapDiagUL));
        assertTrue(bishopMain.canCapture(bishopCapDiagUR));
        assertTrue(bishopMain.canCapture(bishopCapDiagDL));
        assertTrue(bishopMain.canCapture(bishopCapDiagDR));
        // False far captures
        assertFalse(bishopMain.canCapture(bishopFarCapUp));
        assertFalse(bishopMain.canCapture(bishopFarCapDwn));
        assertFalse(bishopMain.canCapture(bishopFarCapLeft));
        assertFalse(bishopMain.canCapture(bishopFarCapRight));
        // True far captures
        assertTrue(bishopMain.canCapture(bishopFarCapDiagUL));
        assertTrue(bishopMain.canCapture(bishopFarCapDiagUR));
        assertTrue(bishopMain.canCapture(bishopFarCapDiagDL));
        assertTrue(bishopMain.canCapture(bishopFarCapDiagDR));
        
        // False captures
        // enemy wrong location
        assertFalse(bishopMain.canCapture(bishopFalseCap1));
        assertFalse(bishopMain.canCapture(bishopFalseCap2));
        assertFalse(bishopMain.canCapture(bishopFalseCap3));
        // friendly in capture-able location
        assertFalse(bishopMain.canCapture(bishopFalseFriendly1));
        assertFalse(bishopMain.canCapture(bishopFalseFriendly2));
        assertFalse(bishopMain.canCapture(bishopFalseFriendly3));
        assertFalse(bishopMain.canCapture(bishopFalseFriendly4));
    }
}
