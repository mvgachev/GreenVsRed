/**
 * Represents a Generation.
 * Has a {@link Grid} and number.
 * The grid of a current Generation can be found from the previous one.
 */
public class Generation {
    private Generation previousGen;
    private int number;
    private Grid grid;

    /**
     * Constructor for the first generation
     *
     * @param grid
     */
    public Generation(Grid grid) {
        this.number = 0;
        this.grid = grid;
    }

    /**
     * Constructor for the generations after the 0th one
     *
     * @param previousGen
     */
    public Generation(Generation previousGen) {
        this.previousGen = previousGen;
        this.number = previousGen.getNumber() + 1;
        grid = getGrid();
    }

    /**
     * Returns the {@link Grid} of a specific {@link Generation}
     */
    public Grid getGrid() {
        if (grid != null) return grid;
        //If there is no Grid initialized from the constructor, create one from the previous Generation
        grid = createGridFromPrev(previousGen.getGrid());
        return grid;
    }

    /**
     * A method that creates a {@link Grid} from the previous {@link Generation}
     *
     * @param previousGrid
     */
    private Grid createGridFromPrev(Grid previousGrid) {
        Cell[][] cellGrid = previousGrid.getCellGrid();
        int y = cellGrid.length;
        int x = cellGrid[0].length;
        Cell[][] newCellGrid = new Cell[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                //Fill the new grid with cells, the color of which depends on the previous generation
                newCellGrid[i][j] = new Cell(cellGrid[i][j].getNextState(), i, j, newCellGrid);
            }
        }
        return new Grid(newCellGrid);
    }

    /**
     * @return the number of the current {@link Generation}
     */
    public int getNumber() {
        return number;
    }
}
