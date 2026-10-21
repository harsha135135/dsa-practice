package practice.searching;

/**
 * Reference solution for exercise 2.1.
 *
 * <p>Split in half, sort each half (the same way, recursively), then merge the two sorted
 * halves by repeatedly taking the smaller front element.
 */
public final class MergeSort {

    private MergeSort() {
    }

    public static void sort(int[] values) {
        int[] buffer = new int[values.length];
        sort(values, buffer, 0, values.length);
    }

    /** Sorts values[from, to). */
    private static void sort(int[] values, int[] buffer, int from, int to) {
        if (to - from < 2) {
            return; // 0 or 1 element is already sorted
        }
        int middle = (from + to) >>> 1;
        sort(values, buffer, from, middle);
        sort(values, buffer, middle, to);
        merge(values, buffer, from, middle, to);
    }

    private static void merge(int[] values, int[] buffer, int from, int middle, int to) {
        int left = from;
        int right = middle;
        int out = from;
        while (left < middle && right < to) {
            // "<=" takes from the left half on ties, which keeps equal elements in order (stable)
            buffer[out++] = values[left] <= values[right] ? values[left++] : values[right++];
        }
        while (left < middle) {
            buffer[out++] = values[left++];
        }
        while (right < to) {
            buffer[out++] = values[right++];
        }
        System.arraycopy(buffer, from, values, from, to - from);
    }
}
