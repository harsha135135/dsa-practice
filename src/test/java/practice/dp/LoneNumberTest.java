package practice.dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoneNumberTest {

    @Test
    void examples() {
        assertEquals(1, LoneNumber.find(new int[] {2, 2, 1}));
        assertEquals(4, LoneNumber.find(new int[] {4, 1, 2, 1, 2}));
        assertEquals(-7, LoneNumber.find(new int[] {-7}));
        assertEquals(0, LoneNumber.find(new int[] {5, 0, 5}));
    }

    @Test
    void randomShuffledPairs() {
        Random random = new Random(82);
        for (int round = 0; round < 200; round++) {
            List<Integer> numbers = new ArrayList<>();
            for (int pair = 0; pair < random.nextInt(20); pair++) {
                int value = random.nextInt();
                numbers.add(value);
                numbers.add(value);
            }
            int lone = random.nextInt();
            numbers.add(lone);
            Collections.shuffle(numbers, random);

            assertEquals(lone, LoneNumber.find(numbers.stream().mapToInt(Integer::intValue).toArray()));
        }
    }
}
