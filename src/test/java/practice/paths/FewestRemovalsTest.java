package practice.paths;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FewestRemovalsTest {

    /** Tries every subset to keep, and finds the biggest one with no overlaps. */
    private static int byTryingEverySubset(int[][] intervals) {
        int bestKept = 0;
        for (int mask = 0; mask < (1 << intervals.length); mask++) {
            boolean ok = true;
            for (int a = 0; a < intervals.length && ok; a++) {
                for (int b = a + 1; b < intervals.length && ok; b++) {
                    if ((mask & (1 << a)) != 0 && (mask & (1 << b)) != 0) {
                        ok = intervals[a][1] <= intervals[b][0] || intervals[b][1] <= intervals[a][0];
                    }
                }
            }
            if (ok) {
                bestKept = Math.max(bestKept, Integer.bitCount(mask));
            }
        }
        return intervals.length - bestKept;
    }

    @Test
    void examples() {
        assertEquals(1, FewestRemovals.toRemove(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(2, FewestRemovals.toRemove(new int[][] {{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(0, FewestRemovals.toRemove(new int[][] {{1, 2}, {2, 3}}), "touching is fine");
        assertEquals(0, FewestRemovals.toRemove(new int[][] {}));
    }

    @Test
    void keepingTheShortestIsNotTheRightRule() {
        // The short [4, 7] overlaps both long ones; keeping it would allow only one interval.
        assertEquals(1, FewestRemovals.toRemove(new int[][] {{1, 5}, {4, 7}, {6, 10}}));
    }

    @Test
    void agreesWithTryingEverySubsetOnRandomInput() {
        Random random = new Random(75);
        for (int round = 0; round < 300; round++) {
            int[][] intervals = new int[random.nextInt(9)][];
            for (int i = 0; i < intervals.length; i++) {
                int start = random.nextInt(10);
                intervals[i] = new int[] {start, start + 1 + random.nextInt(5)};
            }
            assertEquals(byTryingEverySubset(intervals), FewestRemovals.toRemove(intervals));
        }
    }
}
