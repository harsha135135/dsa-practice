package practice.dp;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackTest {

    private static int byTryingEverySubset(int[] weights, int[] values, int capacity) {
        int best = 0;
        for (int mask = 0; mask < (1 << weights.length); mask++) {
            int weight = 0;
            int value = 0;
            for (int i = 0; i < weights.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    weight += weights[i];
                    value += values[i];
                }
            }
            if (weight <= capacity) {
                best = Math.max(best, value);
            }
        }
        return best;
    }

    @Test
    void examples() {
        assertEquals(9, Knapsack.bestValue(new int[] {1, 3, 4, 5}, new int[] {1, 4, 5, 7}, 7), "items 3 and 4");
        assertEquals(0, Knapsack.bestValue(new int[] {5}, new int[] {10}, 4), "nothing fits");
        assertEquals(0, Knapsack.bestValue(new int[] {}, new int[] {}, 10));
    }

    @Test
    void eachItemAtMostOnce() {
        assertEquals(10, Knapsack.bestValue(new int[] {2}, new int[] {10}, 10), "not 50: the item cannot be taken five times");
    }

    @Test
    void greedyByValuePerWeightIsNotEnough() {
        // Best ratio first takes the weight-1 item (6 per unit), then nothing else fits well.
        assertEquals(22, Knapsack.bestValue(new int[] {1, 2, 3}, new int[] {6, 10, 12}, 5));
    }

    @Test
    void agreesWithTryingEverySubsetOnRandomInput() {
        Random random = new Random(81);
        for (int round = 0; round < 300; round++) {
            int n = random.nextInt(12);
            int[] weights = random.ints(n, 1, 15).toArray();
            int[] values = random.ints(n, 0, 30).toArray();
            int capacity = random.nextInt(40);

            assertEquals(byTryingEverySubset(weights, values, capacity), Knapsack.bestValue(weights, values, capacity));
        }
    }
}
