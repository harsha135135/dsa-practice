package practice.searching;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipCapacityTest {

    private static boolean fits(int[] weights, int days, int capacity) {
        int used = 1;
        int load = 0;
        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }
            if (load + weight > capacity) {
                used++;
                load = 0;
            }
            load += weight;
        }
        return used <= days;
    }

    private static int minimumByTryingEveryCapacity(int[] weights, int days) {
        int capacity = 1;
        while (!fits(weights, days, capacity)) {
            capacity++;
        }
        return capacity;
    }

    @Test
    void examples() {
        assertEquals(15, ShipCapacity.minimum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        assertEquals(6, ShipCapacity.minimum(new int[] {3, 2, 2, 4, 1, 4}, 3));
        assertEquals(3, ShipCapacity.minimum(new int[] {1, 2, 3, 1, 1}, 4));
    }

    @Test
    void moreDaysThanPackagesStillNeedsTheHeaviestPackage() {
        assertEquals(9, ShipCapacity.minimum(new int[] {9, 1, 1}, 10));
    }

    @Test
    void largeWeightsDoNotOverflow() {
        int big = 1_000_000_000;
        assertEquals(2 * big, ShipCapacity.minimum(new int[] {big, big, big, big}, 2));
    }

    @Test
    void agreesWithTryingEveryCapacityOnRandomInput() {
        Random random = new Random(25);
        for (int round = 0; round < 300; round++) {
            int[] weights = random.ints(1 + random.nextInt(15), 1, 20).toArray();
            int days = 1 + random.nextInt(weights.length);

            assertEquals(minimumByTryingEveryCapacity(weights, days), ShipCapacity.minimum(weights, days));
        }
    }
}
