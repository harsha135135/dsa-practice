package practice.recursion;

/**
 * Reference solution for exercise 4.5: from each starting cell, try to match the word letter
 * by letter, stepping to neighbours. Mark cells in use and unmark them when backing out.
 */
public final class WordInGrid {

    private static final int[][] STEPS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private WordInGrid() {
    }

    public static boolean contains(char[][] grid, String word) {
        if (word.isEmpty()) {
            return true;
        }
        boolean[][] inUse = new boolean[grid.length][];
        for (int row = 0; row < grid.length; row++) {
            inUse[row] = new boolean[grid[row].length];
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (matchFrom(grid, word, 0, row, col, inUse)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matchFrom(char[][] grid, String word, int index, int row, int col, boolean[][] inUse) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return false;
        }
        if (inUse[row][col] || grid[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        inUse[row][col] = true;
        for (int[] step : STEPS) {
            if (matchFrom(grid, word, index + 1, row + step[0], col + step[1], inUse)) {
                inUse[row][col] = false;
                return true;
            }
        }
        inUse[row][col] = false;
        return false;
    }
}
