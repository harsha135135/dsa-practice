package practice.lists;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WarmerDayTest {

    private static int[] byLookingAhead(int[] temperatures) {
        int[] wait = new int[temperatures.length];
        for (int day = 0; day < temperatures.length; day++) {
            for (int later = day + 1; later < temperatures.length; later++) {
                if (temperatures[later] > temperatures[day]) {
                    wait[day] = later - day;
                    break;
                }
            }
        }
        return wait;
    }

    @Test
    void examples() {
        assertArrayEquals(new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                WarmerDay.daysToWait(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[] {1, 1, 1, 0}, WarmerDay.daysToWait(new int[] {30, 40, 50, 60}));
        assertArrayEquals(new int[] {0, 0, 0}, WarmerDay.daysToWait(new int[] {30, 30, 30}), "equal is not warmer");
        assertArrayEquals(new int[] {}, WarmerDay.daysToWait(new int[] {}));
    }

    @Test
    void agreesWithLookingAheadOnRandomInput() {
        Random random = new Random(35);
        for (int round = 0; round < 300; round++) {
            int[] temperatures = random.ints(random.nextInt(40), 0, 10).toArray();

            assertArrayEquals(byLookingAhead(temperatures), WarmerDay.daysToWait(temperatures));
        }
    }

    @Test
    void longFallingThenRisingInputIsFast() {
        int[] temperatures = new int[200_001];
        for (int i = 0; i < 200_000; i++) {
            temperatures[i] = 200_000 - i;
        }
        temperatures[200_000] = 1_000_000;
        assertEquals(200_000, WarmerDay.daysToWait(temperatures)[0]);
    }
}
