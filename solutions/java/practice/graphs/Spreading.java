package practice.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Reference solution for exercise 6.5: breadth-first search that starts from <em>all</em> sick
 * cells at once (multi-source BFS). Each ring of the search is one minute.
 */
public final class Spreading {

    private static final int[][] STEPS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private Spreading() {
    }

    public static int minutesToReachAll(int[][] grid) {
        int rows = grid.length;
        int[][] cells = new int[rows][];
        Queue<int[]> queue = new ArrayDeque<>();
        int healthy = 0;
        for (int row = 0; row < rows; row++) {
            cells[row] = grid[row].clone(); // do not change the caller's grid
            for (int col = 0; col < cells[row].length; col++) {
                if (cells[row][col] == 2) {
                    queue.add(new int[] {row, col});
                } else if (cells[row][col] == 1) {
                    healthy++;
                }
            }
        }

        int minutes = 0;
        while (healthy > 0 && !queue.isEmpty()) {
            minutes++;
            for (int inThisRing = queue.size(); inThisRing > 0; inThisRing--) {
                int[] cell = queue.remove();
                for (int[] step : STEPS) {
                    int row = cell[0] + step[0];
                    int col = cell[1] + step[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cells[row].length && cells[row][col] == 1) {
                        cells[row][col] = 2;
                        healthy--;
                        queue.add(new int[] {row, col});
                    }
                }
            }
        }
        return healthy == 0 ? minutes : -1;
    }
}
