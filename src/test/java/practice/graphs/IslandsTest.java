package practice.graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IslandsTest {

    private static char[][] grid(String... rows) {
        return Arrays.stream(rows).map(String::toCharArray).toArray(char[][]::new);
    }

    @Test
    void examples() {
        assertEquals(1, Islands.count(grid("11110", "11010", "11000", "00000")));
        assertEquals(3, Islands.count(grid("11000", "11000", "00100", "00011")));
        assertEquals(0, Islands.count(grid("000")));
        assertEquals(0, Islands.count(new char[0][]));
    }

    @Test
    void diagonalNeighboursDoNotJoin() {
        assertEquals(2, Islands.count(grid("10", "01")));
    }

    @Test
    void aSnakeShapedIslandIsOneIsland() {
        assertEquals(1, Islands.count(grid("111", "001", "111", "100", "111")));
    }

    @Test
    void oneHugeIslandDoesNotOverflowTheStack() {
        char[][] land = new char[1000][1000];
        for (char[] row : land) {
            Arrays.fill(row, '1');
        }
        assertEquals(1, Islands.count(land));
    }
}
