package practice.dp;

/**
 * Reference solution for exercise 8.1.
 *
 * <p>{@code best[c]} = the most value that fits in capacity c using the items seen so far.
 * For each item, update capacities from high to low, so the item is counted at most once.
 */
public final class Knapsack {

    private Knapsack() {
    }

    public static int bestValue(int[] weights, int[] values, int capacity) {
        int[] best = new int[capacity + 1];
        for (int item = 0; item < weights.length; item++) {
            for (int c = capacity; c >= weights[item]; c--) {
                // Either skip the item (best[c] stays), or take it (its value + the best for the space left).
                best[c] = Math.max(best[c], values[item] + best[c - weights[item]]);
            }
        }
        return best[capacity];
    }
}
