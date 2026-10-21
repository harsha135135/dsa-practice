package practice.lists;

import java.util.NoSuchElementException;

/**
 * Reference solution for exercise 3.1.
 *
 * <p>Keep a pointer to both ends: items are added at {@code tail} and removed at {@code head},
 * so both operations are O(1).
 */
public final class LinkedQueue<T> {

    private static final class Node<T> {
        final T item;
        Node<T> next;

        Node(T item) {
            this.item = item;
        }
    }

    private Node<T> head; // the front: removed next
    private Node<T> tail; // the back: the newest item
    private int size;

    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public T remove() {
        if (head == null) {
            throw new NoSuchElementException("queue is empty");
        }
        T item = head.item;
        head = head.next;
        if (head == null) {
            tail = null; // the queue became empty: both ends must be cleared
        }
        size--;
        return item;
    }

    public T peek() {
        return head == null ? null : head.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
