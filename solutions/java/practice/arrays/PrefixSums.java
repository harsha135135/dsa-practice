package practice.arrays;

/**
 * Reference solution for exercise 1.1.
 *
 * <p>{@code prefix[i]} is the sum of the first {@code i} values, so
 * {@code sum(from, to) = prefix[to + 1] - prefix[from]}.
 */
public final class PrefixSums {

    private final long[] prefix;

    public PrefixSums(int[] values) {
        prefix = new long[values.length + 1];
        for (int i = 0; i < values.length; i++) {
            prefix[i + 1] = prefix[i] + values[i];
        }
    }

    public long sum(int from, int to) {
        if (from < 0 || to >= prefix.length - 1 || from > to) {
            throw new IllegalArgumentException("need 0 <= from <= to < length, got from=" + from + " to=" + to);
        }
        return prefix[to + 1] - prefix[from];
    }
}
