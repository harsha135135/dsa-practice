package practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Reference solution for exercise 1.5.
 *
 * <p>Count a 1 as +1 and a 0 as -1. A run is balanced exactly when its total is 0, which
 * happens when the running total has the same value at both ends. For the longest run,
 * remember the <em>first</em> index where each running total appeared.
 */
public final class BalancedRun {

    private BalancedRun() {
    }

    public static int longest(int[] bits) {
        Map<Integer, Integer> firstIndexOfTotal = new HashMap<>();
        firstIndexOfTotal.put(0, -1); // total 0 "before" index 0
        int total = 0;
        int best = 0;
        for (int i = 0; i < bits.length; i++) {
            total += bits[i] == 1 ? 1 : -1;
            Integer first = firstIndexOfTotal.putIfAbsent(total, i);
            if (first != null) {
                best = Math.max(best, i - first);
            }
        }
        return best;
    }
}
