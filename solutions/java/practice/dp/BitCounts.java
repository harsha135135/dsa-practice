package practice.dp;

/**
 * Reference solution for exercise 8.5: reuse earlier answers.
 *
 * <p>i >> 1 is i with its last bit dropped, and it is smaller than i, so its count is already
 * known. Add 1 if the dropped bit (i & 1) was a 1.
 */
public final class BitCounts {

    private BitCounts() {
    }

    public static int[] upTo(int n) {
        int[] ones = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ones[i] = ones[i >> 1] + (i & 1);
        }
        return ones;
    }
}
