package practice.paths;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnionFindTest {

    @Test
    void example() {
        UnionFind groups = new UnionFind(5);
        assertEquals(5, groups.groups());

        assertTrue(groups.union(0, 1));
        assertTrue(groups.union(3, 4));
        assertTrue(groups.union(1, 4));
        assertFalse(groups.union(0, 3), "already together");

        assertTrue(groups.connected(0, 3));
        assertFalse(groups.connected(2, 0));
        assertEquals(2, groups.groups());
        assertEquals(groups.find(0), groups.find(4));
    }

    @Test
    void agreesWithASimpleLabelArrayOnRandomSteps() {
        Random random = new Random(71);
        int n = 50;
        UnionFind groups = new UnionFind(n);
        int[] label = new int[n]; // simple but slow: relabel a whole group on each union
        for (int i = 0; i < n; i++) {
            label[i] = i;
        }
        int expectedGroups = n;
        for (int step = 0; step < 2000; step++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            if (random.nextBoolean()) {
                boolean separate = label[a] != label[b];
                if (separate) {
                    int old = label[b];
                    for (int i = 0; i < n; i++) {
                        if (label[i] == old) {
                            label[i] = label[a];
                        }
                    }
                    expectedGroups--;
                }
                assertEquals(separate, groups.union(a, b));
            } else {
                assertEquals(label[a] == label[b], groups.connected(a, b));
            }
            assertEquals(expectedGroups, groups.groups());
        }
    }

    @Test
    void longChainsStayFast() {
        int n = 1_000_000;
        UnionFind groups = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            groups.union(i - 1, i);
        }
        assertEquals(1, groups.groups());
        assertTrue(groups.connected(0, n - 1));
    }
}
