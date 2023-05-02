package assignment5.src.tests;

import assignment5.src.main.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The test class PawnTest.
 *
 * @author  (Melvin Kuchefski)
 * @version (4.1.23)
 */
public class PawnTest
{
    Pawn pawn1; 
    Pawn pawn2;
    Pawn pawnMainWhite;
    Pawn pawnMainBlack;
    Pawn pawnWhiteCapLeft;
    Pawn pawnWhiteCapRight;
    Pawn pawnBlackCapLeft;
    Pawn pawnBlackCapRight;
    Pawn pawnWhiteFalseCap1;
    Pawn pawnWhiteFalseCap2;
    Pawn pawnWhiteFalseCap3;
    Pawn pawnBlackFalseCap1;
    Pawn pawnBlackFalseCap2;
    Pawn pawnBlackFalseCap3;
    Pawn pawnBlackFalseCapBlkLeft;
    Pawn pawnBlackFalseCapBlkRight;
    Pawn pawnWhiteFalseCapWhtLeft;
    Pawn pawnWhiteFalseCapWhtRight;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Set up pieces
        pawn1 = new Pawn('a', 7, ChessPiece.Color.BLACK);
        pawn2 = new Pawn('h', 3, ChessPiece.Color.WHITE);
        pawnMainBlack = new Pawn('e', 4, ChessPiece.Color.BLACK);
        pawnMainWhite = new Pawn('e', 4, ChessPiece.Color.WHITE);
        
        // Black true capture
        pawnWhiteCapLeft = new Pawn('d', 3, ChessPiece.Color.WHITE);
        pawnWhiteCapRight = new Pawn('f', 3, ChessPiece.Color.WHITE);
        // White true capture
        pawnBlackCapLeft = new Pawn('d', 5, ChessPiece.Color.BLACK);
        pawnBlackCapRight = new Pawn('f', 5, ChessPiece.Color.BLACK);
        
        // Black false capture wrong location
        pawnWhiteFalseCap1 = new Pawn('e', 3, ChessPiece.Color.WHITE);
        pawnWhiteFalseCap2 = new Pawn('g', 7, ChessPiece.Color.WHITE);
        pawnWhiteFalseCap3 = new Pawn('c', 2, ChessPiece.Color.WHITE);
        // White false capture wrong location
        pawnBlackFalseCap1 = new Pawn('e', 5, ChessPiece.Color.BLACK);
        pawnBlackFalseCap2 = new Pawn('g', 4, ChessPiece.Color.BLACK);
        pawnBlackFalseCap3 = new Pawn('d', 6, ChessPiece.Color.BLACK);
        
        // Black false capture friendly
        pawnBlackFalseCapBlkLeft = new Pawn('d', 3, ChessPiece.Color.BLACK);
        pawnBlackFalseCapBlkRight = new Pawn('f', 3, ChessPiece.Color.BLACK);
        // White false capture friendly
        pawnWhiteFalseCapWhtLeft = new Pawn('d', 5, ChessPiece.Color.WHITE);
        pawnWhiteFalseCapWhtRight = new Pawn('f', 5, ChessPiece.Color.WHITE);
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
        assertEquals('a', pawn1.getColumn());
        assertEquals('h', pawn2.getColumn());
    }
    
    @Test
    public void testGetRow() {
        assertEquals(7, pawn1.getRow());
        assertEquals(3, pawn2.getRow());
    }
    
    @Test
    public void testGetColor() {
        assertEquals(ChessPiece.Color.BLACK, pawn1.getColor());
        assertEquals(ChessPiece.Color.WHITE, pawn2.getColor());
    }

    @Test
    public void testCanMove() {
        assertTrue(pawn1.canMove('a', 6));
        // Black movement
        // true
        assertTrue(pawnMainBlack.canMove('e', 3));
        // false
        assertFalse(pawnMainBlack.canMove('e', 5));
        assertFalse(pawnMainBlack.canMove('e', 2));
        assertFalse(pawnMainBlack.canMove('a', 5));
        assertFalse(pawnMainBlack.canMove('h', 1));
        // self false
        assertFalse(pawnMainBlack.canMove('e', 4));
        // White movement
        // true
        assertTrue(pawnMainWhite.canMove('e', 5));
        // false
        assertFalse(pawnMainWhite.canMove('e', 3));
        assertFalse(pawnMainWhite.canMove('e', 6));
        assertFalse(pawnMainWhite.canMove('c', 7));
        assertFalse(pawnMainWhite.canMove('f', 1));
        // self false
        assertFalse(pawnMainWhite.canMove('e', 4));
    }
    
    @Test
    public void testCanCapture() {
        assertFalse(pawn1.canCapture(pawn2));
        assertFalse(pawn2.canCapture(pawn1));
        // Black true captures
        assertTrue(pawnMainBlack.canCapture(pawnWhiteCapLeft));
        assertTrue(pawnMainBlack.canCapture(pawnWhiteCapRight));
        // White true captures
        assertTrue(pawnMainWhite.canCapture(pawnBlackCapLeft));
        assertTrue(pawnMainWhite.canCapture(pawnBlackCapLeft));
        
        // Black false capture wrong location
        assertFalse(pawnMainBlack.canCapture(pawnWhiteFalseCap1));
        assertFalse(pawnMainBlack.canCapture(pawnWhiteFalseCap2));
        assertFalse(pawnMainBlack.canCapture(pawnWhiteFalseCap3));
        // White false capture wrong location
        assertFalse(pawnMainWhite.canCapture(pawnBlackFalseCap1));
        assertFalse(pawnMainWhite.canCapture(pawnBlackFalseCap2));
        assertFalse(pawnMainWhite.canCapture(pawnBlackFalseCap3));
        
        // Black false capture friendly
        assertFalse(pawnMainBlack.canCapture(pawnBlackFalseCapBlkLeft));
        assertFalse(pawnMainBlack.canCapture(pawnBlackFalseCapBlkRight));
        // White false capture friendly
        assertFalse(pawnMainWhite.canCapture(pawnWhiteFalseCapWhtLeft));
        assertFalse(pawnMainWhite.canCapture(pawnWhiteFalseCapWhtRight));
    }
}
