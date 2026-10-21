package practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference solution for exercise 4.3: backtracking with pruning.
 *
 * <p>Allowing index i again (not i + 1) lets a value be reused. Because candidates are sorted,
 * once one is too big, every later one is too, so the loop can stop.
 */
public final class CombinationSum {

    private CombinationSum() {
    }

    public static List<List<Integer>> of(int[] candidates, int target) {
        int[] sorted = candidates.clone();
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        build(sorted, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void build(int[] sorted, int start, int remaining, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(List.copyOf(current));
            return;
        }
        for (int i = start; i < sorted.length && sorted[i] <= remaining; i++) {
            current.add(sorted[i]);
            build(sorted, i, remaining - sorted[i], current, result);
            current.removeLast();
        }
    }
}
