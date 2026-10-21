package practice.trees;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Reference solution for exercise 5.1.
 *
 * <p>The heap is a complete binary tree stored in an array: the children of index i are at
 * 2i + 1 and 2i + 2, and its parent is at (i - 1) / 2. The rule: every parent is <= its children,
 * so the smallest value is always at index 0.
 */
public final class MinHeap {

    private int[] values = new int[8];
    private int size;

    public void add(int value) {
        if (size == values.length) {
            values = Arrays.copyOf(values, size * 2);
        }
        values[size] = value;
        siftUp(size);
        size++;
    }

    public int peek() {
        requireNotEmpty();
        return values[0];
    }

    public int poll() {
        requireNotEmpty();
        int smallest = values[0];
        size--;
        values[0] = values[size]; // move the last value to the top...
        siftDown(0);              // ...and let it sink to where it belongs
        return smallest;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Swap the value at i with its parent while it is smaller than the parent. */
    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (values[parent] <= values[i]) {
                return;
            }
            swap(i, parent);
            i = parent;
        }
    }

    /** Swap the value at i with its smaller child while it is bigger than that child. */
    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            if (left >= size) {
                return;
            }
            int right = left + 1;
            int smaller = right < size && values[right] < values[left] ? right : left;
            if (values[i] <= values[smaller]) {
                return;
            }
            swap(i, smaller);
            i = smaller;
        }
    }

    private void swap(int a, int b) {
        int temporary = values[a];
        values[a] = values[b];
        values[b] = temporary;
    }

    private void requireNotEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
    }
}
