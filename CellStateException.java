/**
 * Represents an exception in which the state of the cell is not specified following the instructions.
 */
public class CellStateException extends Exception {
    public CellStateException() {
        super("There is a cell with wrong state. The state of the cell color should be 0 or 1.");
    }
}
