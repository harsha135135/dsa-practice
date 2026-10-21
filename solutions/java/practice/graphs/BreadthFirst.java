package practice.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Reference solution for exercise 6.1.
 *
 * <p>Breadth-first search visits nodes in rings: first everything 1 edge away, then 2, and so
 * on. The first time a node is reached is therefore by a shortest path.
 */
public final class BreadthFirst {

    private BreadthFirst() {
    }

    public static int[] distances(int n, int[][] edges, int source) {
        List<List<Integer>> neighbours = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            neighbours.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[source] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int next : neighbours.get(node)) {
                if (distance[next] == -1) { // not reached before
                    distance[next] = distance[node] + 1;
                    queue.add(next);
                }
            }
        }
        return distance;
    }
}
