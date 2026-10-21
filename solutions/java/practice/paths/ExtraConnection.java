package practice.paths;

/**
 * Reference solution for exercise 7.2: add edges one by one. The first edge that joins two
 * nodes that are already connected closes a cycle.
 */
public final class ExtraConnection {

    private ExtraConnection() {
    }

    public static int[] find(int[][] edges) {
        UnionFind groups = new UnionFind(edges.length + 1); // nodes are numbered from 1
        for (int[] edge : edges) {
            if (!groups.union(edge[0], edge[1])) {
                return edge;
            }
        }
        throw new IllegalArgumentException("the edges contain no cycle");
    }
}
