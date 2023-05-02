package assignment5.src.main;
import java.util.*;

/**
 * The Pawn class is an extention of the abstract class ChessPiece. It uses the
 * ChessPiece constructor and implements the canMove(), canCapture(), and toString()
 * methods for the Pawn class.
 *
 * @author (Melvin Kuchefski)
 * @version (4.1.23)
 */

public class Pawn extends ChessPiece {
    /**
     * Constructs a Pawn instance with a column, row, and color.
     * 
     * @param   col the column position of the chess piece
     * @param   row the row position of the chess piece
     * @param   color   the color of the chess piece
     */
    public Pawn (char col, int row, Color color) {
        super(col, row, color);
    }
        
    /**
     * Returns true if the Pawn can legally move to the given position, 
     * false otherwise.
     * 
     * @param   col the column position of the chess piece
     * @param   row the row position of the chess piece
     * @return  true if Pawn can legally move to the given position,
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
        
        // forward movement for WHITE pawns
        if (row == this.row + 1 && col == this.col && this.getColor() == Color.WHITE) {
            return true;            
        }
        // forward movement for BLACK pawns
        if (row == this.row - 1 && col == this.col && this.getColor() == Color.BLACK) {
            return true;            
        }
                
        else {
            return false;
        }
    }
    
    /**
     * Returns true if another given chess piece can be captured legally by the Pawn,
     * false otherwise.
     * 
     * @param   piece   another ChessPiece object
     * @return  true if the other given chess piece can be captured legally by Pawn,
     *          false otherwise
     */
    public boolean canCapture(ChessPiece piece) {
        // WHITE pawn capture
        if ((piece.getColumn() == this.col + 1 || piece.getColumn() == this.col - 1) && 
            piece.getRow() == this.row + 1 && this.getColor() == Color.WHITE &&
            piece.getColor() != this.getColor()) {
            return true;
        }
        // BLACK pawn capture
        if ((piece.getColumn() == this.col + 1 || piece.getColumn() == this.col - 1) &&
            piece.getRow() == this.row - 1 && this.getColor() == Color.BLACK &&
            piece.getColor() != this.getColor()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Returns a string representing the color and type of chess piece (Pawn).
     * 
     * @return string representation of the color and type of chess piece (Pawn).
     */
    public String toString() {
        return (color + " " + this.getClass().getSimpleName()).toLowerCase();
    }
}
