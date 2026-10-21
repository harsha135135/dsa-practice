package practice.paths;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExtraConnectionTest {

    @Test
    void examples() {
        assertArrayEquals(new int[] {2, 3}, ExtraConnection.find(new int[][] {{1, 2}, {1, 3}, {2, 3}}));
        assertArrayEquals(new int[] {1, 4},
                ExtraConnection.find(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }

    @Test
    void theCycleCanCloseEarlyInTheList() {
        assertArrayEquals(new int[] {2, 1}, ExtraConnection.find(new int[][] {{1, 2}, {2, 1}, {2, 3}}));
    }

    /** Builds a random tree on nodes 1..n, adds one extra edge, shuffles, and checks the answer by brute force. */
    @Test
    void randomTreesWithOneExtraEdge() {
        Random random = new Random(72);
        for (int round = 0; round < 200; round++) {
            int n = 3 + random.nextInt(8);
            List<int[]> edges = new ArrayList<>();
            for (int node = 2; node <= n; node++) {
                edges.add(new int[] {1 + random.nextInt(node - 1), node});
            }
            int a = 1 + random.nextInt(n);
            int b = 1 + random.nextInt(n);
            while (b == a) {
                b = 1 + random.nextInt(n);
            }
            edges.add(new int[] {a, b});
            Collections.shuffle(edges, random);
            int[][] input = edges.toArray(int[][]::new);

            assertArrayEquals(lastEdgeWhoseRemovalLeavesATree(input), ExtraConnection.find(input));
        }
    }

    private static int[] lastEdgeWhoseRemovalLeavesATree(int[][] edges) {
        int n = edges.length;
        for (int skip = edges.length - 1; skip >= 0; skip--) {
            UnionFindForTest groups = new UnionFindForTest(n + 1);
            for (int e = 0; e < edges.length; e++) {
                if (e != skip) {
                    groups.join(edges[e][0], edges[e][1]);
                }
            }
            if (groups.groupsAmong(1, n) == 1) {
                return edges[skip];
            }
        }
        throw new AssertionError("no answer");
    }

    /** Deliberately simple, so it cannot share a bug with the code under test. */
    private static final class UnionFindForTest {
        private final int[] label;

        UnionFindForTest(int size) {
            label = new int[size];
            for (int i = 0; i < size; i++) {
                label[i] = i;
            }
        }

        void join(int a, int b) {
            int old = label[b];
            int target = label[a];
            for (int i = 0; i < label.length; i++) {
                if (label[i] == old) {
                    label[i] = target;
                }
            }
        }

        long groupsAmong(int from, int to) {
            return IntStream.rangeClosed(from, to).map(i -> label[i]).distinct().count();
        }
    }
}
