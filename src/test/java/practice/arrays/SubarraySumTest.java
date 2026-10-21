package practice.arrays;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySumTest {

    private static int countByTryingEveryRun(int[] numbers, int k) {
        int count = 0;
        for (int from = 0; from < numbers.length; from++) {
            long sum = 0;
            for (int to = from; to < numbers.length; to++) {
                sum += numbers[to];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    void examples() {
        assertEquals(2, SubarraySum.count(new int[] {1, 1, 1}, 2));
        assertEquals(2, SubarraySum.count(new int[] {1, 2, 3}, 3));
        assertEquals(0, SubarraySum.count(new int[] {}, 0));
    }

    @Test
    void negativeNumbersAndZerosCount() {
        assertEquals(3, SubarraySum.count(new int[] {1, -1, 0}, 0));
        assertEquals(6, SubarraySum.count(new int[] {0, 0, 0}, 0));
    }

    @Test
    void agreesWithTryingEveryRunOnRandomArrays() {
        Random random = new Random(3);
        for (int round = 0; round < 300; round++) {
            int[] numbers = random.ints(random.nextInt(40), -5, 6).toArray();
            int k = random.nextInt(11) - 5;

            assertEquals(countByTryingEveryRun(numbers, k), SubarraySum.count(numbers, k));
        }
    }
}
