package practice.paths;

/**
 * Reference solution for exercise 7.1.
 *
 * <p>Each group is a tree, and {@code parent[x]} points towards its root, which represents the
 * group. Two tricks keep the trees flat:
 * <ul>
 *   <li><b>union by size</b>: hang the smaller tree under the bigger one;</li>
 *   <li><b>path compression</b>: after a find, point every node on the path straight at the root.</li>
 * </ul>
 */
public final class UnionFind {

    private final int[] parent;
    private final int[] size;
    private int groups;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int x = 0; x < n; x++) {
            parent[x] = x;
            size[x] = 1;
        }
        groups = n;
    }

    public int find(int x) {
        int root = x;
        while (parent[root] != root) {
            root = parent[root];
        }
        while (parent[x] != root) { // path compression
            int next = parent[x];
            parent[x] = root;
            x = next;
        }
        return root;
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (size[rootA] < size[rootB]) {
            int swap = rootA;
            rootA = rootB;
            rootB = swap;
        }
        parent[rootB] = rootA; // smaller tree under the bigger one
        size[rootA] += size[rootB];
        groups--;
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int groups() {
        return groups;
    }
}
