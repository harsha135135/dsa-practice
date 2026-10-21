package practice.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BalancedBracketsTest {

    @Test
    void balanced() {
        assertTrue(BalancedBrackets.isBalanced(""));
        assertTrue(BalancedBrackets.isBalanced("()[]{}"));
        assertTrue(BalancedBrackets.isBalanced("{[()()]}"));
        assertTrue(BalancedBrackets.isBalanced("int f(int[] a) { return a[0]; }"));
    }

    @Test
    void notBalanced() {
        assertFalse(BalancedBrackets.isBalanced("("));
        assertFalse(BalancedBrackets.isBalanced(")"));
        assertFalse(BalancedBrackets.isBalanced("(]"));
        assertFalse(BalancedBrackets.isBalanced("([)]"), "closed in the wrong order");
        assertFalse(BalancedBrackets.isBalanced("{[}"));
        assertFalse(BalancedBrackets.isBalanced("())("), "equal counts are not enough");
    }

    @Test
    void deepNesting() {
        assertTrue(BalancedBrackets.isBalanced("(".repeat(100_000) + ")".repeat(100_000)));
        assertFalse(BalancedBrackets.isBalanced("(".repeat(100_000) + ")".repeat(99_999)));
    }
}
