package practice.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice.support.Lists.DICTIONARY_ORDER;

class SubsetsTest {

    /** Every number from 0 to 2^n - 1 picks a subset: bit i says whether value i is in it. */
    private static List<List<Integer>> byCountingInBinary(int[] values) {
        int[] sorted = values.clone();
        Arrays.sort(sorted);
        List<List<Integer>> all = new ArrayList<>();
        for (int mask = 0; mask < (1 << sorted.length); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < sorted.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(sorted[i]);
                }
            }
            all.add(subset);
        }
        all.sort(DICTIONARY_ORDER);
        return all;
    }

    @Test
    void example() {
        assertEquals(List.of(
                List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 3),
                List.of(1, 3), List.of(2), List.of(2, 3), List.of(3)), Subsets.of(new int[] {3, 1, 2}));
        assertEquals(List.of(List.of()), Subsets.of(new int[] {}));
    }

    @Test
    void agreesWithCountingInBinary() {
        int[] values = {9, -2, 4, 0, 7, 13, 1, 8, -5, 6};
        assertEquals(byCountingInBinary(values), Subsets.of(values));
    }
}
