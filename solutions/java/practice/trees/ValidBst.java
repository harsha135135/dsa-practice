package practice.trees;

/**
 * Reference solution for exercise 5.3.
 *
 * <p>Checking each node only against its children is not enough: a value deep in the left
 * subtree must still be smaller than the root. So pass down the allowed range (low, high).
 */
public final class ValidBst {

    /** One node of a binary tree. */
    public record Node(int value, Node left, Node right) {

        public static Node leaf(int value) {
            return new Node(value, null, null);
        }
    }

    private ValidBst() {
    }

    public static boolean isValid(Node root) {
        return isWithin(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /** True if every value in this subtree is strictly between low and high. */
    private static boolean isWithin(Node node, long low, long high) {
        if (node == null) {
            return true;
        }
        if (node.value() <= low || node.value() >= high) {
            return false;
        }
        return isWithin(node.left(), low, node.value()) && isWithin(node.right(), node.value(), high);
    }
}
