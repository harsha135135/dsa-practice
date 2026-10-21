package practice.searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Reference solution for exercise 2.5: a sliding window. Grow the right edge; whenever the
 * window holds every kind, shrink from the left as far as possible and record the length.
 */
public final class ShortestWindow {

    private ShortestWindow() {
    }

    public static int withEveryKind(int[] values) {
        Set<Integer> distinct = new HashSet<>();
        for (int value : values) {
            distinct.add(value);
        }
        int kinds = distinct.size();
        if (kinds == 0) {
            return 0;
        }

        Map<Integer, Integer> countInWindow = new HashMap<>();
        int best = values.length;
        int left = 0;
        for (int right = 0; right < values.length; right++) {
            countInWindow.merge(values[right], 1, Integer::sum);
            while (countInWindow.size() == kinds) {
                best = Math.min(best, right - left + 1);
                int leaving = values[left++];
                if (countInWindow.merge(leaving, -1, Integer::sum) == 0) {
                    countInWindow.remove(leaving);
                }
            }
        }
        return best;
    }
}
