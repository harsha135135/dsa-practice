package practice.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSumTest {

    @Test
    void examples() {
        assertEquals(List.of(List.of(2, 2, 3), List.of(7)), CombinationSum.of(new int[] {2, 3, 6, 7}, 7));
        assertEquals(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)),
                CombinationSum.of(new int[] {5, 3, 2}, 8));
        assertEquals(List.of(), CombinationSum.of(new int[] {2}, 1));
        assertEquals(List.of(List.of()), CombinationSum.of(new int[] {4}, 0), "target 0: pick nothing");
    }

    @Test
    void countsMatchAKnownTotal() {
        // Ways to make 100 from coins {1, 5, 10, 25, 50}: a well-known answer, 292.
        assertEquals(292, CombinationSum.of(new int[] {1, 5, 10, 25, 50}, 100).size());
    }
}
