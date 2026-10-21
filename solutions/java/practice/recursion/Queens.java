package practice.recursion;

/**
 * Reference solution for exercise 4.4: place one queen per row, and skip any column or
 * diagonal that is already attacked.
 *
 * <p>Cells on the same "\" diagonal share row - col; on the same "/" diagonal they share
 * row + col. Three boolean arrays make every attack check O(1).
 */
public final class Queens {

    private Queens() {
    }

    public static int count(int n) {
        return place(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }

    private static int place(int row, int n, boolean[] column, boolean[] downDiagonal, boolean[] upDiagonal) {
        if (row == n) {
            return 1; // every row has a queen: one complete solution
        }
        int solutions = 0;
        for (int col = 0; col < n; col++) {
            int down = row - col + n;
            int up = row + col;
            if (column[col] || downDiagonal[down] || upDiagonal[up]) {
                continue;
            }
            column[col] = downDiagonal[down] = upDiagonal[up] = true;
            solutions += place(row + 1, n, column, downDiagonal, upDiagonal);
            column[col] = downDiagonal[down] = upDiagonal[up] = false;
        }
        return solutions;
    }
}
