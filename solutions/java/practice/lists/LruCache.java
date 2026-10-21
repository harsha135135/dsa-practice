package practice.lists;

import java.util.HashMap;
import java.util.Map;

/**
 * Reference solution for exercise 3.4.
 *
 * <p>A {@code HashMap} finds a key's node in O(1). A doubly linked list keeps the nodes in
 * order of use: most recent right after {@code first}, least recent right before {@code last}.
 * Moving or removing a node you already hold is O(1) in a doubly linked list.
 */
public final class LruCache {

    private static final class Node {
        final int key;
        int value;
        Node before;
        Node after;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> nodesByKey = new HashMap<>();
    // Two placeholder nodes at the ends, so adding and removing never needs a null check.
    private final Node first = new Node(0, 0);
    private final Node last = new Node(0, 0);

    public LruCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be at least 1");
        }
        this.capacity = capacity;
        first.after = last;
        last.before = first;
    }

    public Integer get(int key) {
        Node node = nodesByKey.get(key);
        if (node == null) {
            return null;
        }
        unlink(node);
        linkAtFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = nodesByKey.get(key);
        if (node != null) {
            node.value = value;
            unlink(node);
            linkAtFront(node);
            return;
        }
        node = new Node(key, value);
        nodesByKey.put(key, node);
        linkAtFront(node);
        if (nodesByKey.size() > capacity) {
            Node oldest = last.before;
            unlink(oldest);
            nodesByKey.remove(oldest.key);
        }
    }

    private void unlink(Node node) {
        node.before.after = node.after;
        node.after.before = node.before;
    }

    private void linkAtFront(Node node) {
        node.before = first;
        node.after = first.after;
        first.after.before = node;
        first.after = node;
    }
}
