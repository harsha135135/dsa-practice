package practice.trees;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Reference solution for exercise 5.5: a heap holds the current front of each array, so the
 * smallest front is always on top.
 */
public final class MergeSorted {

    /** Points at position {@code index} of array number {@code array}. */
    private record Cursor(int value, int array, int index) {
    }

    private MergeSorted() {
    }

    public static int[] merge(int[][] sortedArrays) {
        int total = 0;
        PriorityQueue<Cursor> fronts = new PriorityQueue<>(Comparator.comparingInt(Cursor::value));
        for (int a = 0; a < sortedArrays.length; a++) {
            total += sortedArrays[a].length;
            if (sortedArrays[a].length > 0) {
                fronts.add(new Cursor(sortedArrays[a][0], a, 0));
            }
        }

        int[] merged = new int[total];
        int out = 0;
        while (!fronts.isEmpty()) {
            Cursor smallest = fronts.poll();
            merged[out++] = smallest.value();
            int next = smallest.index() + 1;
            int[] array = sortedArrays[smallest.array()];
            if (next < array.length) {
                fronts.add(new Cursor(array[next], smallest.array(), next));
            }
        }
        return merged;
    }
}
