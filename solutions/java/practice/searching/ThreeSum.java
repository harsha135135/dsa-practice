package practice.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference solution for exercise 2.3: sort, fix the smallest number, then find the other two
 * with two pointers moving towards each other.
 */
public final class ThreeSum {

    private ThreeSum() {
    }

    public static List<List<Integer>> zeroTriples(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();

        for (int first = 0; first < sorted.length - 2; first++) {
            if (first > 0 && sorted[first] == sorted[first - 1]) {
                continue; // same smallest number as before: same triples
            }
            int left = first + 1;
            int right = sorted.length - 1;
            while (left < right) {
                long sum = (long) sorted[first] + sorted[left] + sorted[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(List.of(sorted[first], sorted[left], sorted[right]));
                    int leftValue = sorted[left];
                    while (left < right && sorted[left] == leftValue) {
                        left++; // skip repeats so each triple appears once
                    }
                }
            }
        }
        return result;
    }
}
