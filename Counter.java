/**
 * Represents a counter.
 * Counts the number of times a cell has been green for a range of {@link Generation}s.
 */
public class Counter {
    private Grid grid;

    /**
     * Constructor for the counter that creates a grid from the first three arguments.
     *
     * @param x width of the grid
     * @param y height of the grid
     * @param s Generations Zero represented in array of strings
     * @throws GridSizeException throws an exception for the grid size
     * @throws CellStateException throws an exception for the cell state
     */
    public Counter(int x, int y, String[] s) throws GridSizeException, CellStateException {
        grid = new Grid(x, y, s);
    }

    /**
     * Counts the times a cell was green during the generations
     *
     * @param x1 first coordinate of the cell
     * @param y1 second coordinate of the cell
     */
    private void countTimesGreen(int x1, int y1, int lastGenNumber) {
        int count = 0;
        Generation currentGeneration = new Generation(grid);
        //Instantiates Generations until it reaches the one needed.
        while (currentGeneration.getNumber() != lastGenNumber + 1) {
            Cell[][] cellGrid = currentGeneration.getGrid().getCellGrid();
            //Checks if the specific cell is green at the current generation.
            if (cellGrid[y1][x1].isGreen()) {
                count++;
            }
            currentGeneration = new Generation(currentGeneration);
        }
        System.out.println(count);
    }
}
