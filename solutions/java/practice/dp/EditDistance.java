package practice.dp;

/**
 * Reference solution for exercise 8.4.
 *
 * <p>{@code cost[i][j]} = edits to turn the first i letters of a into the first j letters of b.
 * Look at the last letters: if equal, no edit is needed for them; otherwise the last edit was a
 * replace, a delete (from a) or an insert (into a), so take the cheapest of the three plus one.
 */
public final class EditDistance {

    private EditDistance() {
    }

    public static int between(String a, String b) {
        int[][] cost = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            cost[i][0] = i; // delete all i letters
        }
        for (int j = 0; j <= b.length(); j++) {
            cost[0][j] = j; // insert all j letters
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cost[i][j] = cost[i - 1][j - 1];
                } else {
                    int replace = cost[i - 1][j - 1];
                    int delete = cost[i - 1][j];
                    int insert = cost[i][j - 1];
                    cost[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return cost[a.length()][b.length()];
    }
}
