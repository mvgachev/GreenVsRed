/**
 * Represents an exception in which the size of the is inputted incorrectly.
 */
public class GridSizeException extends Exception {
    public GridSizeException() {
        super("The grid size is wrongly inputted.");
    }
}
