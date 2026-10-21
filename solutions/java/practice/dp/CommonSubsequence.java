package practice.dp;

/**
 * Reference solution for exercise 8.3.
 *
 * <p>{@code length[i][j]} = the answer for the first i letters of a and the first j letters of b.
 * If the last letters match, they extend the answer for both prefixes without them;
 * otherwise, drop the last letter of one string or the other and keep the better result.
 */
public final class CommonSubsequence {

    private CommonSubsequence() {
    }

    public static int longest(String a, String b) {
        int[][] length = new int[a.length() + 1][b.length() + 1]; // row 0 and column 0 stay 0: empty prefix
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                } else {
                    length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);
                }
            }
        }
        return length[a.length()][b.length()];
    }
}
