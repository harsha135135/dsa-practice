package practice.searching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    private static void assertSortsLikeJava(int[] values) {
        int[] expected = values.clone();
        Arrays.sort(expected);
        int[] actual = values.clone();

        MergeSort.sort(actual);

        assertArrayEquals(expected, actual, "input was " + Arrays.toString(values));
    }

    @Test
    void examples() {
        assertSortsLikeJava(new int[] {5, 2, 4, 6, 1, 3});
        assertSortsLikeJava(new int[] {});
        assertSortsLikeJava(new int[] {7});
        assertSortsLikeJava(new int[] {2, 2, 1, 1});
        assertSortsLikeJava(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0});
    }

    @Test
    void alreadySortedAndReversedInput() {
        assertSortsLikeJava(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        assertSortsLikeJava(new int[] {8, 7, 6, 5, 4, 3, 2, 1});
    }

    @Test
    void agreesWithJavaOnRandomArrays() {
        Random random = new Random(21);
        for (int round = 0; round < 300; round++) {
            assertSortsLikeJava(random.ints(random.nextInt(100), -50, 50).toArray());
        }
    }

    @Test
    void handlesALargeArray() {
        assertSortsLikeJava(new Random(22).ints(200_000).toArray());
    }
}
