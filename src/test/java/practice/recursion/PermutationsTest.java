package practice.recursion;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice.support.Lists.DICTIONARY_ORDER;

class PermutationsTest {

    @Test
    void examples() {
        assertEquals(List.of(
                List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)), Permutations.of(new int[] {3, 1, 2}));
        assertEquals(List.of(List.of(5)), Permutations.of(new int[] {5}));
        assertEquals(List.of(List.of()), Permutations.of(new int[] {}), "one way to order nothing");
    }

    @Test
    void sevenValuesGive5040DifferentOrderingsInDictionaryOrder() {
        List<List<Integer>> all = Permutations.of(new int[] {7, 6, 5, 4, 3, 2, 1});

        assertEquals(5040, all.size());
        assertEquals(5040, new HashSet<>(all).size(), "no repeats");
        for (int i = 1; i < all.size(); i++) {
            assertEquals(-1, Integer.signum(DICTIONARY_ORDER.compare(all.get(i - 1), all.get(i))), "in order at " + i);
        }
        for (List<Integer> ordering : all) {
            assertEquals(Set.of(1, 2, 3, 4, 5, 6, 7), new HashSet<>(ordering));
        }
    }
}
