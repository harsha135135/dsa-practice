package practice.searching;

/** Reference solution for exercise 2.2: two binary searches for the left and right edges. */
public final class FirstAndLast {

    private FirstAndLast() {
    }

    public static int[] range(int[] sorted, int target) {
        int first = firstIndexAtLeast(sorted, target);
        if (first == sorted.length || sorted[first] != target) {
            return new int[] {-1, -1};
        }
        int last = firstIndexAtLeast(sorted, target + 1L) - 1;
        return new int[] {first, last};
    }

    /** The first index whose value is >= target, or sorted.length if there is none. */
    private static int firstIndexAtLeast(int[] sorted, long target) {
        int low = 0;
        int high = sorted.length; // the answer is always in [low, high]
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (sorted[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
