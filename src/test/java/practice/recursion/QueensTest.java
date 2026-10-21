package practice.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueensTest {

    @Test
    void knownCountsForSmallBoards() {
        int[] expected = {1, 0, 0, 2, 10, 4, 40, 92, 352, 724};
        for (int n = 1; n <= expected.length; n++) {
            assertEquals(expected[n - 1], Queens.count(n), "n = " + n);
        }
    }

    @Test
    void twelveByTwelveFinishesQuickly() {
        assertEquals(14_200, Queens.count(12));
    }
}
