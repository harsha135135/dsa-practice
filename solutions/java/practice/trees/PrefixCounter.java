package practice.trees;

/**
 * Reference solution for exercise 5.4: a trie (prefix tree).
 *
 * <p>Each node stands for one prefix. {@code passing} counts the words that go through it
 * (that start with this prefix); {@code ending} counts the words that end exactly here.
 */
public final class PrefixCounter {

    private static final class Node {
        final Node[] children = new Node[26];
        int passing;
        int ending;
    }

    private final Node root = new Node();

    public void add(String word) {
        Node node = root;
        node.passing++;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
            node.passing++;
        }
        node.ending++;
    }

    public boolean contains(String word) {
        Node node = find(word);
        return node != null && node.ending > 0;
    }

    public int countWithPrefix(String prefix) {
        Node node = find(prefix);
        return node == null ? 0 : node.passing;
    }

    /** The node for this prefix, or null if no added word starts with it. */
    private Node find(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
