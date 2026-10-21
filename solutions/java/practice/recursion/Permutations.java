package practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference solution for exercise 4.1: backtracking.
 *
 * <p>Choose a value for the next position, go deeper, then undo the choice and try the next
 * value. Trying values in sorted order produces the results in dictionary order.
 */
public final class Permutations {

    private Permutations() {
    }

    public static List<List<Integer>> of(int[] values) {
        int[] sorted = values.clone();
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        build(sorted, new boolean[sorted.length], new ArrayList<>(), result);
        return result;
    }

    private static void build(int[] sorted, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == sorted.length) {
            result.add(List.copyOf(current));
            return;
        }
        for (int i = 0; i < sorted.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;                         // choose
            current.add(sorted[i]);
            build(sorted, used, current, result);   // explore
            current.removeLast();                   // undo
            used[i] = false;
        }
    }
}
