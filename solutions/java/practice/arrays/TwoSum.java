package practice.arrays;

import java.util.HashMap;
import java.util.Map;

/** Reference solution for exercise 1.2: one pass with a map from value to the index where it was seen. */
public final class TwoSum {

    private TwoSum() {
    }

    public static int[] find(int[] numbers, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int j = 0; j < numbers.length; j++) {
            Integer i = indexByValue.get(target - numbers[j]);
            if (i != null) {
                return new int[] {i, j};
            }
            indexByValue.putIfAbsent(numbers[j], j);
        }
        return new int[0];
    }
}
