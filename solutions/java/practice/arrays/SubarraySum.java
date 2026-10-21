package practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Reference solution for exercise 1.4.
 *
 * <p>A run from i+1 to j sums to k exactly when prefix(j) - prefix(i) == k, that is when an
 * earlier prefix equal to prefix(j) - k was seen. Count how often each prefix value appeared.
 */
public final class SubarraySum {

    private SubarraySum() {
    }

    public static int count(int[] numbers, int k) {
        Map<Long, Integer> timesSeen = new HashMap<>();
        timesSeen.put(0L, 1); // the empty prefix, before the first number
        long prefix = 0;
        int count = 0;
        for (int number : numbers) {
            prefix += number;
            count += timesSeen.getOrDefault(prefix - k, 0);
            timesSeen.merge(prefix, 1, Integer::sum);
        }
        return count;
    }
}
