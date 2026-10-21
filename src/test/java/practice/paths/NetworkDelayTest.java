package practice.paths;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetworkDelayTest {

    /** Bellman-Ford: relax every link n - 1 times. Slower, but simple. */
    private static int byRelaxingEverything(int n, int[][] times, int source) {
        long[] best = new long[n];
        Arrays.fill(best, Long.MAX_VALUE);
        best[source] = 0;
        for (int round = 0; round < n - 1; round++) {
            for (int[] t : times) {
                if (best[t[0]] != Long.MAX_VALUE && best[t[0]] + t[2] < best[t[1]]) {
                    best[t[1]] = best[t[0]] + t[2];
                }
            }
        }
        long slowest = 0;
        for (long time : best) {
            if (time == Long.MAX_VALUE) {
                return -1;
            }
            slowest = Math.max(slowest, time);
        }
        return (int) slowest;
    }

    @Test
    void examples() {
        assertEquals(2, NetworkDelay.timeToReachAll(4, new int[][] {{1, 0, 1}, {1, 2, 1}, {2, 3, 1}}, 1));
        assertEquals(-1, NetworkDelay.timeToReachAll(2, new int[][] {{0, 1, 1}}, 1), "links go one way only");
        assertEquals(0, NetworkDelay.timeToReachAll(1, new int[][] {}, 0));
    }

    @Test
    void aLongerRouteCanBeFaster() {
        // 0 → 2 directly takes 10 minutes; 0 → 1 → 2 takes 2 + 3 = 5
        assertEquals(5, NetworkDelay.timeToReachAll(3, new int[][] {{0, 2, 10}, {0, 1, 2}, {1, 2, 3}}, 0));
    }

    @Test
    void agreesWithRelaxingEverythingOnRandomNetworks() {
        Random random = new Random(73);
        for (int round = 0; round < 300; round++) {
            int n = 1 + random.nextInt(8);
            int[][] times = new int[random.nextInt(3 * n)][];
            for (int t = 0; t < times.length; t++) {
                times[t] = new int[] {random.nextInt(n), random.nextInt(n), random.nextInt(10)};
            }
            int source = random.nextInt(n);

            assertEquals(byRelaxingEverything(n, times, source), NetworkDelay.timeToReachAll(n, times, source));
        }
    }
}
