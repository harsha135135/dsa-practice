package practice.trees;

/** Exercise 5.2: see topics/05-trees-heaps-tries/2-tree-depth.md */
public final class TreeDepth {

    /** One node of a binary tree. */
    public record Node(int value, Node left, Node right) {

        public static Node leaf(int value) {
            return new Node(value, null, null);
        }
    }

    private TreeDepth() {
    }

    /** The number of nodes on the longest path from the root down to a leaf (0 for an empty tree). */
    public static int maxDepth(Node root) {
        throw new UnsupportedOperationException("not solved yet");
    }
}
