package practice.support;

import java.util.Comparator;
import java.util.List;

/** Test helper for comparing lists of numbers in dictionary order. */
public final class Lists {

    /** Dictionary order: compare element by element; a list that is a prefix of another comes first. */
    public static final Comparator<List<Integer>> DICTIONARY_ORDER = (a, b) -> {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            int byElement = Integer.compare(a.get(i), b.get(i));
            if (byElement != 0) {
                return byElement;
            }
        }
        return Integer.compare(a.size(), b.size());
    };

    private Lists() {
    }
}
