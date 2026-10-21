package practice.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BitCountsTest {

    @Test
    void examples() {
        assertArrayEquals(new int[] {0, 1, 1}, BitCounts.upTo(2));
        assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2}, BitCounts.upTo(5));
        assertArrayEquals(new int[] {0}, BitCounts.upTo(0));
    }

    @Test
    void agreesWithJavasBitCountUpToAMillion() {
        int[] ones = BitCounts.upTo(1_000_000);
        for (int i = 0; i <= 1_000_000; i++) {
            assertEquals(Integer.bitCount(i), ones[i], "number " + i);
        }
    }
}
