package practice.searching;

/**
 * Reference solution for exercise 2.4: binary search on the <em>answer</em>.
 *
 * <p>If capacity c is enough, every bigger capacity is enough too. So "is c enough?" goes
 * no, no, ..., no, yes, yes, ... as c grows, and binary search finds the first yes.
 */
public final class ShipCapacity {

    private ShipCapacity() {
    }

    public static int minimum(int[] weights, int days) {
        int low = 0;
        long total = 0;
        for (int weight : weights) {
            low = Math.max(low, weight); // the ship must carry the heaviest package
            total += weight;
        }
        int high = (int) Math.min(total, Integer.MAX_VALUE); // one day for everything is always enough
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (daysNeeded(weights, middle) <= days) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    /** Fill each day greedily: start a new day only when the next package does not fit. */
    private static int daysNeeded(int[] weights, int capacity) {
        int days = 1;
        long load = 0;
        for (int weight : weights) {
            if (load + weight > capacity) {
                days++;
                load = 0;
            }
            load += weight;
        }
        return days;
    }
}
