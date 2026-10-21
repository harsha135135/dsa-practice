package practice.dp;

/**
 * Reference solution for exercise 8.2: XOR (^) all numbers together.
 *
 * <p>x ^ x == 0 and x ^ 0 == x, and the order does not matter. Every pair cancels out,
 * leaving the lone number.
 */
public final class LoneNumber {

    private LoneNumber() {
    }

    public static int find(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }
        return result;
    }
}
