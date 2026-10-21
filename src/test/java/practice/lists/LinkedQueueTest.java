package practice.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedQueueTest {

    @Test
    void firstInFirstOut() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

        assertEquals(3, queue.size());
        assertEquals("a", queue.peek());
        assertEquals("a", queue.remove());
        assertEquals("b", queue.remove());
        assertEquals("c", queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    void emptyQueue() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertNull(queue.peek());
        assertThrows(NoSuchElementException.class, queue::remove);
    }

    @Test
    void canBeReusedAfterBecomingEmpty() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.add(1);
        queue.remove();
        queue.add(2);
        queue.add(3);

        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
    }

    @Test
    void behavesLikeJavasQueueOnRandomSteps() {
        Random random = new Random(31);
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        Deque<Integer> expected = new ArrayDeque<>();
        for (int step = 0; step < 10_000; step++) {
            if (random.nextInt(3) > 0) {
                queue.add(step);
                expected.addLast(step);
            } else if (!expected.isEmpty()) {
                assertEquals(expected.removeFirst(), queue.remove());
            }
            assertEquals(expected.size(), queue.size());
            assertEquals(expected.peekFirst(), queue.peek());
        }
    }
}
