package practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Reference solution for exercise 1.3: words with the same sorted letters share a group. */
public final class GroupAnagrams {

    private GroupAnagrams() {
    }

    public static List<List<String>> group(List<String> words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            groups.computeIfAbsent(new String(letters), key -> new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            group.sort(Comparator.naturalOrder());
            result.add(group);
        }
        result.sort(Comparator.comparing(group -> group.getFirst()));
        return result;
    }
}
