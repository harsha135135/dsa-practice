package practice.trees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrefixCounterTest {

    @Test
    void example() {
        PrefixCounter words = new PrefixCounter();
        words.add("apple");
        words.add("app");
        words.add("apply");
        words.add("bat");

        assertTrue(words.contains("app"));
        assertFalse(words.contains("ap"), "only a prefix, never added as a word");
        assertEquals(3, words.countWithPrefix("app"));
        assertEquals(1, words.countWithPrefix("apple"));
        assertEquals(0, words.countWithPrefix("cat"));
        assertEquals(4, words.countWithPrefix(""), "every word starts with the empty prefix");
    }

    @Test
    void repeatsAreCounted() {
        PrefixCounter words = new PrefixCounter();
        words.add("go");
        words.add("go");

        assertEquals(2, words.countWithPrefix("g"));
        assertTrue(words.contains("go"));
    }

    @Test
    void agreesWithCheckingEveryWordOnRandomInput() {
        Random random = new Random(54);
        PrefixCounter counter = new PrefixCounter();
        List<String> added = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            String word = randomWord(random);
            counter.add(word);
            added.add(word);
        }
        for (int i = 0; i < 2000; i++) {
            String query = randomWord(random);
            long expected = added.stream().filter(w -> w.startsWith(query)).count();
            assertEquals(expected, counter.countWithPrefix(query), "prefix " + query);
            assertEquals(added.contains(query), counter.contains(query), "word " + query);
        }
    }

    private static String randomWord(Random random) {
        StringBuilder word = new StringBuilder();
        int length = random.nextInt(5);
        for (int i = 0; i < length; i++) {
            word.append((char) ('a' + random.nextInt(3)));
        }
        return word.toString();
    }
}
