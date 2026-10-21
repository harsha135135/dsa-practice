package practice.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Reference solution for exercise 6.4.
 *
 * <p>The words are nodes, and two words are joined when they differ in one letter. The graph
 * is never built in full: the neighbours of a word are found by trying every letter at every
 * position. Breadth-first search then finds the shortest chain.
 */
public final class WordLadder {

    private WordLadder() {
    }

    public static int shortest(String begin, String end, List<String> words) {
        Set<String> unused = new HashSet<>(words);
        if (!unused.contains(end)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);
        unused.remove(begin);
        int chainLength = 1;
        while (!queue.isEmpty()) {
            for (int inThisRing = queue.size(); inThisRing > 0; inThisRing--) {
                String word = queue.remove();
                if (word.equals(end)) {
                    return chainLength;
                }
                char[] letters = word.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    char original = letters[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        letters[i] = c;
                        String next = new String(letters);
                        if (unused.remove(next)) { // true only the first time a word is reached
                            queue.add(next);
                        }
                    }
                    letters[i] = original;
                }
            }
            chainLength++;
        }
        return 0;
    }
}
