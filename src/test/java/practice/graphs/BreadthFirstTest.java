package practice.graphs;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BreadthFirstTest {

    /** Floyd-Warshall: a slow but simple way to get every shortest distance. */
    private static int[] bySlowAllPairs(int n, int[][] edges, int source) {
        int infinity = Integer.MAX_VALUE / 2;
        int[][] d = new int[n][n];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                d[a][b] = a == b ? 0 : infinity;
            }
        }
        for (int[] edge : edges) {
            d[edge[0]][edge[1]] = Math.min(d[edge[0]][edge[1]], 1);
            d[edge[1]][edge[0]] = Math.min(d[edge[1]][edge[0]], 1);
        }
        for (int via = 0; via < n; via++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    d[a][b] = Math.min(d[a][b], d[a][via] + d[via][b]);
                }
            }
        }
        int[] result = new int[n];
        for (int b = 0; b < n; b++) {
            result[b] = d[source][b] >= infinity ? -1 : d[source][b];
        }
        return result;
    }

    @Test
    void example() {
        // 0 - 1 - 2     3 - 4
        //  \     /
        //    5 -
        int[][] edges = {{0, 1}, {1, 2}, {0, 5}, {5, 2}, {3, 4}};

        assertArrayEquals(new int[] {0, 1, 2, -1, -1, 1}, BreadthFirst.distances(6, edges, 0));
        assertArrayEquals(new int[] {-1, -1, -1, 1, 0, -1}, BreadthFirst.distances(6, edges, 4));
    }

    @Test
    void singleNode() {
        assertArrayEquals(new int[] {0}, BreadthFirst.distances(1, new int[][] {}, 0));
    }

    @Test
    void agreesWithTheSlowMethodOnRandomGraphs() {
        Random random = new Random(61);
        for (int round = 0; round < 200; round++) {
            int n = 1 + random.nextInt(12);
            int[][] edges = new int[random.nextInt(2 * n)][];
            for (int e = 0; e < edges.length; e++) {
                edges[e] = new int[] {random.nextInt(n), random.nextInt(n)};
            }
            int source = random.nextInt(n);

            assertArrayEquals(bySlowAllPairs(n, edges, source), BreadthFirst.distances(n, edges, source));
        }
    }
}
