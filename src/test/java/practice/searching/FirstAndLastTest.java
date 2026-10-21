package practice.searching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FirstAndLastTest {

    private static int[] rangeByScanning(int[] sorted, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[] {first, last};
    }

    @Test
    void examples() {
        assertArrayEquals(new int[] {3, 4}, FirstAndLast.range(new int[] {5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[] {-1, -1}, FirstAndLast.range(new int[] {5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[] {-1, -1}, FirstAndLast.range(new int[] {}, 0));
        assertArrayEquals(new int[] {0, 2}, FirstAndLast.range(new int[] {4, 4, 4}, 4));
    }

    @Test
    void extremeValues() {
        int[] sorted = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertArrayEquals(new int[] {2, 3}, FirstAndLast.range(sorted, Integer.MAX_VALUE));
        assertArrayEquals(new int[] {0, 0}, FirstAndLast.range(sorted, Integer.MIN_VALUE));
    }

    @Test
    void agreesWithScanningOnRandomArrays() {
        Random random = new Random(23);
        for (int round = 0; round < 500; round++) {
            int[] sorted = random.ints(random.nextInt(30), 0, 10).toArray();
            Arrays.sort(sorted);
            int target = random.nextInt(12) - 1;

            assertArrayEquals(rangeByScanning(sorted, target), FirstAndLast.range(sorted, target));
        }
    }
}
