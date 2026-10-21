package practice.lists;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LruCacheTest {

    /** A known-correct cache built on Java's LinkedHashMap, used only to check yours. */
    private static final class ReferenceCache extends LinkedHashMap<Integer, Integer> {
        private static final long serialVersionUID = 1L;
        private final int capacity;

        ReferenceCache(int capacity) {
            super(16, 0.75f, true); // true = order by most recent use
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    @Test
    void example() {
        LruCache cache = new LruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1)); // 1 is now the most recent
        cache.put(3, 3);               // drops 2, the least recent
        assertNull(cache.get(2));
        cache.put(4, 4);               // drops 1
        assertNull(cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void replacingAValueCountsAsAUse() {
        LruCache cache = new LruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10); // 1 is now the most recent
        cache.put(3, 3);  // drops 2

        assertEquals(10, cache.get(1));
        assertNull(cache.get(2));
    }

    @Test
    void capacityOne() {
        LruCache cache = new LruCache(1);
        cache.put(1, 1);
        cache.put(2, 2);

        assertNull(cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void behavesLikeTheReferenceOnRandomSteps() {
        Random random = new Random(34);
        for (int round = 0; round < 50; round++) {
            int capacity = 1 + random.nextInt(5);
            LruCache cache = new LruCache(capacity);
            ReferenceCache expected = new ReferenceCache(capacity);
            for (int step = 0; step < 500; step++) {
                int key = random.nextInt(8);
                if (random.nextBoolean()) {
                    cache.put(key, step);
                    expected.put(key, step);
                } else {
                    assertEquals(expected.get(key), cache.get(key), "get(" + key + ") at step " + step);
                }
            }
        }
    }
}
