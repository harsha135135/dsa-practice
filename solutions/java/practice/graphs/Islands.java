package practice.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Reference solution for exercise 6.2.
 *
 * <p>Scan the grid. Each time unvisited land is found, that is a new island: mark all of it
 * as visited with a flood fill, so it is not counted again. The flood fill uses an explicit
 * stack instead of recursion, so a huge island cannot overflow the call stack.
 */
public final class Islands {

    private static final int[][] STEPS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private Islands() {
    }

    public static int count(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][];
        for (int row = 0; row < grid.length; row++) {
            visited[row] = new boolean[grid[row].length];
        }
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islands++;
                    floodFill(grid, visited, row, col);
                }
            }
        }
        return islands;
    }

    private static void floodFill(char[][] grid, boolean[][] visited, int startRow, int startCol) {
        Deque<int[]> toVisit = new ArrayDeque<>();
        visited[startRow][startCol] = true;
        toVisit.push(new int[] {startRow, startCol});
        while (!toVisit.isEmpty()) {
            int[] cell = toVisit.pop();
            for (int[] step : STEPS) {
                int row = cell[0] + step[0];
                int col = cell[1] + step[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length
                        && grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true; // mark when adding, so a cell is added only once
                    toVisit.push(new int[] {row, col});
                }
            }
        }
    }
}
