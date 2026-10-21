package practice.dp;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {

    private static int byPlainRecursion(String a, String b) {
        if (a.isEmpty()) {
            return b.length();
        }
        if (b.isEmpty()) {
            return a.length();
        }
        if (a.charAt(0) == b.charAt(0)) {
            return byPlainRecursion(a.substring(1), b.substring(1));
        }
        int replace = byPlainRecursion(a.substring(1), b.substring(1));
        int delete = byPlainRecursion(a.substring(1), b);
        int insert = byPlainRecursion(a, b.substring(1));
        return 1 + Math.min(replace, Math.min(delete, insert));
    }

    @Test
    void examples() {
        assertEquals(3, EditDistance.between("horse", "ros"));
        assertEquals(5, EditDistance.between("intention", "execution"));
        assertEquals(3, EditDistance.between("", "abc"));
        assertEquals(0, EditDistance.between("same", "same"));
    }

    @Test
    void agreesWithPlainRecursionOnShortRandomStrings() {
        Random random = new Random(85);
        for (int round = 0; round < 300; round++) {
            String a = randomText(random, random.nextInt(6));
            String b = randomText(random, random.nextInt(6));
            assertEquals(byPlainRecursion(a, b), EditDistance.between(a, b), a + " / " + b);
        }
    }

    private static String randomText(Random random, int length) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append((char) ('a' + random.nextInt(3)));
        }
        return text.toString();
    }
}
