package practice.searching;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    private static final Comparator<List<Integer>> TRIPLE_ORDER = Comparator
            .<List<Integer>>comparingInt(t -> t.get(0)).thenComparingInt(t -> t.get(1)).thenComparingInt(t -> t.get(2));

    private static List<List<Integer>> triplesByTryingAll(int[] numbers) {
        TreeSet<List<Integer>> found = new TreeSet<>(TRIPLE_ORDER);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        List<Integer> triple = new ArrayList<>(List.of(numbers[i], numbers[j], numbers[k]));
                        triple.sort(null);
                        found.add(triple);
                    }
                }
            }
        }
        return new ArrayList<>(found);
    }

    @Test
    void examples() {
        assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                ThreeSum.zeroTriples(new int[] {-1, 0, 1, 2, -1, -4}));
        assertEquals(List.of(), ThreeSum.zeroTriples(new int[] {0, 1, 1}));
        assertEquals(List.of(List.of(0, 0, 0)), ThreeSum.zeroTriples(new int[] {0, 0, 0, 0}));
    }

    @Test
    void doesNotChangeTheInputArray() {
        int[] numbers = {3, -3, 0};
        ThreeSum.zeroTriples(numbers);
        assertEquals(List.of(3, -3, 0), List.of(numbers[0], numbers[1], numbers[2]));
    }

    @Test
    void agreesWithTryingEveryTripleOnRandomArrays() {
        Random random = new Random(24);
        for (int round = 0; round < 300; round++) {
            int[] numbers = random.ints(random.nextInt(25), -6, 7).toArray();

            assertEquals(triplesByTryingAll(numbers), ThreeSum.zeroTriples(numbers));
        }
    }
}
