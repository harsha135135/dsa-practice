package practice.arrays;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrefixSumsTest {

    @Test
    void examples() {
        PrefixSums sums = new PrefixSums(new int[] {3, -1, 4, 1, 5});

        assertEquals(3, sums.sum(0, 0));
        assertEquals(6, sums.sum(0, 2));
        assertEquals(9, sums.sum(1, 4));
        assertEquals(12, sums.sum(0, 4));
    }

    @Test
    void largeValuesDoNotOverflow() {
        PrefixSums sums = new PrefixSums(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE});

        assertEquals(2L * Integer.MAX_VALUE, sums.sum(0, 1));
    }

    @Test
    void badRangesAreRejected() {
        PrefixSums sums = new PrefixSums(new int[] {1, 2, 3});

        assertThrows(IllegalArgumentException.class, () -> sums.sum(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> sums.sum(0, 3));
        assertThrows(IllegalArgumentException.class, () -> sums.sum(2, 1));
    }

    @Test
    void matchesAddingUpByHandOnRandomArrays() {
        Random random = new Random(1);
        for (int round = 0; round < 200; round++) {
            int[] values = random.ints(1 + random.nextInt(30), -100, 100).toArray();
            PrefixSums sums = new PrefixSums(values);
            int from = random.nextInt(values.length);
            int to = from + random.nextInt(values.length - from);

            long expected = 0;
            for (int i = from; i <= to; i++) {
                expected += values[i];
            }
            assertEquals(expected, sums.sum(from, to));
        }
    }
}
