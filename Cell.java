/**
 * Represents a Cell.
 * Has a color: green or red.
 * Belongs to a cell grid.
 */
public class Cell {
    private boolean isGreen;
    private int i, j;
    private Cell[][] cellGrid;

    /**
     * Constructor for a cell with a color parameter as a char. (Generation 0)
     *
     * @param color    the color of the cell
     * @param i        one of the coordinates of the cell
     * @param j        one of the coordinates of the cell
     * @param cellGrid the cell grid that the cell belongs to
     * @throws CellStateException
     */
    public Cell(char color, int i, int j, Cell[][] cellGrid) throws CellStateException {
        if (color == '0') {
            isGreen = false;
        } else if (color == '1') {
            isGreen = true;
        } else {
            throw new CellStateException();
        }
        this.i = i;
        this.j = j;
        this.cellGrid = cellGrid;
    }

    /**
     * Constructor for a cell with a color parameter as a boolean. (other Generations)
     *
     * @param color    the color of the cell
     * @param i        one of the coordinates of the cell
     * @param j        one of the coordinates of the cell
     * @param cellGrid the cell grid that the cell belongs to
     */
    public Cell(boolean color, int i, int j, Cell[][] cellGrid) {
        isGreen = color;
        this.i = i;
        this.j = j;
        this.cellGrid = cellGrid;
    }

    public boolean isGreen() {
        return isGreen;
    }

    /**
     * @return the number of neighbours of the cell instance that are green.
     */
    private int countGreenNeighbours() {
        int count = 0;
        int width = cellGrid.length - 1;
        int length = cellGrid[i].length - 1;
        //Check up-left corner
        if ((j > 0 && i > 0) && cellGrid[i - 1][j - 1].isGreen) {
            count++;
        }
        //Check left corner
        if (j > 0 && cellGrid[i][j - 1].isGreen) {
            count++;
        }
        //Check down-left corner
        if ((j > 0 && i < length) && cellGrid[i + 1][j - 1].isGreen) {
            count++;
        }
        //Check down corner
        if (i < length && cellGrid[i + 1][j].isGreen) {
            count++;
        }
        //Check down-right corner
        if ((j < width && i < length) && cellGrid[i + 1][j + 1].isGreen) {
            count++;
        }
        //Check right corner
        if (j < width && cellGrid[i][j + 1].isGreen) {
            count++;
        }
        //Check top-right corner
        if ((j < width && i > 0) && cellGrid[i - 1][j + 1].isGreen) {
            count++;
        }
        //Check top
        if (i > 0 && cellGrid[i - 1][j].isGreen) {
            count++;
        }
        return count;
    }

    /**
     * Check what would be the state of the cell in the next {@link Generation} using the rules given.
     *
     * @return the next color of the cell (true for green, false for red)
     */
    public boolean getNextState() {
        int greenNeighbours = countGreenNeighbours();

        if (isGreen) {
            return greenNeighbours == 2 || greenNeighbours == 3 || greenNeighbours == 6;
        } else {
            return greenNeighbours == 3 || greenNeighbours == 6;
        }
    }
}
