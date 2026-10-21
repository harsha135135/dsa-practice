package practice.paths;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Reference solution for exercise 7.4: Kruskal's algorithm. Take links from cheapest to most
 * expensive, and keep a link only if it joins two groups that are not yet connected.
 */
public final class CheapestNetwork {

    private CheapestNetwork() {
    }

    public static long minimumCost(int n, int[][] links) {
        int[][] byCost = links.clone();
        Arrays.sort(byCost, Comparator.comparingInt(link -> link[2]));

        UnionFind groups = new UnionFind(n);
        long total = 0;
        for (int[] link : byCost) {
            if (groups.union(link[0], link[1])) {
                total += link[2];
            }
        }
        return groups.groups() == 1 ? total : -1;
    }
}
