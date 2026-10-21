package practice.trees;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedTest {

    private static int[] byJoiningAndSorting(int[][] arrays) {
        return Arrays.stream(arrays).flatMapToInt(Arrays::stream).sorted().toArray();
    }

    @Test
    void examples() {
        assertArrayEquals(new int[] {1, 1, 2, 3, 4, 4, 5, 6},
                MergeSorted.merge(new int[][] {{1, 4, 5}, {1, 3, 4}, {2, 6}}));
        assertArrayEquals(new int[] {}, MergeSorted.merge(new int[][] {}));
        assertArrayEquals(new int[] {7}, MergeSorted.merge(new int[][] {{}, {7}, {}}));
    }

    @Test
    void agreesWithJoiningAndSortingOnRandomInput() {
        Random random = new Random(55);
        for (int round = 0; round < 200; round++) {
            int[][] arrays = new int[random.nextInt(8)][];
            for (int a = 0; a < arrays.length; a++) {
                arrays[a] = random.ints(random.nextInt(10), -20, 20).sorted().toArray();
            }
            assertArrayEquals(byJoiningAndSorting(arrays), MergeSorted.merge(arrays));
        }
    }

    @Test
    void manyArrays() {
        Random random = new Random(56);
        int[][] arrays = new int[2000][];
        for (int a = 0; a < arrays.length; a++) {
            arrays[a] = random.ints(100).sorted().toArray();
        }
        assertArrayEquals(byJoiningAndSorting(arrays), MergeSorted.merge(arrays));
    }
}
