package practice.trees;

import org.junit.jupiter.api.Test;
import practice.trees.ValidBst.Node;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidBstTest {

    @Test
    void valid() {
        assertTrue(ValidBst.isValid(null));
        assertTrue(ValidBst.isValid(Node.leaf(1)));
        assertTrue(ValidBst.isValid(new Node(2, Node.leaf(1), Node.leaf(3))));
        assertTrue(ValidBst.isValid(new Node(8, new Node(4, Node.leaf(2), Node.leaf(6)), new Node(12, Node.leaf(10), null))));
    }

    @Test
    void childOnTheWrongSide() {
        assertFalse(ValidBst.isValid(new Node(2, Node.leaf(3), Node.leaf(1))));
    }

    @Test
    void aGrandchildOnTheWrongSideOfTheRoot() {
        //     5
        //    / \
        //   1   6
        //      / \
        //     3   7      3 is fine next to its parent 6, but it is smaller than the root 5
        assertFalse(ValidBst.isValid(new Node(5, Node.leaf(1), new Node(6, Node.leaf(3), Node.leaf(7)))));
    }

    @Test
    void equalValuesAreNotAllowed() {
        assertFalse(ValidBst.isValid(new Node(2, Node.leaf(2), null)));
        assertFalse(ValidBst.isValid(new Node(2, null, Node.leaf(2))));
    }

    @Test
    void extremeValues() {
        assertTrue(ValidBst.isValid(new Node(0, Node.leaf(Integer.MIN_VALUE), Node.leaf(Integer.MAX_VALUE))));
        assertTrue(ValidBst.isValid(Node.leaf(Integer.MAX_VALUE)));
    }
}
