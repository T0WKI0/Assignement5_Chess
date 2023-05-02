package assignment5.src.main;
import java.util.*;

/**
 * The Queen class is an extention of the abstract class ChessPiece. It uses the
 * ChessPiece constructor and implements the canMove(), canCapture(), and toString()
 * methods for the Queen class.
 *
 * @author (Melvin Kuchefski)
 * @version (4.1.23)
 */

public class Queen extends ChessPiece {
    /**
     * Constructs a Queen instance with a column, row, and color.
     * 
     * @param   col the column position of the chess piece
     * @param   row the row position of the chess piece
     * @param   color   the color of the chess piece
     */
    public Queen (char col, int row, Color color) {
        super(col, row, color);
    }
        
    /**
     * Returns true if the Queen can legally move to the given position, 
     * false otherwise.
     * 
     * @param   col the column position of the chess piece
     * @param   row the row position of the chess piece
     * @return  true if Queen can legally move to the given position,
     *          false otherwise
     */
    public boolean canMove(char col, int row) {
        // illegal column and row
        if (col < 'a' || col > 'h') {
            throw new IllegalArgumentException("Invalid column");
        }
        if (row < 1 || row > 8) {
            throw new IllegalArgumentException("Invalid row");
        }
        // Movement to current position returns false
        if (col == this.col && row == this.row) {
            return false;            
        }
        
        // forward, back, and horizontal movement
        if (col == this.col || row == this.row) {
            return true;            
        }
        
        // diagonal movement
        if (Math.abs(col - this.col) == Math.abs(row - this.row)) {
            return true;
        }
        
        else {
            return false;
        }
    }
    
    /**
     * Returns true if another given chess piece can be captured legally by the Queen,
     * false otherwise.
     * 
     * @param   piece   another ChessPiece object
     * @return  true if the other given chess piece can be captured legally by Queen,
     *          false otherwise
     */
    public boolean canCapture(ChessPiece piece) {
        if (canMove(piece.getColumn(), piece.getRow()) && piece.getColor() != this.getColor()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Returns a string representing the color and type of chess piece (Queen).
     * 
     * @return string representation of the color and type of chess piece (Queen).
     */
    public String toString() {
        return (color + " " + this.getClass().getSimpleName()).toLowerCase();
    }
}
