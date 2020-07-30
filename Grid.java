/**
 * Represents a grid of all the cells.
 */
public class Grid {
    private Cell[][] cellGrid;

    /**
     * Constructor for the grid of the first generation.
     *
     * @param x    height
     * @param y    width
     * @param grid input from the user in the form of array of strings
     * @throws GridSizeException
     * @throws CellStateException
     */
    public Grid(int x, int y, String[] grid) throws GridSizeException, CellStateException {
        if (grid.length != y) throw new GridSizeException();
        cellGrid = new Cell[y][x];
        for (int i = 0; i < y; i++) {
            if (x != grid[i].length()) throw new GridSizeException();
            for (int j = 0; j < x; j++) {
                cellGrid[i][j] = new Cell(grid[i].charAt(j), i, j, cellGrid);
            }
        }
    }

    /**
     * Second constructor for the grids of the rest generations.
     *
     * @param cellGrid
     */
    public Grid(Cell[][] cellGrid) {
        this.cellGrid = cellGrid;
    }

    /**
     * @return two dimensional array of all cells in the grid.
     */
    public Cell[][] getCellGrid() {
        return cellGrid;
    }
}