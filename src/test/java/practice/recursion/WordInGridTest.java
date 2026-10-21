package practice.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordInGridTest {

    private static char[][] grid(String... rows) {
        char[][] cells = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            cells[i] = rows[i].toCharArray();
        }
        return cells;
    }

    private final char[][] board = grid("ABCE", "SFCS", "ADEE");

    @Test
    void wordsThatCanBeSpelled() {
        assertTrue(WordInGrid.contains(board, "ABCCED"));
        assertTrue(WordInGrid.contains(board, "SEE"));
        assertTrue(WordInGrid.contains(board, "A"));
        assertTrue(WordInGrid.contains(board, ""));
    }

    @Test
    void aCellCannotBeUsedTwice() {
        assertFalse(WordInGrid.contains(board, "ABCB"));
    }

    @Test
    void diagonalStepsAreNotAllowed() {
        assertFalse(WordInGrid.contains(board, "AF"), "every F neighbour of an A is diagonal");
    }

    @Test
    void wordsThatAreNotThere() {
        assertFalse(WordInGrid.contains(board, "XYZ"));
        assertFalse(WordInGrid.contains(grid("AB"), "ABA"));
    }

    @Test
    void aFailedPathFreesItsCellsForOtherPaths() {
        // From the top-left A, the path A→B dead-ends; the word must still be found from the other A.
        assertTrue(WordInGrid.contains(grid("AB", "AC"), "AAC"));
        assertTrue(WordInGrid.contains(grid("CAA", "AAA", "BCD"), "AAB"));
    }
}
