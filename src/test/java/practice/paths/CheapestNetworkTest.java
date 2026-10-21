package practice.paths;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheapestNetworkTest {

    /** Tries every subset of links: only possible for tiny inputs, but obviously right. */
    private static long byTryingEverySubset(int n, int[][] links) {
        long best = Long.MAX_VALUE;
        for (int mask = 0; mask < (1 << links.length); mask++) {
            int[] label = new int[n];
            for (int i = 0; i < n; i++) {
                label[i] = i;
            }
            long cost = 0;
            for (int l = 0; l < links.length; l++) {
                if ((mask & (1 << l)) != 0) {
                    cost += links[l][2];
                    int old = label[links[l][1]];
                    int target = label[links[l][0]];
                    for (int i = 0; i < n; i++) {
                        if (label[i] == old) {
                            label[i] = target;
                        }
                    }
                }
            }
            boolean allConnected = true;
            for (int i = 0; i < n; i++) {
                allConnected &= label[i] == label[0];
            }
            if (allConnected) {
                best = Math.min(best, cost);
            }
        }
        return best == Long.MAX_VALUE ? -1 : best;
    }

    @Test
    void examples() {
        assertEquals(6, CheapestNetwork.minimumCost(3, new int[][] {{0, 1, 5}, {0, 2, 6}, {1, 2, 1}}));
        assertEquals(-1, CheapestNetwork.minimumCost(4, new int[][] {{0, 1, 3}, {2, 3, 4}}), "two separate halves");
        assertEquals(0, CheapestNetwork.minimumCost(1, new int[][] {}));
    }

    @Test
    void agreesWithTryingEverySubsetOnRandomInput() {
        Random random = new Random(74);
        for (int round = 0; round < 200; round++) {
            int n = 1 + random.nextInt(5);
            int[][] links = new int[random.nextInt(9)][];
            for (int l = 0; l < links.length; l++) {
                links[l] = new int[] {random.nextInt(n), random.nextInt(n), random.nextInt(20)};
            }
            assertEquals(byTryingEverySubset(n, links), CheapestNetwork.minimumCost(n, links));
        }
    }
}
