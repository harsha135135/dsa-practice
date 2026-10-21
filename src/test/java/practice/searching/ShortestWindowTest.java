package practice.searching;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestWindowTest {

    private static int shortestByTryingEveryRun(int[] values) {
        Set<Integer> all = new HashSet<>();
        Arrays.stream(values).forEach(all::add);
        int best = values.length;
        for (int from = 0; from < values.length; from++) {
            Set<Integer> seen = new HashSet<>();
            for (int to = from; to < values.length; to++) {
                seen.add(values[to]);
                if (seen.size() == all.size()) {
                    best = Math.min(best, to - from + 1);
                    break;
                }
            }
        }
        return best;
    }

    @Test
    void examples() {
        assertEquals(3, ShortestWindow.withEveryKind(new int[] {1, 2, 2, 3, 1}));
        assertEquals(1, ShortestWindow.withEveryKind(new int[] {7, 7, 7}));
        assertEquals(4, ShortestWindow.withEveryKind(new int[] {1, 2, 3, 4}));
        assertEquals(0, ShortestWindow.withEveryKind(new int[] {}));
    }

    @Test
    void agreesWithTryingEveryRunOnRandomArrays() {
        Random random = new Random(26);
        for (int round = 0; round < 300; round++) {
            int[] values = random.ints(random.nextInt(40), 0, 5).toArray();

            assertEquals(shortestByTryingEveryRun(values), ShortestWindow.withEveryKind(values));
        }
    }
}
