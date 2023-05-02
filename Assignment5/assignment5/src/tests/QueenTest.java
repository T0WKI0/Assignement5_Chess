package assignment5.src.tests;

import assignment5.src.main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class QueenTest.
 *
 * @author  (Melvin Kuchefski)
 * @version (4.1.23)
 */
public class QueenTest
{
    Queen queen1; 
    Queen queen2;
    Queen queenMain;
    Queen queenCapUp;
    Queen queenCapDwn;
    Queen queenCapLeft;
    Queen queenCapRight;
    Queen queenCapDiagUL;
    Queen queenCapDiagUR;
    Queen queenCapDiagDL;
    Queen queenCapDiagDR;
    Queen queenFarCapUp;
    Queen queenFarCapDwn;
    Queen queenFarCapLeft;
    Queen queenFarCapRight;
    Queen queenFarCapDiagUL;
    Queen queenFarCapDiagUR;
    Queen queenFarCapDiagDL;
    Queen queenFarCapDiagDR;
    Queen queenFalseCap1;
    Queen queenFalseCap2;
    Queen queenFalseCap3;
    Queen queenFalseFriendly1;
    Queen queenFalseFriendly2;
    Queen queenFalseFriendly3;
    Queen queenFalseFriendly4;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Set up pieces
        queen1 = new Queen('a', 7, ChessPiece.Color.BLACK);
        queen2 = new Queen('h', 3, ChessPiece.Color.WHITE);  
        queenMain = new Queen('e', 4, ChessPiece.Color.WHITE);
        // Close capture
        queenCapUp = new Queen('e', 5, ChessPiece.Color.BLACK);
        queenCapDwn = new Queen('e', 3, ChessPiece.Color.BLACK);
        queenCapLeft = new Queen('d', 4, ChessPiece.Color.BLACK);
        queenCapRight = new Queen('f', 4, ChessPiece.Color.BLACK);
        queenCapDiagUL = new Queen('d', 5, ChessPiece.Color.BLACK);
        queenCapDiagUR = new Queen('f', 5, ChessPiece.Color.BLACK);
        queenCapDiagDL = new Queen('d', 3, ChessPiece.Color.BLACK);
        queenCapDiagDR = new Queen('f', 3, ChessPiece.Color.BLACK);
        // Far capture
        queenFarCapUp = new Queen('e', 8, ChessPiece.Color.BLACK);
        queenFarCapDwn = new Queen('e', 1, ChessPiece.Color.BLACK);
        queenFarCapLeft = new Queen('a', 4, ChessPiece.Color.BLACK);
        queenFarCapRight = new Queen('h', 4, ChessPiece.Color.BLACK);
        queenFarCapDiagUL = new Queen('a', 8, ChessPiece.Color.BLACK);
        queenFarCapDiagUR = new Queen('h', 7, ChessPiece.Color.BLACK);
        queenFarCapDiagDL = new Queen('b', 1, ChessPiece.Color.BLACK);
        queenFarCapDiagDR = new Queen('h', 1, ChessPiece.Color.BLACK);
        // False capture enemy wrong location
        queenFalseCap1 = new Queen('b', 5, ChessPiece.Color.BLACK);
        queenFalseCap2 = new Queen('f', 1, ChessPiece.Color.BLACK);
        queenFalseCap3 = new Queen('f', 8, ChessPiece.Color.BLACK);
        // False capture friendly piece
        queenFalseFriendly1 = new Queen('e', 5, ChessPiece.Color.WHITE);
        queenFalseFriendly2 = new Queen('f', 3, ChessPiece.Color.WHITE);
        queenFalseFriendly3 = new Queen('h', 4, ChessPiece.Color.WHITE);
        queenFalseFriendly4 = new Queen('a', 8, ChessPiece.Color.WHITE);
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
        assertEquals('a', queen1.getColumn());
        assertEquals('h', queen2.getColumn());
    }
    
    @Test
    public void testGetRow() {
        assertEquals(7, queen1.getRow());
        assertEquals(3, queen2.getRow());
    }
    
    @Test
    public void testGetColor() {
        assertEquals(ChessPiece.Color.BLACK, queen1.getColor());
        assertEquals(ChessPiece.Color.WHITE, queen2.getColor());
    }

    @Test
    public void testCanMove() {
        assertTrue(queen1.canMove('a', 3));
        // vertical movement
        assertTrue(queenMain.canMove('e', 7));
        assertTrue(queenMain.canMove('e', 2));
        // horizontal movement
        assertTrue(queenMain.canMove('b', 4));
        assertTrue(queenMain.canMove('g', 4));
        // diagonal movement
        assertTrue(queenMain.canMove('b', 7));
        assertTrue(queenMain.canMove('g', 6));
        assertTrue(queenMain.canMove('c', 2));
        assertTrue(queenMain.canMove('h', 1));
        // false movement
        assertFalse(queenMain.canMove('b', 3));
        assertFalse(queenMain.canMove('d', 8));
        assertFalse(queenMain.canMove('g', 3));
        // self false
        assertFalse(queenMain.canMove('e', 4));
        // illegal movement
        assertThrows(IllegalArgumentException.class, () -> {queenMain.canMove('z', 1);});
        assertThrows(IllegalArgumentException.class, () -> {queenMain.canMove('a', 9);});
        assertThrows(IllegalArgumentException.class, () -> {queenMain.canMove('z', 9);});
    }
    
    @Test
    public void testCanCapture() {
        assertFalse(queen1.canCapture(queen2));
        assertFalse(queen2.canCapture(queen1));
        // True captures
        // close captures
        assertTrue(queenMain.canCapture(queenCapUp));
        assertTrue(queenMain.canCapture(queenCapDwn));
        assertTrue(queenMain.canCapture(queenCapLeft));
        assertTrue(queenMain.canCapture(queenCapRight));
        assertTrue(queenMain.canCapture(queenCapDiagUL));
        assertTrue(queenMain.canCapture(queenCapDiagUR));
        assertTrue(queenMain.canCapture(queenCapDiagDL));
        assertTrue(queenMain.canCapture(queenCapDiagDR));
        // far captures
        assertTrue(queenMain.canCapture(queenFarCapUp));
        assertTrue(queenMain.canCapture(queenFarCapDwn));
        assertTrue(queenMain.canCapture(queenFarCapLeft));
        assertTrue(queenMain.canCapture(queenFarCapRight));
        assertTrue(queenMain.canCapture(queenFarCapDiagUL));
        assertTrue(queenMain.canCapture(queenFarCapDiagUR));
        assertTrue(queenMain.canCapture(queenFarCapDiagDL));
        assertTrue(queenMain.canCapture(queenFarCapDiagDR));
        
        // False captures
        // enemy wrong location
        assertFalse(queenMain.canCapture(queenFalseCap1));
        assertFalse(queenMain.canCapture(queenFalseCap2));
        assertFalse(queenMain.canCapture(queenFalseCap3));
        // friendly in capture-able location
        assertFalse(queenMain.canCapture(queenFalseFriendly1));
        assertFalse(queenMain.canCapture(queenFalseFriendly2));
        assertFalse(queenMain.canCapture(queenFalseFriendly3));
        assertFalse(queenMain.canCapture(queenFalseFriendly4));
    }
}
