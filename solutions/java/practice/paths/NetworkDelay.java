package practice.paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Reference solution for exercise 7.3: Dijkstra's algorithm.
 *
 * <p>Always settle the unsettled node with the smallest known time. With no negative times,
 * nothing found later can beat it, so its time is final.
 */
public final class NetworkDelay {

    private record Arrival(int node, long time) {
    }

    private NetworkDelay() {
    }

    public static int timeToReachAll(int n, int[][] times, int source) {
        List<List<int[]>> outgoing = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            outgoing.add(new ArrayList<>());
        }
        for (int[] t : times) {
            outgoing.get(t[0]).add(new int[] {t[1], t[2]});
        }

        long[] best = new long[n];
        Arrays.fill(best, Long.MAX_VALUE);
        best[source] = 0;
        PriorityQueue<Arrival> queue = new PriorityQueue<>(Comparator.comparingLong(Arrival::time));
        queue.add(new Arrival(source, 0));
        while (!queue.isEmpty()) {
            Arrival arrival = queue.poll();
            if (arrival.time() > best[arrival.node()]) {
                continue; // an old, worse entry: the node was already settled with a better time
            }
            for (int[] link : outgoing.get(arrival.node())) {
                long time = arrival.time() + link[1];
                if (time < best[link[0]]) {
                    best[link[0]] = time;
                    queue.add(new Arrival(link[0], time));
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
}
