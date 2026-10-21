package practice.trees;

/** Reference solution for exercise 5.2: the depth of a tree is 1 + the deeper of its two subtrees. */
public final class TreeDepth {

    /** One node of a binary tree. */
    public record Node(int value, Node left, Node right) {

        public static Node leaf(int value) {
            return new Node(value, null, null);
        }
    }

    private TreeDepth() {
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left()), maxDepth(root.right()));
    }
}
