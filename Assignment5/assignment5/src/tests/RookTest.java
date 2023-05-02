package assignment5.src.tests;

import assignment5.src.main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class RookTest.
 *
 * @author  (Melvin Kuchefski)
 * @version (4.1.23)
 */
public class RookTest
{
    Rook rook1; 
    Rook rook2;
    Rook rookMain;
    Rook rookCapUp;
    Rook rookCapDwn;
    Rook rookCapLeft;
    Rook rookCapRight;
    Rook rookCapDiagUL;
    Rook rookCapDiagUR;
    Rook rookCapDiagDL;
    Rook rookCapDiagDR;
    Rook rookFarCapUp;
    Rook rookFarCapDwn;
    Rook rookFarCapLeft;
    Rook rookFarCapRight;
    Rook rookFarCapDiagUL;
    Rook rookFarCapDiagUR;
    Rook rookFarCapDiagDL;
    Rook rookFarCapDiagDR;
    Rook rookFalseCap1;
    Rook rookFalseCap2;
    Rook rookFalseCap3;
    Rook rookFalseFriendly1;
    Rook rookFalseFriendly2;
    Rook rookFalseFriendly3;
    Rook rookFalseFriendly4;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Set up pieces
        rook1 = new Rook('a', 7, ChessPiece.Color.BLACK);
        rook2 = new Rook('h', 3, ChessPiece.Color.WHITE);  
        rookMain = new Rook('e', 4, ChessPiece.Color.WHITE);
        // Close capture
        rookCapUp = new Rook('e', 5, ChessPiece.Color.BLACK);
        rookCapDwn = new Rook('e', 3, ChessPiece.Color.BLACK);
        rookCapLeft = new Rook('d', 4, ChessPiece.Color.BLACK);
        rookCapRight = new Rook('f', 4, ChessPiece.Color.BLACK);
        rookCapDiagUL = new Rook('d', 5, ChessPiece.Color.BLACK);
        rookCapDiagUR = new Rook('f', 5, ChessPiece.Color.BLACK);
        rookCapDiagDL = new Rook('d', 3, ChessPiece.Color.BLACK);
        rookCapDiagDR = new Rook('f', 3, ChessPiece.Color.BLACK);
        // Far capture
        rookFarCapUp = new Rook('e', 8, ChessPiece.Color.BLACK);
        rookFarCapDwn = new Rook('e', 1, ChessPiece.Color.BLACK);
        rookFarCapLeft = new Rook('a', 4, ChessPiece.Color.BLACK);
        rookFarCapRight = new Rook('h', 4, ChessPiece.Color.BLACK);
        rookFarCapDiagUL = new Rook('a', 8, ChessPiece.Color.BLACK);
        rookFarCapDiagUR = new Rook('h', 7, ChessPiece.Color.BLACK);
        rookFarCapDiagDL = new Rook('b', 1, ChessPiece.Color.BLACK);
        rookFarCapDiagDR = new Rook('h', 1, ChessPiece.Color.BLACK);
        // False capture enemy wrong location
        rookFalseCap1 = new Rook('b', 5, ChessPiece.Color.BLACK);
        rookFalseCap2 = new Rook('f', 1, ChessPiece.Color.BLACK);
        rookFalseCap3 = new Rook('f', 8, ChessPiece.Color.BLACK);
        // False capture friendly piece
        rookFalseFriendly1 = new Rook('e', 5, ChessPiece.Color.WHITE);
        rookFalseFriendly2 = new Rook('e', 1, ChessPiece.Color.WHITE);
        rookFalseFriendly3 = new Rook('d', 4, ChessPiece.Color.WHITE);
        rookFalseFriendly4 = new Rook('h', 4, ChessPiece.Color.WHITE);
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
        assertEquals('a', rook1.getColumn());
        assertEquals('h', rook2.getColumn());
    }
    
    @Test
    public void testGetRow() {
        assertEquals(7, rook1.getRow());
        assertEquals(3, rook2.getRow());
    }
    
    @Test
    public void testGetColor() {
        assertEquals(ChessPiece.Color.BLACK, rook1.getColor());
        assertEquals(ChessPiece.Color.WHITE, rook2.getColor());
    }

    @Test
    public void testCanMove() {
        assertTrue(rook1.canMove('a', 3));
        // vertical movement
        assertTrue(rookMain.canMove('e', 7));
        assertTrue(rookMain.canMove('e', 2));
        // horizontal movement
        assertTrue(rookMain.canMove('b', 4));
        assertTrue(rookMain.canMove('g', 4));
        // diagonal movement
        assertFalse(rookMain.canMove('b', 7));
        assertFalse(rookMain.canMove('g', 6));
        assertFalse(rookMain.canMove('c', 2));
        assertFalse(rookMain.canMove('h', 1));
        // false movement
        assertFalse(rookMain.canMove('b', 3));
        assertFalse(rookMain.canMove('d', 8));
        assertFalse(rookMain.canMove('g', 3));
        // self false
        assertFalse(rookMain.canMove('e', 4));
        // illegal movement
        assertThrows(IllegalArgumentException.class, () -> {rookMain.canMove('z', 1);});
        assertThrows(IllegalArgumentException.class, () -> {rookMain.canMove('a', 9);});
        assertThrows(IllegalArgumentException.class, () -> {rookMain.canMove('z', 9);});
    }
    
    @Test
    public void testCanCapture() {
        assertFalse(rook1.canCapture(rook2));
        assertFalse(rook2.canCapture(rook1));
        // True close captures
        assertTrue(rookMain.canCapture(rookCapUp));
        assertTrue(rookMain.canCapture(rookCapDwn));
        assertTrue(rookMain.canCapture(rookCapLeft));
        assertTrue(rookMain.canCapture(rookCapRight));
        // False close captures
        assertFalse(rookMain.canCapture(rookCapDiagUL));
        assertFalse(rookMain.canCapture(rookCapDiagUR));
        assertFalse(rookMain.canCapture(rookCapDiagDL));
        assertFalse(rookMain.canCapture(rookCapDiagDR));
        // True far captures
        assertTrue(rookMain.canCapture(rookFarCapUp));
        assertTrue(rookMain.canCapture(rookFarCapDwn));
        assertTrue(rookMain.canCapture(rookFarCapLeft));
        assertTrue(rookMain.canCapture(rookFarCapRight));
        // False far captures
        assertFalse(rookMain.canCapture(rookFarCapDiagUL));
        assertFalse(rookMain.canCapture(rookFarCapDiagUR));
        assertFalse(rookMain.canCapture(rookFarCapDiagDL));
        assertFalse(rookMain.canCapture(rookFarCapDiagDR));
        
        // False captures
        // enemy wrong location
        assertFalse(rookMain.canCapture(rookFalseCap1));
        assertFalse(rookMain.canCapture(rookFalseCap2));
        assertFalse(rookMain.canCapture(rookFalseCap3));
        // friendly in capture-able location
        assertFalse(rookMain.canCapture(rookFalseFriendly1));
        assertFalse(rookMain.canCapture(rookFalseFriendly2));
        assertFalse(rookMain.canCapture(rookFalseFriendly3));
        assertFalse(rookMain.canCapture(rookFalseFriendly4));
    }
}
