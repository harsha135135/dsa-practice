package practice.arrays;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoSumTest {

    /** Any correct pair is accepted, so the test checks the pair instead of comparing to one answer. */
    private static void assertValidPair(int[] numbers, int target, int[] answer) {
        assertEquals(2, answer.length, "expected a pair of indexes");
        int i = answer[0];
        int j = answer[1];
        assertTrue(0 <= i && i < j && j < numbers.length, "need 0 <= i < j < length, got " + i + ", " + j);
        assertEquals(target, numbers[i] + numbers[j]);
    }

    private static boolean pairExists(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    void examples() {
        assertValidPair(new int[] {2, 7, 11, 15}, 9, TwoSum.find(new int[] {2, 7, 11, 15}, 9));
        assertValidPair(new int[] {3, 3}, 6, TwoSum.find(new int[] {3, 3}, 6));
        assertValidPair(new int[] {-4, 1, 9}, 5, TwoSum.find(new int[] {-4, 1, 9}, 5));
    }

    @Test
    void noPairGivesAnEmptyArray() {
        assertEquals(0, TwoSum.find(new int[] {1, 2, 3}, 100).length);
        assertEquals(0, TwoSum.find(new int[] {5}, 10).length, "one number cannot pair with itself");
        assertEquals(0, TwoSum.find(new int[] {}, 0).length);
    }

    @Test
    void agreesWithCheckingEveryPairOnRandomArrays() {
        Random random = new Random(2);
        for (int round = 0; round < 300; round++) {
            int[] numbers = random.ints(random.nextInt(20), -20, 20).toArray();
            int target = random.nextInt(41) - 20;

            int[] answer = TwoSum.find(numbers, target);
            if (pairExists(numbers, target)) {
                assertValidPair(numbers, target, answer);
            } else {
                assertEquals(0, answer.length);
            }
        }
    }
}
