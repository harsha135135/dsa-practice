package practice.trees;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinHeapTest {

    @Test
    void returnsValuesSmallestFirst() {
        MinHeap heap = new MinHeap();
        for (int value : new int[] {5, 3, 8, 1, 9, 2, 2}) {
            heap.add(value);
        }

        assertEquals(7, heap.size());
        assertEquals(1, heap.peek());
        int[] order = new int[7];
        for (int i = 0; i < order.length; i++) {
            order[i] = heap.poll();
        }
        assertArrayEquals(new int[] {1, 2, 2, 3, 5, 8, 9}, order);
        assertTrue(heap.isEmpty());
    }

    @Test
    void emptyHeapThrows() {
        MinHeap heap = new MinHeap();

        assertThrows(NoSuchElementException.class, heap::peek);
        assertThrows(NoSuchElementException.class, heap::poll);
    }

    @Test
    void growsBeyondItsStartingSize() {
        MinHeap heap = new MinHeap();
        for (int i = 1000; i > 0; i--) {
            heap.add(i);
        }
        assertEquals(1000, heap.size());
        assertEquals(1, heap.poll());
        assertEquals(2, heap.poll());
    }

    @Test
    void behavesLikeJavasPriorityQueueOnRandomSteps() {
        Random random = new Random(51);
        MinHeap heap = new MinHeap();
        PriorityQueue<Integer> expected = new PriorityQueue<>();
        for (int step = 0; step < 20_000; step++) {
            if (random.nextInt(3) > 0) {
                int value = random.nextInt(100) - 50;
                heap.add(value);
                expected.add(value);
            } else if (!expected.isEmpty()) {
                assertEquals(expected.poll(), heap.poll(), "step " + step);
            }
            assertEquals(expected.size(), heap.size());
            if (!expected.isEmpty()) {
                assertEquals(expected.peek(), heap.peek());
            }
        }
    }
}
