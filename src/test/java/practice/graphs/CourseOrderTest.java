package practice.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseOrderTest {

    /** Repeatedly scan for the smallest course whose prerequisites are all taken. O(n^2), but simple. */
    private static List<Integer> byRepeatedScanning(int n, int[][] prerequisites) {
        boolean[] taken = new boolean[n];
        List<Integer> order = new ArrayList<>();
        for (int round = 0; round < n; round++) {
            int pick = -1;
            for (int course = 0; course < n && pick == -1; course++) {
                if (!taken[course] && allTaken(course, prerequisites, taken)) {
                    pick = course;
                }
            }
            if (pick == -1) {
                return List.of();
            }
            taken[pick] = true;
            order.add(pick);
        }
        return order;
    }

    private static boolean allTaken(int course, int[][] prerequisites, boolean[] taken) {
        for (int[] pair : prerequisites) {
            if (pair[0] == course && !taken[pair[1]]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void examples() {
        assertEquals(List.of(0, 1), CourseOrder.order(2, new int[][] {{1, 0}}));
        assertEquals(List.of(0, 1, 2, 3), CourseOrder.order(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        assertEquals(List.of(1, 2, 0), CourseOrder.order(3, new int[][] {{0, 2}}));
        assertEquals(List.of(0, 1, 2), CourseOrder.order(3, new int[][] {}));
    }

    @Test
    void aCycleMakesItImpossible() {
        assertEquals(List.of(), CourseOrder.order(2, new int[][] {{0, 1}, {1, 0}}));
        assertEquals(List.of(), CourseOrder.order(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
        assertEquals(List.of(), CourseOrder.order(1, new int[][] {{0, 0}}), "a course cannot need itself");
    }

    @Test
    void agreesWithRepeatedScanningOnRandomInput() {
        Random random = new Random(63);
        for (int round = 0; round < 300; round++) {
            int n = 1 + random.nextInt(10);
            int[][] prerequisites = new int[random.nextInt(n + 3)][];
            for (int p = 0; p < prerequisites.length; p++) {
                prerequisites[p] = new int[] {random.nextInt(n), random.nextInt(n)};
            }
            assertEquals(byRepeatedScanning(n, prerequisites), CourseOrder.order(n, prerequisites));
        }
    }
}
