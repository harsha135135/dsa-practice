package practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference solution for exercise 4.2.
 *
 * <p>Every partial choice is itself a subset, so record it on the way in. Then extend it only
 * with values to the right of the last one used, which avoids repeats and keeps each subset sorted.
 */
public final class Subsets {

    private Subsets() {
    }

    public static List<List<Integer>> of(int[] values) {
        int[] sorted = values.clone();
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        build(sorted, 0, new ArrayList<>(), result);
        return result;
    }

    private static void build(int[] sorted, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(List.copyOf(current));
        for (int i = start; i < sorted.length; i++) {
            current.add(sorted[i]);
            build(sorted, i + 1, current, result);
            current.removeLast();
        }
    }
}
