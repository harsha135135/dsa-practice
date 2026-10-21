package practice.graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpreadingTest {

    /** Simulate minute by minute until nothing changes. Slow but obviously right. */
    private static int bySimulating(int[][] grid) {
        int[][] cells = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
        int minutes = 0;
        while (true) {
            int[][] next = Arrays.stream(cells).map(int[]::clone).toArray(int[][]::new);
            boolean changed = false;
            for (int r = 0; r < cells.length; r++) {
                for (int c = 0; c < cells[r].length; c++) {
                    if (cells[r][c] == 1 && (sick(cells, r - 1, c) || sick(cells, r + 1, c) || sick(cells, r, c - 1) || sick(cells, r, c + 1))) {
                        next[r][c] = 2;
                        changed = true;
                    }
                }
            }
            if (!changed) {
                break;
            }
            cells = next;
            minutes++;
        }
        boolean healthyLeft = Arrays.stream(cells).flatMapToInt(Arrays::stream).anyMatch(v -> v == 1);
        return healthyLeft ? -1 : minutes;
    }

    private static boolean sick(int[][] cells, int r, int c) {
        return r >= 0 && r < cells.length && c >= 0 && c < cells[r].length && cells[r][c] == 2;
    }

    @Test
    void examples() {
        assertEquals(4, Spreading.minutesToReachAll(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, Spreading.minutesToReachAll(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, Spreading.minutesToReachAll(new int[][] {{0, 2}}), "nothing healthy to reach");
        assertEquals(-1, Spreading.minutesToReachAll(new int[][] {{1}}), "no sick cell to start from");
    }

    @Test
    void doesNotChangeTheCallersGrid() {
        int[][] grid = {{2, 1}};
        Spreading.minutesToReachAll(grid);
        assertArrayEquals(new int[] {2, 1}, grid[0]);
    }

    @Test
    void agreesWithSimulatingOnRandomGrids() {
        Random random = new Random(65);
        for (int round = 0; round < 300; round++) {
            int[][] grid = new int[1 + random.nextInt(6)][];
            int cols = 1 + random.nextInt(6);
            for (int r = 0; r < grid.length; r++) {
                grid[r] = random.ints(cols, 0, 3).toArray();
            }
            assertEquals(bySimulating(grid), Spreading.minutesToReachAll(grid));
        }
    }
}
