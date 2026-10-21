package practice.trees;

import org.junit.jupiter.api.Test;
import practice.trees.TreeDepth.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeDepthTest {

    @Test
    void examples() {
        //     3
        //    / \
        //   9  20
        //      / \
        //     15  7
        Node tree = new Node(3, Node.leaf(9), new Node(20, Node.leaf(15), Node.leaf(7)));

        assertEquals(3, TreeDepth.maxDepth(tree));
        assertEquals(1, TreeDepth.maxDepth(Node.leaf(1)));
        assertEquals(0, TreeDepth.maxDepth(null));
    }

    @Test
    void lopsidedTree() {
        Node chain = null;
        for (int i = 0; i < 50; i++) {
            chain = new Node(i, chain, null);
        }
        assertEquals(51, TreeDepth.maxDepth(new Node(-1, Node.leaf(0), chain)), "the root plus a chain of 50");
    }
}
