package practice.paths;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Reference solution for exercise 7.5: greedy. Keep as many intervals as possible by always
 * keeping the one that <em>ends first</em>; it leaves the most room for the rest.
 */
public final class FewestRemovals {

    private FewestRemovals() {
    }

    public static int toRemove(int[][] intervals) {
        int[][] byEnd = intervals.clone();
        Arrays.sort(byEnd, Comparator.comparingInt(interval -> interval[1]));

        int kept = 0;
        long lastEnd = Long.MIN_VALUE;
        for (int[] interval : byEnd) {
            if (interval[0] >= lastEnd) { // starts after (or exactly when) the last kept one ends
                kept++;
                lastEnd = interval[1];
            }
        }
        return intervals.length - kept;
    }
}
