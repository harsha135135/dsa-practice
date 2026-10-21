package practice.trees;

/** Exercise 5.3: see topics/05-trees-heaps-tries/3-valid-bst.md */
public final class ValidBst {

    /** One node of a binary tree. */
    public record Node(int value, Node left, Node right) {

        public static Node leaf(int value) {
            return new Node(value, null, null);
        }
    }

    private ValidBst() {
    }

    /** True if every node is bigger than everything in its left subtree and smaller than everything in its right subtree. */
    public static boolean isValid(Node root) {
        throw new UnsupportedOperationException("not solved yet");
    }
}
