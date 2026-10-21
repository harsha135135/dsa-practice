package practice.arrays;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalancedRunTest {

    private static int longestByTryingEveryRun(int[] bits) {
        int best = 0;
        for (int from = 0; from < bits.length; from++) {
            int ones = 0;
            int zeros = 0;
            for (int to = from; to < bits.length; to++) {
                if (bits[to] == 1) {
                    ones++;
                } else {
                    zeros++;
                }
                if (ones == zeros) {
                    best = Math.max(best, to - from + 1);
                }
            }
        }
        return best;
    }

    @Test
    void examples() {
        assertEquals(2, BalancedRun.longest(new int[] {0, 1}));
        assertEquals(6, BalancedRun.longest(new int[] {0, 1, 1, 0, 1, 0, 0}));
        assertEquals(0, BalancedRun.longest(new int[] {1, 1, 1}));
        assertEquals(0, BalancedRun.longest(new int[] {}));
    }

    @Test
    void agreesWithTryingEveryRunOnRandomArrays() {
        Random random = new Random(4);
        for (int round = 0; round < 300; round++) {
            int[] bits = random.ints(random.nextInt(40), 0, 2).toArray();

            assertEquals(longestByTryingEveryRun(bits), BalancedRun.longest(bits));
        }
    }
}
