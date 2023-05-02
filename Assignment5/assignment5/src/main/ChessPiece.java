package assignment5.src.main;

/**
 * Abstract class ChessPiece - contains the instance fields for a chess piece's column (a-h), row (1-8),
 * and color (WHITE or BLACK). The abstract class contains a constructor method for a ChessPiece with col,
 * row, and color parameters. Getter methods for the column, row, color, and position. The abstract methods
 * for canMove(), canCapture(), and toString() will be implemented in the concrete sublasses corresponding
 * to each chess piece.
 *
 * @author (Melvin Kuchefski)
 * @version (4.1.23)
 */

public abstract class ChessPiece
{
    public enum Color { 
        // A value for each color of a chess piece.
        BLACK, WHITE
    }
    
    // Instance fields.
    
    // Columns are represented by characters 'a' to 'h'.
    protected char col;
    
    // Rows are represented from 1 to 8.
    protected int row;
    
    // The color of this chess piece.
    protected Color color;
    
    /**
     * Constructor for ChessPiece objects.
     * 
     * @param   col the column position of the chess piece
     * @param   row the row position of the chess piece
     * @param   color   the color of the chess piece
     * @throws  IllegalArgumentException if invalid column
     * @throws  IllegalArgumentException if invalid row
     */
    public ChessPiece(char col, int row, Color color) {   
        if (col < 'a' || col > 'h') {
            throw new IllegalArgumentException("Invalid column");
        }
        if (row < 1 || row > 8) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        this.row = row;
        this.col = col;
        this.color = color;
    }
   
    /**
     * Returns the column position of the chess piece.
     * 
     * @return  column position of the chess piece
     */
    public char getColumn() {
        return col;
    }
   
    /**
     * Returns the row position of the chess piece.
     * 
     * @return  row position of the chess piece
     */
    public int getRow() {
        return row;
    }
   
    /**
     * Returns the color of the chess piece.
     * 
     * @return  color of the chess piece
     */
    public Color getColor() {
        return color;
    }
   
    /**
     * Returns a string representing the (col, row) position of the chess piece.
     * 
     * @return  string representing the (col, row) position of the chess piece
     */
    public String getPosition() {
        return String.valueOf(getColumn()) + String.valueOf(getRow());
    }
    
    /**
     * Abstract boolean method to be implemented in the concrete sublasses
     * corresponding to each chess piece. Returns true if the chess piece
     * can legally move to the given position, false otherwise.
     * 
     * @param   col column position of the chess piece
     * @param   row row position of the chess piece
     */
    public abstract boolean canMove(char col, int row);
    
    /**
     * Abstract boolean method to be implemented in the concrete sublasses
     * corresponding to each chess piece. Returns true if another given 
     * chess piece can be captured by that chess piece, false otherwise.
     * 
     * @param   piece   other chess piece object
     */
    public abstract boolean canCapture(ChessPiece piece);
    
    /**
     * Abstract boolean method to be implemented in the concrete sublasses
     * corresponding to each chess piece. Returns a string representation
     * of the chess piece's color and class.
     */
    public abstract String toString();
}
