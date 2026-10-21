package practice.dp;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonSubsequenceTest {

    /** Plain recursion without remembering answers: exponential, so only for short strings. */
    private static int byPlainRecursion(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        String restA = a.substring(1);
        String restB = b.substring(1);
        if (a.charAt(0) == b.charAt(0)) {
            return 1 + byPlainRecursion(restA, restB);
        }
        return Math.max(byPlainRecursion(restA, b), byPlainRecursion(a, restB));
    }

    @Test
    void examples() {
        assertEquals(3, CommonSubsequence.longest("abcde", "ace"));
        assertEquals(3, CommonSubsequence.longest("abc", "abc"));
        assertEquals(0, CommonSubsequence.longest("abc", "def"));
        assertEquals(0, CommonSubsequence.longest("", "abc"));
    }

    @Test
    void agreesWithPlainRecursionOnShortRandomStrings() {
        Random random = new Random(83);
        for (int round = 0; round < 300; round++) {
            String a = randomText(random, random.nextInt(8));
            String b = randomText(random, random.nextInt(8));
            assertEquals(byPlainRecursion(a, b), CommonSubsequence.longest(a, b), a + " / " + b);
        }
    }

    @Test
    void longStringsAreFast() {
        Random random = new Random(84);
        String a = randomText(random, 3000);
        assertEquals(3000, CommonSubsequence.longest(a, a));
    }

    private static String randomText(Random random, int length) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append((char) ('a' + random.nextInt(3)));
        }
        return text.toString();
    }
}
